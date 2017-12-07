/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.console;
import javax.naming.NamingException;

import person.ws.Person;
import person.ws.PersonWsEjb;
import person.ws.PersonWsEjbService;

public class MainRemoteDao {
public static void main(String[] args) throws NamingException
{
try 
{
// contexte JNDI du serveur Glassfish
PersonWsEjbService service=new PersonWsEjbService();
PersonWsEjb pdao=service.getPersonWsEjbPort();
// utilisation de la dao
for (Person c : pdao.findAll()) {System.out.println(c.getName()+" "+c.getAge());}
} catch (Exception ex) {
System.err.println(String.format("L'erreur suivante s'est produite autre : %s", ex));
return;
}
}

}