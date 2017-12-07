package person.ws;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import jpa.Person;

import dao.IPersonDao;
import dao.IPersonDaoLocal;

@WebService
public class PersonWsEjb implements IPersonDao{
@EJB
private IPersonDaoLocal dao;

@Override
public List<Person> findAll()
{
    try{ return dao.findAll(); } 
    catch (Exception ex) { 
        System.err.println(String.format("L'erreur suivante s'est produite autre : %s", ex));
        return null;
    }
}

}