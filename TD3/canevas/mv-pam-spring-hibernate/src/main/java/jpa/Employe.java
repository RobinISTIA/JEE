package jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "employes")
public class Employe implements Serializable {

  private static final long serialVersionUID = 1L;

  // clé primaire
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  // prénom
  @Column(name = "PRENOM", length = 30, nullable = false)
  private String prenom;

  // nom
  @Column(name = "NOM", length = 30, nullable = false)
  private String nom;

  // n° de sécu
  @Column(name = "SS", length = 15, nullable = false, unique = true)
  private String ss;

  // adresse
  @Column(name = "ADRESSE", length = 50, nullable = false)
  private String adresse;

  // code postal
  @Column(name = "CP", length = 5, nullable = false)
  private String cp;

// ville
  @Column(name = "VILLE", length = 20, nullable = false)
  private String ville;

  // n° de version
  @Column(name = "VERSION", nullable = false)
  @Version
  private int version;

  // indemnités
  @JoinColumn(name = "INDEMNITE_ID", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Indemnite indemnite;

  // clé étrangère
  @Column(name = "INDEMNITE_ID", updatable = false, insertable = false, nullable = false)
  private Long indemniteId;

  // constructeurs
  public Employe() {
  }

  public Employe(Long id) {
    this.id = id;
  }

  public Employe(Long id, int version, String prenom, String nom, String ss, String adresse, String ville, String cp, Indemnite indemnite) {
    this.id = id;
    this.prenom = prenom;
    this.ss = ss;
    this.adresse = adresse;
    this.cp = cp;
    this.ville = ville;
    this.nom = nom;
    this.version = version;
    this.indemnite = indemnite;
  }

  // toString
  @Override
  public String toString() {
    return String.format("Employé=[id=%s, version=%s, prénom=%s, nom=%s, adresse=%s, ville=%s, code postal=%s, indemniteId=%s]",
            id, version, prenom, nom, adresse, ville, cp, indemniteId);
  }

  // getters et setters ---------
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getSs() {
    return ss;
  }

  public void setSs(String ss) {
    this.ss = ss;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getCp() {
    return cp;
  }

  public void setCp(String cp) {
    this.cp = cp;
  }

  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  public Indemnite getIndemnite() {
    return indemnite;
  }

  public void setIndemnite(Indemnite indemnite) {
    this.indemnite = indemnite;
  }

  public Long getIndemniteId() {
    return indemniteId;
  }

  public void setIndemniteId(Long indemniteId) {
    this.indemniteId = indemniteId;
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
    if (!(object instanceof Employe)) {
      return false;
    }
    Employe other = (Employe) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

}
