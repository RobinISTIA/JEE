/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemple;

import javax.naming.NamingException;
import javax.persistence.EntityManager;

public interface IExemple {
// Une methode
void maMethode() throws NamingException;

EntityManager getEntityManager() throws NamingException;

}