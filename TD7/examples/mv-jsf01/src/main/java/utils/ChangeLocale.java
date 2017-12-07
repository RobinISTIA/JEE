package utils;

import java.io.Serializable;
import java.util.Map;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ChangeLocale implements Serializable{
    
   //Utilisation du logger pour afficher les infos
   private static final Logger logger=Logger.getLogger("utils.ChangeLocale");
    
  // la locale des pages
  private String locale="fr";
  
  public ChangeLocale() {
  }
  
  public String setFrenchLocale(){
    Map< String,String> cmap=  FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    logger.info("Info de log: "+cmap);  
    locale="fr";
    return null;
  }
  
  public String setEnglishLocale(){
    locale="en";
    return null;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }
  
  
}
