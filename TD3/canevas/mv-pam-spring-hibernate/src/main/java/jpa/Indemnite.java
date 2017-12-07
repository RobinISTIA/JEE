package jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "indemnites")
public class Indemnite implements Serializable {

  private static final long serialVersionUID = 1L;

  // clé primaire
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  @Column(name = "ID", nullable = false)
  private Long id;

  // n° de version
  @Column(name = "VERSION", nullable = false)
  @Version
  private int version;

  // indemnité journalière d'entretien
  @Column(name = "ENTRETIEN_JOUR", nullable = false)
  private double entretienJour;

  // indemnité journalière de repas
  @Column(name = "REPAS_JOUR", nullable = false)
  private double repasJour;

  // indice d'indemnités
  @Column(name = "INDICE", nullable = false, unique = true)
  private int indice;

  // indemnités de congés payés
  @Column(name = "INDEMNITES_CP", nullable = false)
  private double indemnitesCp;

  // tarif horaire
  @Column(name = "BASE_HEURE", nullable = false)
  private double baseHeure;

  public Indemnite() {
  }

  public Indemnite(Long id) {
    this.id = id;
  }

  public Indemnite(Long id, int version, int indice, double baseHeure, double entretienJour, double repasJour, double indemnitesCp) {
    this.id = id;
    this.entretienJour = entretienJour;
    this.repasJour = repasJour;
    this.indice = indice;
    this.indemnitesCp = indemnitesCp;
    this.baseHeure = baseHeure;
    this.version = version;
  }

  @Override
  public String toString() {
    return String.format("Indemnite[id=%s, version=%s, indice=%s, base heure=%s, entretien jour=%s, repas jour=%s, indemnités CP=%s]",
            id, version, indice, baseHeure, entretienJour, repasJour, indemnitesCp);
  }

  // getters et setters --------------
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  public double getEntretienJour() {
    return entretienJour;
  }

  public void setEntretienJour(double entretienJour) {
    this.entretienJour = entretienJour;
  }

  public double getRepasJour() {
    return repasJour;
  }

  public void setRepasJour(double repasJour) {
    this.repasJour = repasJour;
  }

  public int getIndice() {
    return indice;
  }

  public void setIndice(int indice) {
    this.indice = indice;
  }

  public double getIndemnitesCp() {
    return indemnitesCp;
  }

  public void setIndemnitesCp(double indemnitesCp) {
    this.indemnitesCp = indemnitesCp;
  }

  public double getBaseHeure() {
    return baseHeure;
  }

  public void setBaseHeure(double baseHeure) {
    this.baseHeure = baseHeure;
  }

  // égalité d'instances ------------
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Indemnite)) {
      return false;
    }
    Indemnite other = (Indemnite) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

}
