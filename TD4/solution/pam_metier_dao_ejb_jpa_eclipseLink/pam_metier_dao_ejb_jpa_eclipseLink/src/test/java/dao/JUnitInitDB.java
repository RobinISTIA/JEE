/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import jpa.Cotisation;
import jpa.Employe;
import jpa.Indemnite;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author j.fasquel
 */
public class JUnitInitDB {
    
static private IEmployeDao employeDao = null; 
static private ICotisationDao cotisationDao = null; 
static private IIndemniteDao indemniteDao = null;
@BeforeClass
public static void init() throws Exception 
{
//VERSION OPENEJB
Properties properties = new Properties();
properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
// initialisation du contexte JNDI avec les propriÃ©tÃ©s prÃ©cÃ©dentes
InitialContext initialContext = new InitialContext(properties);
// instanciation couches DAO locales
employeDao = (IEmployeDaoLocal) initialContext.lookup("EmployeDaoLocal");
cotisationDao = (ICotisationDaoLocal) initialContext.lookup("CotisationDaoLocal");
indemniteDao = (IIndemniteDao) initialContext.lookup("IndemniteDaoLocal");
}
@Test
public void initDB() 
{
// on la remplit
Cotisation nc = cotisationDao.create(new Cotisation(null, 6.15, 3.49, 7.88,9.38, 1));
Indemnite i1 = indemniteDao.create(new Indemnite(null, 1.93, 2, 12, 1, 3, 1));
Indemnite i2 = indemniteDao.create(new Indemnite(null, 2.1,2.1,15,2,3.1,1));
// Pour employés, on n'oublie pas d'affecter les indemnités (clé étrangères)
Employe e1=new Employe(null, "5 rue des oiseaux", "49203", "Jouveinal", "Marie", "254104940426058", 1, "St Corentin");
e1.setIndemniteId(i1);
Employe ne1 = employeDao.create(e1);
Employe e2 = new Employe(null, "La brûlerie", "49014", "Laverti", "Justine", "260124402111742", 1, "St Marcel");
e2.setIndemniteId(i2);
Employe ne2 = employeDao.create(e2);

// on l'affiche
for( Employe o : employeDao.findAll()) {System.out.println(o);}
for( Cotisation cot : cotisationDao.findAll()) {System.out.println(cot);}
for( Indemnite o : indemniteDao.findAll()) {System.out.println(o);}
}
@Before()
public void clean() 
{
// on vide la base
//for( Cotisation o : cotisationDao.findAll()) {cotisationDao.destroy(o);}
//for( Employe o : employeDao.findAll()) {employeDao.destroy(o);}
//for( Indemnite o : indemniteDao.findAll()) {indemniteDao.destroy(o);}

}
@AfterClass
public static void terminate() throws Exception 
{ }


}
