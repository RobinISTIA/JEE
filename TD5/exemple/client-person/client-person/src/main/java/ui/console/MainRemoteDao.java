/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.console;
import javax.naming.InitialContext;
import dao.IPersonDaoRemote;
import java.util.Properties;
import jpa.Person;

public class MainRemoteDao {
public static void main(String[] args)
{
try 
{
    Properties prop = new Properties();
    //OPTIONAL CONFIGURATION
    prop.setProperty("java.naming.factory.initial","com.sun.enterprise.naming.SerialInitContextFactory");
    prop.setProperty("java.naming.factory.url.pkgs","com.sun.enterprise.naming");
    prop.setProperty("java.naming.factory.state","com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
    prop.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
    prop.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
    //OPTIONAL CONFIGURATION

// contexte JNDI du serveur Glassfish
InitialContext initialContext = new InitialContext(prop);
// acces a dao
IPersonDaoRemote pdao=(IPersonDaoRemote)initialContext.lookup("java:global/ejb-persons/PersonDao!dao.IPersonDaoRemote");
// utilisation de la dao
for (Person c : pdao.findAll()) {System.out.println(c);}
} catch (Exception ex) {
System.err.println(String.format("L'erreur suivante s'est produite autre : %s", ex));
return;
}
}

}