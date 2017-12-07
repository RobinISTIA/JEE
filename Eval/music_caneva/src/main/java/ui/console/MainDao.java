/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.console;

import java.util.List;
import dao.IAlbumDao;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import jpa.Album;

public class MainDao {

public static void main(String[] args) {
        try 
        {
        Properties properties = new Properties();
        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
        InitialContext initialContext = new InitialContext(properties);
        // Partie de 
        IAlbumDao albumDao = (IAlbumDao) initialContext.lookup("????");
        List<Album> albums = albumDao.findAll();
        System.out.println("Tous les albums:");
        for ( Album c : albums) { System.out.println("Album: "+c); }
        List<Album> albums_rollingstones = albumDao.findAllByAuteur("Rolling Stones");
        System.out.println("Albums des rolling stones:");
        for ( Album c : albums_rollingstones) { System.out.println("Album: "+c); }

        } catch (Exception ex) 
        {
            System.err.println(String.format("L'erreur suivante s'est produite : %s", ex));
            return;
        }


}}