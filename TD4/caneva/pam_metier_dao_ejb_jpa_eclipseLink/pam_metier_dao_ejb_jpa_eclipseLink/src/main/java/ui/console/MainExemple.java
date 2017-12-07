/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.console;

import exception.PamException;
import exemple.IExempleLocal;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class MainExemple 
{
    
    public static void main(String[] args)
    {
        try 
        {
        //////////////////////////////////////
        // CONTEXT
        Properties properties = new Properties();
        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
        // initialisation du contexte JNDI avec les proprietes precedentes
        InitialContext initialContext = new InitialContext(properties);
        
        //////////////////////////////////////
        // TEST ACCESS a objet de type IEXEMPLELOCAL
        IExempleLocal e = (IExempleLocal) initialContext.lookup("ExempleLocal");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        e.maMethode();
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //////////////////////////////////////
        // TEST ACCESS BASE DE DONNEES
        EntityManager em=e.getEntityManager();
        java.util.List<Object []> results = em.createNativeQuery("SELECT * FROM cotisations").getResultList();
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        results.stream().forEach((record) -> {
        //primary key (long)
        Long primarykey =  (Long) record[0];
        //CSGD (double - cf wamp)
        Double csgd = (Double) record[1];
        System.out.println("Test acces table cotisations: ID="+primarykey+", CSGD="+csgd);
        });
        
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
