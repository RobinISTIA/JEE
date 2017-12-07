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
import jpa.Indemnite;

public interface IIndemniteDao 
{
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
}