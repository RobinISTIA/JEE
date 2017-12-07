/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemple;

import exception.PamException; 
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author j.fasquel
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class Exemple implements IExempleLocal,IExempleRemote {
// références sur la couche [dao]: attributs automatiquement affectés à l'instanciation
@PersistenceContext
private EntityManager em;

/*
@EJB
private ICotisationDaoLocal cotisationDao = null; 
@EJB
private IEmployeDaoLocal employeDao = null;
*/
// obtenir la feuille de salaire
@Override
public void maMethode() throws NamingException    
{

try
{
System.out.println("In methode maMethode");
}
catch (Throwable th)
{
    throw new PamException("Erreur",101); 
}
}

public EntityManager getEntityManager() throws NamingException
{
    return em;
}
// getters et setters
//... 
}