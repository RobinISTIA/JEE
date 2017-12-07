/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import jpa.Cotisation;
import exception.PamException;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author j.fasquel
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CotisationDao implements ICotisationDaoLocal,ICotisationDaoRemote
{ 

@PersistenceContext
private EntityManager em;
// constructeur
public CotisationDao() { }
// créer une cotisation
public Cotisation create(Cotisation cotisation) 
{ 
    try
    {
        em.persist(cotisation);
        return cotisation; 
    }
    catch (Throwable th)
    {
        throw new PamException(th,11); 
    }
}

//....
// modifier une cotisation existante
public Cotisation edit(Cotisation cotisation) { 
    try
    {
        return em.merge(cotisation);
    }
    catch (Throwable th)
    {
        throw new PamException(th,11); 
    }
};
// supprimer une cotisation existante
public void destroy(Cotisation cotisation) {
    try
    {
        Cotisation to_rm=em.merge(cotisation);
        em.remove(to_rm);
    }
    catch (Throwable th)
    {
        throw new PamException(th,11); 
    }
};
// chercher une cotisation particulière
public Cotisation find(Long id) 
{
    try
    {
        Query q = em.createQuery("select e from Cotisation e where e.id =:id").setParameter("id", id);
        Cotisation c = (Cotisation) q.getSingleResult();
        return c;
    }
    catch (Throwable th)
    {
        //throw new PamException(th,11);
        return null;
    }
};
// obtenir tous les objets Cotisation
public List<Cotisation> findAll()
{
    Query q = em.createQuery("select e from Cotisation e");
    List<Cotisation> l = q.getResultList();
    return l;
};

}