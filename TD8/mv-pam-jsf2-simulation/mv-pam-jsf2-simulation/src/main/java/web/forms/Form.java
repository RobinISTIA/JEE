/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.forms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import java.util.logging.Logger;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import jpa.Employe;
import metier.FeuilleSalaire;
import metier.IMetierLocal;
import metier.Metier;


/**
 *
 * @author j.fasquel
 */
@ManagedBean
@SessionScoped
public class Form implements Serializable
{
  private IMetierLocal metier = new Metier();
  private FeuilleSalaire feuilleSalaire;
  private Boolean viewInfosIsRendered=false;
  private Integer heures;
  private Integer jours;
  private String ss;
  private static final Logger logger=Logger.getLogger("forms.Form");
  private List<HistoryElement> history = new ArrayList<>();

  public List<HistoryElement> getHistory() {
    return history;
  }

  public void setHistory(List<HistoryElement> history) {
    this.history = history;
  }
     /** Creates a new instance of Form */
  public Form() 
  {
  }

  public SelectItem[] getSSandNames() {
    logger.info("Access to ss and names");
    List<Employe> employes=metier.findAllEmployes();
    
    SelectItem[] items=new SelectItem[employes.size()];
    for(int i=0;i<employes.size();i++)
    {
      Employe employe=employes.get(i);
      items[i]=new SelectItem(employe.getSs(),employe.getPrenom()+" "+employe.getNom());
    }
    return items;
  }
  public void setSs(String s)
  {   logger.info("Set current selected SS: "+s);   
      ss=s;
  }
  public String getSs()
  {      logger.info("Access to current selected SS to "+ss);   
  return ss;}
  
  public Integer getHeures()
  {   logger.info("Access to nb heures");    
      return heures; }
  public void setHeures(Integer h)
  {   logger.info("Set nb heures to" + Integer.toString(h));       
      heures=h;}
  public Integer getJours()
  {   logger.info("Access to nb jours");   
      return jours; }
  public void setJours(Integer j)
  {   logger.info("Set nb jours to" + Integer.toString(j));          
      jours=j;}
  
  //
  public Boolean getViewInfosIsRendered(){return viewInfosIsRendered;}
  public void setViewInfosIsRendered(Boolean v){viewInfosIsRendered=v;}
  
  public FeuilleSalaire getFeuilleSalaire() {return feuilleSalaire;}
  public void setFeuilleSalaire(FeuilleSalaire f) {feuilleSalaire=f;}
  
  public String calculerSalaire()
  {
      logger.info("Calcul feuille salaire");          
      feuilleSalaire=metier.calculerFeuilleSalaire(ss, heures, jours);
      viewInfosIsRendered=true;
      history.add(new HistoryElement(
            feuilleSalaire.getEmploye().getNom(),
            jours, 
            heures,
            feuilleSalaire.getElementsSalaire().getSalaireNet()
      ));
      return null;
  }
  public String raz()
  {
      logger.info("RAZ");
      viewInfosIsRendered=false;
      //Employe e= metier.findAllEmployes().get(0);
      //ss=e.getSs();
      //logger.info("RAZ:"+e.getNom());
      return null;
  }
  
  private int removeRank;

  public int getRemoveRank() {
    return removeRank;
  }

  public void setRemoveRank(int removeRank) {
    this.removeRank = removeRank;
  }
  
  public void removeElement() {
    for(HistoryElement he: history) {
      if(he.getRank() == removeRank) {
        history.remove(he);
        break;
      }
    }
  }
}
