/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import jpa.Album;

public interface IAlbumDao {
// cherche et retourne l'album de la table [Albums] associe à la clé primaire id
Album findById(Long id);
// cherche et retourne tous les albums de la table [Albums]
List<Album> findAll();
// cherche et retourne tous les albums de la table [Albums] dont le nom de l'auteur est "name"
List<Album> findAllByAuteur(String name);
}