/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.console;
import dao.IEmployeDao;
import java.util.List;
import jpa.Employe;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainDao {
public static void main(String[] args) 
{
ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-dao.xml");
// EmployeDao
IEmployeDao employeDao = (IEmployeDao) ctx.getBean("employeDao");
// Recuperation des employes en utilisant la couche DAO
List<Employe> employes = employeDao.findAll();
// Affichage des employes
for ( Employe e : employes) 
{ 
    System.out.println("Employe: "+e); 
}

}

}