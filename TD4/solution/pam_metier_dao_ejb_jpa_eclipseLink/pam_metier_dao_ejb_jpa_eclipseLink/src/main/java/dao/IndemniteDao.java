/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import jpa.Indemnite;
import exception.PamException;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author j.fasquel
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class IndemniteDao implements IIndemniteDaoLocal,IIndemniteDaoRemote
{ 

@PersistenceContext
private EntityManager em;
// constructeur
public IndemniteDao() { }
// créer une cotisation
public Indemnite create(Indemnite cotisation) 
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
public Indemnite edit(Indemnite cotisation) { 
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
public void destroy(Indemnite cotisation) {
    try
    {
        Indemnite to_rm=em.merge(cotisation);
        em.remove(to_rm);
    }
    catch (Throwable th)
    {
        throw new PamException(th,11); 
    }
};
// chercher une cotisation particulière
public Indemnite find(Long id) 
{
    try
    {
        Query q = em.createQuery("select e from Indemnite e where e.id =:id").setParameter("id", id);
        Indemnite c = (Indemnite) q.getSingleResult();
        return c;
    }
    catch (Throwable th)
    {
        throw new PamException(th,11); 
    }
};
// obtenir tous les objets Cotisation
public List<Indemnite> findAll()
{
    Query q = em.createQuery("select e from Indemnite e");
    List<Indemnite> l = q.getResultList();
    return l;
};

}