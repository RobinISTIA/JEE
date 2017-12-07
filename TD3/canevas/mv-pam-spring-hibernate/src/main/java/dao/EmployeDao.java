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
import exception.PamException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jpa.Employe;
//import IEmployeDao;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class EmployeDao implements IEmployeDao
{
@PersistenceContext
private EntityManager em;
// constructeur
public EmployeDao() {}
// créer une cotisation
public Employe create(Employe employe)
{
try{
return employe;
}
catch (Throwable th){ throw new PamException(th,11);}
}

// modifier une entité Employe existante
public Employe edit(Employe employe) {return employe;}

// supprimer une entité Employe
public void destroy(Employe employe) {}

// chercher une entité Employe via son identifiant id
public Employe find(Long id) {return new Employe();}

// chercher une entité Employe via son n° SS
public Employe find(String SS) {return new Employe();}

// obtenir toutes les entités Employe
public List<Employe> findAll() 
{
    try
    {
        Query q = em.createQuery("select e from Employe e");
        List<Employe> l = q.getResultList();
        return l;
    }
    catch (Throwable th)
    {
        throw new PamException(th,11); 
    }    
}
//{return new ArrayList<Employe>();}

// obtenir l'EntityManager
public EntityManager getEntityManager() {return em;}


}