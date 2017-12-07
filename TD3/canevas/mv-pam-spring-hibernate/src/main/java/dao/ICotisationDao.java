package dao;

import java.util.List;
import javax.persistence.EntityManager;
import jpa.Cotisation;

public interface ICotisationDao {

  // créer une nouvelle cotisation
  Cotisation create(Cotisation cotisation);

  // modifier une cotisation existante
  Cotisation edit(Cotisation cotisation);

  // supprimer une cotisation existante
  void destroy(Cotisation cotisation);

  // chercher une cotisation particulière
  Cotisation find(Long id);

  // obtenir tous les objets Cotisation
  List<Cotisation> findAll();

  // obtenir l'EntityManager
  EntityManager getEntityManager();

}
