/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.ICotisationDaoLocal;
import dao.IEmployeDaoLocal;
import exception.PamException; 
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.naming.NamingException;
import jpa.Cotisation;
import jpa.Employe;
import jpa.Indemnite;
/**
 *
 * @author j.fasquel
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class Metier implements IMetierLocal,IMetierRemote {
// références sur la couche [dao]: attributs automatiquement affectés à l'instanciation
@EJB
private ICotisationDaoLocal cotisationDao = null; 
@EJB
private IEmployeDaoLocal employeDao = null;
// obtenir la feuille de salaire
@Override
public FeuilleSalaire calculerFeuilleSalaire(String SS, double nbHeuresTravaillees, int nbJoursTravailles) throws NamingException
{
/*
Properties properties = new Properties();
properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
// initialisation du contexte JNDI avec les propriÃ©tÃ©s prÃ©cÃ©dentes
InitialContext initialContext = new InitialContext(properties);
// instanciation couches DAO locales
employeDao = (IEmployeDaoLocal) initialContext.lookup("EmployeDaoLocal");
cotisationDao = (ICotisationDaoLocal) initialContext.lookup("CotisationDaoLocal");
*/
try
{
Employe employe=employeDao.find(SS);
Indemnite indemnite=employe.getIndemniteId();
Cotisation cotisation = cotisationDao.findAll().get(0);
// Calculs
double salaireBase=nbHeuresTravaillees*indemnite.getBaseHeure()*(1+indemnite.getIndemnitesCp()/100);
double cotisationsSociales=salaireBase*(cotisation.getCsgd()+cotisation.getCsgrds()+cotisation.getSecu()+cotisation.getRetraite())/100;
double indemnitesEntretien=nbJoursTravailles*indemnite.getEntretienJour();
double indemnitesRepas=nbJoursTravailles*indemnite.getRepasJour();
double salaireNet=salaireBase-cotisationsSociales+indemnitesEntretien+indemnitesRepas;

ElementsSalaire elts=new ElementsSalaire(salaireBase,cotisationsSociales,indemnitesEntretien,indemnitesRepas,salaireNet);

FeuilleSalaire feuille=new FeuilleSalaire(employe,cotisation,elts);
return feuille;
}
catch (Throwable th)
{
    throw new PamException("Employe de numero SS "+ SS + " not found",101); 
}
}
// liste des employés
@Override
public List<Employe> findAllEmployes() throws NamingException

{
/*    
Properties properties = new Properties();
properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
// initialisation du contexte JNDI avec les propriÃ©tÃ©s prÃ©cÃ©dentes
InitialContext initialContext = new InitialContext(properties);
// instanciation couches DAO locales
employeDao = (IEmployeDaoLocal) initialContext.lookup("EmployeDaoLocal");
*/
return employeDao.findAll();
}
// getters et setters
//... 
}