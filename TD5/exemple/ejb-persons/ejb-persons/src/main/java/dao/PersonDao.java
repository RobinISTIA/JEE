/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import jpa.Person;
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
public class PersonDao implements IPersonDaoLocal,IPersonDaoRemote
{ 

@PersistenceContext
private EntityManager em;
// constructeur
public PersonDao() { }
// créer une cotisation

// obtenir tous les objets Cotisation
public List<Person> findAll()
{
    Query q = em.createQuery("select e from Person e");
    List<Person> l = q.getResultList();
    return l;
};

}