/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.console;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import jpa.Album;

public class MainJPA {

public static void main(String[] args) {
EntityManagerFactory emf = Persistence.createEntityManagerFactory("istia_music_jar_1.0-SNAPSHOTPU");
// entityManager
EntityManager em = emf.createEntityManager();

List< Album > os = em.createQuery("select a from Album a").getResultList();
for(Album o : os) 
{   
    System.out.println(o); 
}
em.clear();em.close();emf.close();
}}