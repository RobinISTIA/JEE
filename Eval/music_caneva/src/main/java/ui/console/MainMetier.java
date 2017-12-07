/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.console;

import java.util.List;
import metier.IMetier;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import jpa.Album;

public class MainMetier {

public static void main(String[] args) {
        try 
        {
        Properties properties = new Properties();
        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
        InitialContext initialContext = new InitialContext(properties);
        // CotisationDao
        IMetier metier = (IMetier) initialContext.lookup("????");
        List<String> names = metier.findAllAuteurNames();
        for(String name:names)
        {
            metier.clearPanier();
            List<Album> albums = metier.findAllAlbumsByAuteur(name);
            for (Album a : albums)
            {
                metier.ajoutAlbum(a.getId());
            }
            double prixOeuvre=metier.CalculerPrix();
            System.out.println("Prix oeuvre de "+name+" : "+prixOeuvre);
        }
        } catch (Exception ex) 
        {
            System.err.println(String.format("L'erreur suivante s'est produite : %s", ex));
            return;
        }


}}