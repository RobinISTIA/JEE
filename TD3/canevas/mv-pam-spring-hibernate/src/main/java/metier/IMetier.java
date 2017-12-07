package metier;

import java.util.List;
import jpa.Employe;

public interface IMetier {
  // obtenir la feuille de salaire
  FeuilleSalaire calculerFeuilleSalaire(String SS, double nbHeuresTravaillées, int nbJoursTravaillés );
  // liste des employés
  List<Employe> findAllEmployes();
}
