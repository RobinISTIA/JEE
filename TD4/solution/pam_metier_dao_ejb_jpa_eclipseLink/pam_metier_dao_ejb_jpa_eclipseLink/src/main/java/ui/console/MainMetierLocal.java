/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.console;
import exception.PamException;
import metier.FeuilleSalaire;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import metier.IMetierLocal;

public class MainMetierLocal {
public static void main(String[] args) 
{
// c'est bon - on peut demander la feuille de salaire
FeuilleSalaire feuilleSalaire;
try 
{
        Properties properties = new Properties();
        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
        // initialisation du contexte JNDI avec les proprietes precedentes
        InitialContext initialContext = new InitialContext(properties);
        // CotisationDao
IMetierLocal metier=(IMetierLocal)initialContext.lookup("MetierLocal");
// calcul de la feuille de salaire
feuilleSalaire=metier.calculerFeuilleSalaire("254104940426058", 150, 3);
} catch (PamException ex) 
{
System.err.println(String.format("L'erreur suivante s'est produite : %s", ex.getMessage()));
return;
} catch (Exception ex) {
System.err.println(String.format("L'erreur suivante s'est produite : %s", ex));
return;
}

// affichage détaillé
String output = "Valeurs saisies :\n";
//output += ajouteInfo("N° de sécurité sociale de l'employé", args[0]);
//output += ajouteInfo("Nombre d'heures travaillées", args[1]);
//output += ajouteInfo("Nombre de jours travaillés", args[2]);
output += ajouteInfo("\nInformations Employé", "");
output += ajouteInfo("Nom", feuilleSalaire.getEmploye().getNom());
output += ajouteInfo("Prénom", feuilleSalaire.getEmploye().getPrenom());
output += ajouteInfo("Adresse", feuilleSalaire.getEmploye().getAdresse());
output += ajouteInfo("Ville", feuilleSalaire.getEmploye().getVille());
output += ajouteInfo("Code Postal", feuilleSalaire.getEmploye().getCp());
output += ajouteInfo("Indice", "" + feuilleSalaire.getEmploye().getIndemniteId().getIndice());
output += ajouteInfo("\nInformations Cotisations", "");
output += ajouteInfo("CSGRDS", "" + feuilleSalaire.getCotisation().getCsgrds() + " %");
output += ajouteInfo("CSGD", "" + feuilleSalaire.getCotisation().getCsgd() + " %");
output += ajouteInfo("Retraite", "" + feuilleSalaire.getCotisation().getRetraite() + " %");
output += ajouteInfo("Sécurité sociale", "" + feuilleSalaire.getCotisation().getSecu() + " %");
output += ajouteInfo("\nInformations Indemnités", "");
output += ajouteInfo("Salaire horaire", "" + feuilleSalaire.getEmploye().getIndemniteId().getBaseHeure() + " euro");
output += ajouteInfo("Entretien/jour", "" + feuilleSalaire.getEmploye().getIndemniteId().getEntretienJour() + " euro");
output += ajouteInfo("Repas/jour", "" + feuilleSalaire.getEmploye().getIndemniteId().getRepasJour() + " euro");
output += ajouteInfo("Congés Payés", "" + feuilleSalaire.getEmploye().getIndemniteId().getIndemnitesCp() + " %");
output += ajouteInfo("\nInformations Salaire", "");
output += ajouteInfo("Salaire de base", "" + feuilleSalaire.getElementsSalaire().getSalaireBase() + " euro");
output += ajouteInfo("Indemnités de repas", "" + feuilleSalaire.getElementsSalaire().getIndemnitesRepas() + " euro");
output += ajouteInfo("Salaire net", "" + feuilleSalaire.getElementsSalaire().getSalaireNet() + " euro");

System.out.println(output);

}

static String ajouteInfo(String message, String valeur) {
return String.format("%s : %s\n", message, valeur);
}
}