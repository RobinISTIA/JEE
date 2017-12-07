package metier;

import java.io.Serializable;
import jpa.Cotisation;
import jpa.Employe;

public class FeuilleSalaire implements Serializable {
  // champs privés

  private Employe employe;
  private Cotisation cotisation;
  private ElementsSalaire elementsSalaire;

  // constructeurs
  public FeuilleSalaire() {
  }

  public FeuilleSalaire(Employe employe, Cotisation cotisation, ElementsSalaire elementsSalaire) {
    this.employe = employe;
    this.cotisation = cotisation;
    this.elementsSalaire = elementsSalaire;
  }

  // toString
  @Override
  public String toString() {
    return String.format("FeuilleSalaire[%s, %s, ,%s]", employe, cotisation, elementsSalaire);
  }

  // accesseurs
  public Cotisation getCotisation() {
    return cotisation;
  }

  public void setCotisation(Cotisation cotisation) {
    this.cotisation = cotisation;
  }

  public Employe getEmploye() {
    return employe;
  }

  public void setEmploye(Employe employe) {
    this.employe = employe;
  }

  public ElementsSalaire getElementsSalaire() {
    return elementsSalaire;
  }

  public void setElementsSalaire(ElementsSalaire elementsSalaire) {
    this.elementsSalaire = elementsSalaire;
  }
}
