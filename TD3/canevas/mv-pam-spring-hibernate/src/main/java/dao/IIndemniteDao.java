package dao;

import java.util.List;
import javax.persistence.EntityManager;
import jpa.Indemnite;

public interface IIndemniteDao {

  // créer une entité Indemnite
  Indemnite create(Indemnite indemnite);

  // modifier une entité Indemnite
  Indemnite edit(Indemnite indemnite);

  // supprimer une entité Indemnite
  void destroy(Indemnite indemnite);

  // rechercher une entité Indemnite via son identifiant
  Indemnite find(Long id);

  // obtenir toutes les entités Indemnite
  List<Indemnite> findAll();

  // obtenir l'EntityManager
  EntityManager getEntityManager();
}
