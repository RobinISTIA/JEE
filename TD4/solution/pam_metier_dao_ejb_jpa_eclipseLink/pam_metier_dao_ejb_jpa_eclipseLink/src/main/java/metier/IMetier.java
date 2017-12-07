/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import jpa.Employe;
import javax.naming.NamingException;

public interface IMetier {
// obtenir la feuille de salaire
FeuilleSalaire calculerFeuilleSalaire(String SS, double nbHeuresTravaillées, int nbJoursTravaillés ) throws NamingException;
// liste des employés
List<Employe> findAllEmployes() throws NamingException;
}