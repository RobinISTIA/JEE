/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.forms;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import metier.IMetierLocal;
import metier.Metier;


/**
 *
 * @author j.fasquel
 */
@ManagedBean
@RequestScoped
public class Form implements Serializable
{
   //Form fera l'interface entre les pages et la couche metier.
   private IMetierLocal metier = new Metier();
   //Utilisation du logger pour afficher les infos
   private static final Logger logger=Logger.getLogger("forms.Form");
}
