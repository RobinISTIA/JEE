/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;
import dao.ICotisationDaoLocal;
import dao.IEmployeDaoLocal;
import dao.IIndemniteDao; 
import exception.PamException;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import jpa.Cotisation;
import jpa.Employe;
import jpa.Indemnite;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

public class JUnitMetierRemote 
{
static private IMetierRemote metier;

@BeforeClass
public static void init() throws NamingException
{
// log
log("init");
//VERSION OPENEJB
Properties properties = new Properties();
properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
// initialisation du contexte JNDI avec les propriÃ©tÃ©s prÃ©cÃ©dentes
InitialContext initialContext = new InitialContext(properties);

metier=(IMetierRemote)initialContext.lookup("MetierRemote");
IEmployeDaoLocal employeDao = (IEmployeDaoLocal) initialContext.lookup("EmployeDaoLocal");
ICotisationDaoLocal cotisationDao = (ICotisationDaoLocal) initialContext.lookup("CotisationDaoLocal");
IIndemniteDao indemniteDao = (IIndemniteDao) initialContext.lookup("IndemniteDaoLocal");

// on vide la base
employeDao.findAll().stream().forEach((employe) -> {employeDao.destroy(employe);});
cotisationDao.findAll().stream().forEach((cotisation) -> { cotisationDao.destroy(cotisation);});
indemniteDao.findAll().stream().forEach((indemnite) -> {indemniteDao.destroy(indemnite); });
// on la remplit
Indemnite indemnite1 = indemniteDao.create(new Indemnite(null, 1.93, 2, 12, 1, 3, 1)); 
Indemnite indemnite2 = indemniteDao.create(new Indemnite(null, 2.1,2.1,15,2,3.1,1));
// Cotisation(Long id, int version, double secu, double retraite, double csgd, double csgrds)
cotisationDao.create(new Cotisation(null, 6.15, 3.49, 7.88,9.38, 1)); 
// Employe(Long id, int version, String prenom, String nom, String ss, String adresse, String ville, String cp, Indemnite indemnite)
Employe e1=new Employe(null, "5 rue des oiseaux", "49203", "Jouveinal", "Marie", "254104940426058", 1, "St Corentin");
e1.setIndemniteId(indemnite2);
Employe ne1 = employeDao.create(e1);
Employe e2 = new Employe(null, "La brûlerie", "49014", "Laverti", "Justine", "260124402111742", 1, "St Marcel");
e2.setIndemniteId(indemnite1);
Employe ne2 = employeDao.create(e2);

}
@AfterClass
public static void terminate() 
{ 
}
// logs
static private void log(String message) 
{
System.out.println("----------- " + message); 
}
// test
@Test
public void test01() throws NamingException
{
System.out.println(metier.calculerFeuilleSalaire("254104940426058",150, 20)); 
try 
{
    System.out.println(metier.calculerFeuilleSalaire("xx", 150, 20)); 
} 
catch (PamException ex) 
{
    System.err.println(String.format("PamException[Code=%d, message=%s]",ex.getCode(), ex.getMessage())); 
}
}
@Test
public void test02() throws NamingException
{
double salaireNet=metier.calculerFeuilleSalaire("260124402111742",30, 5).getElementsSalaire().getSalaireNet();
Assert.assertEquals(72.4,salaireNet,1e-2);

}

}


