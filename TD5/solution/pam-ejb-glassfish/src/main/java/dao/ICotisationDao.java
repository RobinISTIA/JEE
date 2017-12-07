/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
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

}