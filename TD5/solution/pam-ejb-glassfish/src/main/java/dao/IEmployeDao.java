/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author j.fasquel
 */
import java.util.List;
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
}