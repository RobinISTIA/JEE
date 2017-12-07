package metier;

import java.io.Serializable;

public class ElementsSalaire implements Serializable {

  // champs privés
  private double salaireBase;
  private double cotisationsSociales;
  private double indemnitesEntretien;
  private double indemnitesRepas;
  private double salaireNet;

  // constructeurs
  public ElementsSalaire() {

  }

  public ElementsSalaire(double salaireBase, double cotisationsSociales, double indemnitesEntretien, double indemnitesRepas, double salaireNet) {
    this.salaireBase = salaireBase;
    this.cotisationsSociales = cotisationsSociales;
    this.indemnitesEntretien = indemnitesEntretien;
    this.indemnitesRepas = indemnitesRepas;
    this.salaireNet = salaireNet;
  }

  // toString
  @Override
  public String toString() {
    return String.format("[salaire base=%s, cotisations sociales=%s, indemnités d'entretien=%s, indemnités de repas=%s, salaire net=%s]",
            salaireBase, cotisationsSociales, indemnitesEntretien, indemnitesRepas, salaireNet);
  }

  // getters et setters
  public double getCotisationsSociales() {
    return cotisationsSociales;
  }

  public void setCotisationsSociales(double cotisationsSociales) {
    this.cotisationsSociales = cotisationsSociales;
  }

  public double getIndemnitesEntretien() {
    return indemnitesEntretien;
  }

  public void setIndemnitesEntretien(double indemnitesEntretien) {
    this.indemnitesEntretien = indemnitesEntretien;
  }

  public double getIndemnitesRepas() {
    return indemnitesRepas;
  }

  public void setIndemnitesRepas(double indemnitesRepas) {
    this.indemnitesRepas = indemnitesRepas;
  }

  public double getSalaireBase() {
    return salaireBase;
  }

  public void setSalaireBase(double salaireBase) {
    this.salaireBase = salaireBase;
  }

  public double getSalaireNet() {
    return salaireNet;
  }

  public void setSalaireNet(double salaireNet) {
    this.salaireNet = salaireNet;
  }

}
