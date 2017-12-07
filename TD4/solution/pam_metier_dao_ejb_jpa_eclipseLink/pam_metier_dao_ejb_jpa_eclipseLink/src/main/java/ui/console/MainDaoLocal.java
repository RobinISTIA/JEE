/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.console;
import dao.ICotisationDaoLocal;
import exception.PamException;
import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import jpa.Cotisation;

public class MainDaoLocal 
{
    public static void main(String[] args)
    {
        try 
        {
        Properties properties = new Properties();
        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
        // initialisation du contexte JNDI avec les proprietes precedentes
        InitialContext initialContext = new InitialContext(properties);
        // CotisationDao
        ICotisationDaoLocal cotisationDao = (ICotisationDaoLocal) initialContext.lookup("CotisationDaoLocal");
        List<Cotisation> cotisations = cotisationDao.findAll();
        for ( Cotisation c : cotisations) { System.out.println("Cotisation: "+c); }
        // EmployeDao
        /*
        IEmployeDao employeDao = (IEmployeDao) ctx.getBean("employeDao");
        List<Employe> employes = employeDao.findAll();
        for ( Employe e : employes) { System.out.println("Employe: "+e); }
        */
        } catch (PamException ex) 
        {
        System.err.println(String.format("L'erreur suivante s'est produite : %s", ex.getMessage()));
        return;
        }
        catch (Exception ex) {
            System.err.println(String.format("L'erreur suivante s'est produite : %s", ex));
            return;}
    }

}
