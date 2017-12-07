/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import jpa.Employe;
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
public class EmployeDao implements IEmployeDaoLocal, IEmployeDaoRemote
{ 

@PersistenceContext
private EntityManager em;
// constructeur
public EmployeDao() { }


public Employe create(Employe employe) 
{ 
    try
    {
        em.persist(employe);
        return employe; 
    }
    catch (Throwable th)
    {
        throw new PamException(th,11); 
    }
}
public Employe edit(Employe employe) { 
    try
    {
        Employe e= em.merge(employe);
        return e; 
    }
    catch (Throwable th)
    {
        throw new PamException(th,11); 
    }
};
public void destroy(Employe employe) {
    try
    {
        Employe to_rm=em.merge(employe);
        em.remove(to_rm);
    }
    catch (Throwable th)
    {
        throw new PamException(th,11); 
    }
};

public Employe find(Long id) 
{
    try
    {   
        Query q = em.createQuery("select e from Employe e left join fetch e.indemnite where e.id =:id").setParameter("id", id);
        //Query q = em.createQuery("select e from Employe e where e.id =:id").setParameter("id", id);
        Employe c = (Employe) q.getSingleResult();
        return c;
    }
    catch (Throwable th)
    {
        throw new PamException(th,11); 
    }
};
public Employe find(String SS)
{
    try
    {
        //Query q = em.createQuery("select e from Employe e where e.ss =:ss").setParameter("ss", SS);
        Query q = em.createQuery("select e from Employe e left join fetch e.indemnite where e.ss =:ss").setParameter("ss", SS);
        Employe c = (Employe) q.getSingleResult();
        return c;
    }
    catch (Throwable th)
    {
        throw new PamException(th,11); 
    }

}

public List<Employe> findAll() {
    Query q = em.createQuery("select e from Employe e");
    List<Employe> l = q.getResultList();
    return l;
};



}
