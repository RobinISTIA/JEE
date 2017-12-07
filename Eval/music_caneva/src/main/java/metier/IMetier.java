/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import jpa.Album;
import javax.naming.NamingException;

public interface IMetier
{
// Calcul du prix du panier: somme des prix de chaque album
// Un panier sera un attribut: [private List<Album> panier=new ArrayList<Album>();]
double CalculerPrix() throws NamingException;
// Ajouter un album, spécifié par son identifiant (clé primaire)
void ajoutAlbum(Long id) throws NamingException;
// Vide le panier
void clearPanier() throws NamingException;
// liste des auteurs
List<String> findAllAuteurNames() throws NamingException;
// liste des albums pour l'auteur spécifié en paramètre
List<Album> findAllAlbumsByAuteur(String name) throws NamingException;
}