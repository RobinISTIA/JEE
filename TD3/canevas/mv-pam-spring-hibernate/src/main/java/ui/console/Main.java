/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.console;
import exception.PamException;
import metier.FeuilleSalaire;
import metier.IMetier;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
public static void main(String[] args) 
{
// données locales
final String syntaxe = "pg num_securite_sociale nb_heures_travaillées nb_jours_travaillés";
// on vérifie le nombre de paramètres

// liste des erreurs
List<String> erreurs = new ArrayList<>();
// le second paramètre doit être un nombre réel >0
if (false) //A adapter
{
erreurs.add(String.format("Le nombre d'heures travaillées [%s] est erroné", args[1]));

}
// le troisième paramètre doit être un nombre entier >0
if (false) //A adapter
{
erreurs.add(String.format("Le nombre de jours travaillés [%s] est erroné", args[2]));
}
// des erreurs ?
if(erreurs.isEmpty() == false)
{
    for (String e : erreurs)
    {
        System.out.println(e);
    }
}
// c'est bon - on peut demander la feuille de salaire
FeuilleSalaire feuilleSalaire = new FeuilleSalaire();
try 
{
// instanciation couche [metier]

// calcul de la feuille de salaire

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
output += ajouteInfo("N° de sécurité sociale de l'employé", args[0]);
output += ajouteInfo("Nombre d'heures travaillées", args[1]);
output += ajouteInfo("Nombre de jours travaillés", args[2]);
output += ajouteInfo("\nInformations Employé", "");
output += ajouteInfo("Nom", feuilleSalaire.getEmploye().getNom());
output += ajouteInfo("Prénom", feuilleSalaire.getEmploye().getPrenom());
output += ajouteInfo("Adresse", feuilleSalaire.getEmploye().getAdresse());
output += ajouteInfo("Ville", feuilleSalaire.getEmploye().getVille());
output += ajouteInfo("Code Postal", feuilleSalaire.getEmploye().getCp());
output += ajouteInfo("Indice", "" + feuilleSalaire.getEmploye().getIndemnite().getIndice());
output += ajouteInfo("\nInformations Cotisations", "");
output += ajouteInfo("CSGRDS", "" + feuilleSalaire.getCotisation().getCsgrds() + " %");
output += ajouteInfo("CSGD", "" + feuilleSalaire.getCotisation().getCsgd() + " %");
output += ajouteInfo("Retraite", "" + feuilleSalaire.getCotisation().getRetraite() + " %");
output += ajouteInfo("Sécurité sociale", "" + feuilleSalaire.getCotisation().getSecu() + " %");
output += ajouteInfo("\nInformations Indemnités", "");
output += ajouteInfo("Salaire horaire", "" + feuilleSalaire.getEmploye().getIndemnite().getBaseHeure() + " euro");
output += ajouteInfo("Entretien/jour", "" + feuilleSalaire.getEmploye().getIndemnite().getEntretienJour() + " euro");
output += ajouteInfo("Repas/jour", "" + feuilleSalaire.getEmploye().getIndemnite().getRepasJour() + " euro");
output += ajouteInfo("Congés Payés", "" + feuilleSalaire.getEmploye().getIndemnite().getIndemnitesCp() + " %");
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