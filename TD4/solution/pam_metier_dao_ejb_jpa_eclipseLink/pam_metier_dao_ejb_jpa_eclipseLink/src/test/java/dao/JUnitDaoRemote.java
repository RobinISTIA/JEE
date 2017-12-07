package dao;
import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import jpa.Cotisation;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitDaoRemote {
// couches dao
static private IEmployeDaoRemote employeDao;
static private IIndemniteDaoRemote indemniteDao;
static private ICotisationDaoRemote cotisationDao;

@BeforeClass
public static void init() throws Exception 
{
// log
log("init");
//VERSION OPENEJB
Properties properties = new Properties();
properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
// initialisation du contexte JNDI avec les propriÃ©tÃ©s prÃ©cÃ©dentes
InitialContext initialContext = new InitialContext(properties);
// instanciation couches DAO locales
employeDao = (IEmployeDaoRemote) initialContext.lookup("EmployeDaoRemote");
cotisationDao = (ICotisationDaoRemote) initialContext.lookup("CotisationDaoRemote");
indemniteDao = (IIndemniteDaoRemote) initialContext.lookup("IndemniteDaoRemote");
}

@AfterClass
public static void terminate() {}

@Before()
public void clean() 
{
    /*
// on vide la base
employeDao.findAll().stream().forEach((employe) -> {employeDao.destroy(employe);});
cotisationDao.findAll().stream().forEach((cotisation) -> {cotisationDao.destroy(cotisation);});
indemniteDao.findAll().stream().forEach((indemnite) -> {indemniteDao.destroy(indemnite);});
*/
}

// logs
private static void log(String message) {System.out.println("----------- " + message);}
// tests
@Test
public void test01() {
log("test01");
// liste des cotisations
List<Cotisation> cotisations = cotisationDao.findAll();
int nbCotisations = cotisations.size();
// on ajoute une cotisation
Cotisation cotisation = cotisationDao.create(new Cotisation(null, 6.15,3.49,7.88,9.39,  1));
// on la demande
cotisation = cotisationDao.find(cotisation.getId());
// vérification
Assert.assertNotNull(cotisation);
Assert.assertEquals(3.49, cotisation.getCsgrds(), 1e-6);
Assert.assertEquals(6.15, cotisation.getCsgd(), 1e-6);
Assert.assertEquals(9.39, cotisation.getSecu(), 1e-6);
Assert.assertEquals(7.88, cotisation.getRetraite(), 1e-6);
// on la modifie
cotisation.setCsgrds(-1);
cotisation.setCsgd(-1);
cotisation.setRetraite(-1);
cotisation.setSecu(-1);
Cotisation cotisation2 = cotisationDao.edit(cotisation);
// vérifications
Assert.assertEquals(cotisation.getVersion() + 1, cotisation2.getVersion());
Assert.assertEquals(-1, cotisation2.getCsgrds(), 1e-6);
Assert.assertEquals(-1, cotisation2.getCsgd(), 1e-6);
Assert.assertEquals(-1, cotisation2.getRetraite(), 1e-6);
Assert.assertEquals(-1, cotisation2.getSecu(), 1e-6);
// on demande l'élément modifié
Cotisation cotisation3 = cotisationDao.find(cotisation2.getId());
// vérifications
Assert.assertEquals(cotisation3.getVersion(), cotisation2.getVersion());
Assert.assertEquals(-1, cotisation3.getCsgrds(), 1e-6);
Assert.assertEquals(-1, cotisation3.getCsgd(), 1e-6);
Assert.assertEquals(-1, cotisation3.getRetraite(), 1e-6);
Assert.assertEquals(-1, cotisation3.getSecu(), 1e-6);
// on supprime l'élément
cotisationDao.destroy(cotisation3);
// vérifications
Cotisation cotisation4 = cotisationDao.find(cotisation3.getId());
Assert.assertNull(cotisation4);
cotisations = cotisationDao.findAll();
Assert.assertEquals(nbCotisations, cotisations.size());
}

@Test
public void test02() {
log("test02");
// on demande la liste des indemnités

// on ajoute une Indemnite indemnite

// on va chercher indemnite en base via sa clé primaire – on récupère indemnite1

// on vérifie que indemnite1 = indemnite

// on modifie l'indemnité obtenue et on persiste la modification en BD. On obtient indemnite2

// on vérifie la version de indemnite2

// on va chercher indemnite2 en base – on obtient indemnite3

// on vérifie que indemnite3 = indemnite2

// on supprime en base l'image de indemnite3

// on va chercher indemnite3 en base

// on vérifie qu'on obtient une référence null
}

@Test
public void test03() {
log("test03");
// on répète un test analogue aux précédents pour Employe
}

@Test
public void test04() 
{
log("test04");
// on teste la méthode [IEmployeDao].find(String SS)
// d'abord avec un employé existant
// puis avec un employé inexistant
}

@Test
public void test05() {
log("test05");
// on crée deux indemnités avec le même indice
// enfreint la contrainte d'unicité de l'indice
// on vérifie qu'une exception de type PamException se produit
// et qu'elle a le n° d'erreur attendu
}

@Test
public void test06() 
{
log("test06");
// on crée deux employés avec le même n° SS
// enfreint la contrainte d'unicité sur le n° SS
// on vérifie qu'une exception de type PamException se produit
// et qu'elle a le n° d'erreur attendu
}

@Test
public void test07() {
log("test07");
// on crée deux employés avec le même n° SS, le 1er avec create, le 2ème avec edit
// enfreint la contrainte d'unicité sur le n° SS
// on vérifie qu'une exception de type PamException se produit
// et qu'elle a le n° d'erreur attendu
}

@Test
public void test08() {
System.out.println("test08");
log("test08");
// supprimer un employé qui n'existe pas ne provoque pas d'exception
// il est ajouté puis détruit – on le vérifie
}

@Test
public void test09() {
log("test09");
// modifier un employé sans avoir la bonne version doit provoquer une exception
// on le vérifie
}

@Test
public void test10() {
log("test10");
// supprimer un employé sans avoir la bonne version doit provoquer une exception
// on le vérifie
}

@Test
public void test11() {
// sert à tester la méthode clean
}
}