/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pam.ws;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.naming.NamingException;
import jpa.Employe;
import metier.FeuilleSalaire;
import metier.IMetier;
import metier.IMetierLocal;

/**
 *
 * @author usrlocal
 */
@WebService
public class PamWsEjbMetier implements IMetier{

  @EJB
  private IMetierLocal metier;
  @Override
  public FeuilleSalaire calculerFeuilleSalaire(String SS, double nbHeuresTravaillées, int nbJoursTravaillés) throws NamingException {
    try{ 
      return metier.calculerFeuilleSalaire(SS, nbHeuresTravaillées, nbJoursTravaillés); 
    }
      catch (Exception ex) {
      System.err.println(String.format("L'erreur suivante s'est produite autre : %s", ex));
      return null; 
      }
  }

  @Override
  public List<Employe> findAllEmployes() throws NamingException {
    try{ 
      return metier.findAllEmployes(); 
    }
    catch (Exception ex) {
      System.err.println(String.format("L'erreur suivante s'est produite autre : %s", ex));
      return null; 
    }
  }
}
