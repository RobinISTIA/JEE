package forms;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
@RequestScoped
public class Form {

  //ATTRIBUTES
  private Integer saisie1 = 0;
  private Integer saisie3 = 0;
  private Integer saisie4 = 0;
  private Integer saisie10 = 0;
  private Integer saisie11 = 0;
  private Integer saisie12 = 0;
  private String errorSaisie11 = "";
  private String errorSaisie12 = "";

  //CONSTRUCTEUR
  public Form() {}
  
  // GETTERS AND SETTERS
  public int getSaisie1() {return saisie1;}
  public void setSaisie1(int saisie1) {this.saisie1 = saisie1;}
  public int getSaisie3() {return saisie3;}
  public void setSaisie3(int saisie3) {this.saisie3 = saisie3;}
  public int getSaisie4() {return saisie4;}
  public void setSaisie4(int saisie4) {this.saisie4 = saisie4;}
  public Integer getSaisie10() {return saisie10;}
  public void setSaisie10(Integer saisie10) {this.saisie10 = saisie10;}
  public Integer getSaisie11() {return saisie11;}
  public void setSaisie11(Integer saisie11) {this.saisie11 = saisie11;}
  public Integer getSaisie12() {return saisie12;}
  public void setSaisie12(Integer saisie12) {this.saisie12 = saisie12;}
  public String getErrorSaisie11() {return errorSaisie11;}
  public void setErrorSaisie11(String errorSaisie11) {this.errorSaisie11 = errorSaisie11;}
  public String getErrorSaisie12() {return errorSaisie12;}
  public void setErrorSaisie12(String errorSaisie12) {this.errorSaisie12 = errorSaisie12;}

  // ACTION CANCEL: REINITIALISATION DES ATTRIBUTS
  public String cancel() {saisie1 = 0;saisie3 = 0;saisie4 = 0;saisie10 = 0;return null;}

  
  // ACTION SUBMIT AVEC VALIDATION GLOBALE
  public String submit() {
    // dernières validations
    if ((saisie11 + saisie12) != 10) {
      // msg global
      FacesMessage message = Messages.getMessage(null, "saisies11et12.incorrectes", null);
      message.setSeverity(FacesMessage.SEVERITY_ERROR);
      FacesContext context = FacesContext.getCurrentInstance();
      context.addMessage(null, message);
      // msg li�s aux champs
      message = Messages.getMessage(null, "error.sign", null);
      setErrorSaisie11(message.getSummary());
      setErrorSaisie12(message.getSummary());
    } else {
      setErrorSaisie11("");
      setErrorSaisie12("");
    }
    // on renvoie le même formulaire
    return null;
  }

  // VALIDATEUR CUSTOMIZED
  public void validateSaisie10(FacesContext context, UIComponent component, Object value) {
    int saisie = (Integer) value;
    if (!(saisie < 1 || saisie > 7)) {
      FacesMessage message = Messages.getMessage(null, "saisie10.incorrecte", null);
      message.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ValidatorException(message);
    }
  }



}