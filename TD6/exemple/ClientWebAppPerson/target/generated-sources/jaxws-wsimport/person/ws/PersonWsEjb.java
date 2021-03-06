
package person.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PersonWsEjb", targetNamespace = "http://ws.person/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PersonWsEjb {


    /**
     * 
     * @return
     *     returns java.util.List<person.ws.Person>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://ws.person/", className = "person.ws.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://ws.person/", className = "person.ws.FindAllResponse")
    @Action(input = "http://ws.person/PersonWsEjb/findAllRequest", output = "http://ws.person/PersonWsEjb/findAllResponse")
    public List<Person> findAll();

}
