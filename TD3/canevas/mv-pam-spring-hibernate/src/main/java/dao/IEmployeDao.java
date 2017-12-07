package dao;

import java.util.List;
import javax.persistence.EntityManager;
import jpa.Employe;

public interface IEmployeDao {

  // créer une nouvelle entité Employe
  Employe create(Employe employe);

  // modifier une entité Employe existante
  Employe edit(Employe employe);

  // supprimer une entité Employe
  void destroy(Employe employe);

  // chercher une entité Employe via son identifiant id
  Employe find(Long id);

  // chercher une entité Employe via son n° SS
  Employe find(String SS);

  // obtenir toutes les entités Employe
  List<Employe> findAll();

  // obtenir l'EntityManager
  EntityManager getEntityManager();

}
