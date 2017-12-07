package dao;

import exception.PamException;
import java.util.List;
import jpa.Cotisation;
import jpa.Employe;
import jpa.Indemnite;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JUnitDao {

// couches dao
  static private IEmployeDao employeDao;
  static private IIndemniteDao indemniteDao;
  static private ICotisationDao cotisationDao;

  @BeforeClass
  public static void init() throws Exception {
    // log
    log("init");
    // configuration de l'application
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-dao.xml");
    // couches dao
    employeDao = (IEmployeDao) ctx.getBean("employeDao");
    indemniteDao = (IIndemniteDao) ctx.getBean("indemniteDao");
    cotisationDao = (ICotisationDao) ctx.getBean("cotisationDao");
  }

  @AfterClass
  public static void terminate() {
  }

  @Before()
  public void clean() {
    // on vide la base
    employeDao.findAll().stream().forEach((employe) -> {
      employeDao.destroy(employe);
    });
    cotisationDao.findAll().stream().forEach((cotisation) -> {
      cotisationDao.destroy(cotisation);
    });
    indemniteDao.findAll().stream().forEach((indemnite) -> {
      indemniteDao.destroy(indemnite);
    });

  }

  // logs
  private static void log(String message) {
    System.out.println("----------- " + message);
  }


  @Test
  public void test05() {
    log("test05");
    // on crée deux indemnités avec le même indice
    // enfreint la contrainte d'unicité de l'indice
    boolean erreur = true;
    Indemnite indemnite1 = null;
    Throwable th = null;
    try {
      indemnite1 = indemniteDao.create(new Indemnite(null, 1, 1, 1.93, 2, 3, 12));
      indemniteDao.create(new Indemnite(null, 1, 1, 1.93, 2, 3, 12));
      erreur = false;
    } catch (PamException ex) {
      th = ex;
      // vérifications
      Assert.assertEquals(31, ex.getCode());
    } catch (Throwable th1) {
      th = th1;
    }
    // vérifications
    Assert.assertTrue(erreur);
    // chaîne des exceptions
    System.out.println("Chaîne des exceptions --------------------------------------");
    System.out.println(th.getClass().getName());
    while (th.getCause() != null) {
      th = th.getCause();
      System.out.println(th.getClass().getName());
    }
    // la 1ère indemnité a du être persistée
    Indemnite indemnite = indemniteDao.find(indemnite1.getId());
    // vérification
    Assert.assertNotNull(indemnite);
    Assert.assertEquals(1, indemnite.getIndice());
    Assert.assertEquals(1.93, indemnite.getBaseHeure(), 1e-6);
    Assert.assertEquals(2, indemnite.getEntretienJour(), 1e-6);
    Assert.assertEquals(3, indemnite.getRepasJour(), 1e-6);
    Assert.assertEquals(12, indemnite.getIndemnitesCp(), 1e-6);
    // la seconde indemnité n'a pas du être persistée
    List<Indemnite> indemnites = indemniteDao.findAll();
    int nbIndemnites = indemnites.size();
    Assert.assertEquals(1, nbIndemnites);
  }

  @Test
  public void test06() {
    log("test06");
    // on crée deux employés avec le même n° SS
    // enfreint la contrainte d'unicité sur le n° SS
    boolean erreur = true;
    Employe employe1 = null;
    Indemnite indemnite1 = null;
    Indemnite indemnite2;
    Throwable th = null;
    try {
      indemnite1 = indemniteDao.create(new Indemnite(null, 1, 1, 1.93, 2, 3, 12));
      indemnite2 = indemniteDao.create(new Indemnite(null, 1, 2, 2.1, 2.1, 3.1, 15));
      employe1 = employeDao.create(new Employe(null, 1, "Marie", "Jouveinal", "254104940426058", "5 rue des oiseaux", "St Corentin", "49203", indemnite1));
      employeDao.create(new Employe(null, 1, "Marie", "Jouveinal", "254104940426058", "5 rue des oiseaux", "St Corentin", "49203", indemnite2));
      erreur = false;
    } catch (PamException ex) {
      th = ex;
      // vérifications
      Assert.assertEquals(21, ex.getCode());
    } catch (Throwable th1) {
      th = th1;
    }
    // vérifications
    Assert.assertTrue(erreur);
    // chaîne des exceptions
    System.out.println("Chaîne des exceptions --------------------------------------");
    System.out.println(th.getClass().getName());
    while (th.getCause() != null) {
      th = th.getCause();
      System.out.println(th.getClass().getName());
    }
    // le 1er employé a du être persisté
    Employe employe = employeDao.find(employe1.getSs());
    // vérification
    Assert.assertNotNull(employe);
    Assert.assertEquals("254104940426058", employe.getSs());
    Assert.assertEquals("Jouveinal", employe.getNom());
    Assert.assertEquals("Marie", employe.getPrenom());
    Assert.assertEquals("5 rue des oiseaux", employe.getAdresse());
    Assert.assertEquals("St Corentin", employe.getVille());
    Assert.assertEquals("49203", employe.getCp());
    Assert.assertEquals(indemnite1, employe.getIndemnite());
    // le 2ème employé n'a pas du être persisté
    List<Employe> employes = employeDao.findAll();
    int nbEmployes = employes.size();
    Assert.assertEquals(1, nbEmployes);
  }

  @Test
  public void test07() {
    log("test07");
    // on crée deux employés avec le même n° SS (le second avec edit au lieu de create)
    // enfreint la contrainte d'unicité sur le n° SS
    boolean erreur = true;
    Employe employe1 = null;
    Indemnite indemnite1 = null;
    Indemnite indemnite2;
    Throwable th = null;
    try {
      indemnite1 = new Indemnite(null, 1, 1, 1.93, 2, 3, 12);
      indemnite2 = new Indemnite(null, 1, 2, 2.1, 2.1, 3.1, 15);
      indemnite1 = indemniteDao.create(indemnite1);
      indemnite2 = indemniteDao.create(indemnite2);
      employe1 = employeDao.create(new Employe(null, 1, "Marie", "Jouveinal", "254104940426058", "5 rue des oiseaux", "St Corentin", "49203", indemnite1));
      employeDao.edit(new Employe(null, 1, "Marie", "Jouveinal", "254104940426058", "5 rue des oiseaux", "St Corentin", "49203", indemnite2));
      erreur = false;
    } catch (PamException ex) {
      th = ex;
      // vérifications
      Assert.assertEquals(22, ex.getCode());
    } catch (Throwable th1) {
      th = th1;
    }
    // vérifications
    Assert.assertTrue(erreur);
    // chaîne des exceptions
    System.out.println("Chaîne des exceptions --------------------------------------");
    System.out.println(th.getClass().getName());
    while (th.getCause() != null) {
      th = th.getCause();
      System.out.println(th.getClass().getName());
    }
    // le 1er employé a du être persisté
    Employe employe = employeDao.find(employe1.getSs());
    // vérification
    Assert.assertNotNull(employe);
    Assert.assertEquals("254104940426058", employe.getSs());
    Assert.assertEquals("Jouveinal", employe.getNom());
    Assert.assertEquals("Marie", employe.getPrenom());
    Assert.assertEquals("5 rue des oiseaux", employe.getAdresse());
    Assert.assertEquals("St Corentin", employe.getVille());
    Assert.assertEquals("49203", employe.getCp());
    Assert.assertEquals(indemnite1, employe.getIndemnite());
    // le 2ème employé n'a pas du être persisté
    List<Employe> employes = employeDao.findAll();
    int nbEmployes = employes.size();
    Assert.assertEquals(1, nbEmployes);
  }

  @Test
  public void test08() {
    log("test08");
    // supprimer un employé qui n'existe pas ne provoque pas d'exception
    // il est ajouté puis détruit
    int code = 0;
    Throwable th = null;
    try {
      Indemnite indemnite1 = new Indemnite(null, 1, 1, 1.93, 2, 3, 12);
      indemnite1 = indemniteDao.create(indemnite1);
      indemniteDao.destroy(indemnite1);
      //employeDao.destroy(new Employe("xyz", "Jouveinal", "Marie", "5 rue des oiseaux", "St Corentin", "49203", indemnite1));
    } catch (PamException ex) {
      code = ex.getCode();
    }
    // vérifications
    Assert.assertEquals(0, code);
  }

  @Test
  public void test09() {
    log("test09");
    // modifier un employé sans avoir la bonne version
    int code = 0;
    Throwable th = null;
    try {
      Indemnite indemnite1 = new Indemnite(null, 1, 1, 1.93, 2, 3, 12);
      indemnite1 = indemniteDao.create(indemnite1);
      Employe employe1 = new Employe(null, 1, "Marie", "Jouveinal", "xyz", "5 rue des oiseaux", "St Corentin", "49203", indemnite1);
      employe1 = employeDao.create(employe1);
      employe1.setSs("ttt");
      employeDao.edit(employe1);
      employe1.setSs("abcd");
      employeDao.edit(employe1);
    } catch (PamException ex) {
      code = ex.getCode();
      th = ex.getCause();
    }
    // vérifications
    Assert.assertEquals(22, code);
    Assert.assertEquals("javax.persistence.OptimisticLockException", th.getClass().getName());
  }

  @Test
  public void test10() {
    log("test10");
    // supprimer un employé sans avoir la bonne version
    int code = 0;
    Throwable th = null;
    try {
      Indemnite indemnite1 = new Indemnite(null, 1, 1, 1.93, 2, 3, 12);
      indemnite1 = indemniteDao.create(indemnite1);
      Employe employe1 = new Employe(null, 1, "Marie", "Jouveinal", "xyz", "5 rue des oiseaux", "St Corentin", "49203", indemnite1);
      employe1 = employeDao.create(employe1);
      employe1.setSs("ttt");
      employeDao.edit(employe1);
      employeDao.destroy(employe1);
    } catch (PamException ex) {
      code = ex.getCode();
      th = ex.getCause();
    }
    // vérifications
    Assert.assertEquals(23, code);
    Assert.assertEquals("javax.persistence.OptimisticLockException", th.getClass().getName());
  }

  @Test
  public void test11() {
    // sert à tester la méthode clean
  }
}
