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
@Table(name = "cotisations")
public class Cotisation implements Serializable {

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

  // cotisations sécurité sociale
  @Column(name = "SECU", nullable = false)
  private double secu;

  // cotisations retraite
  @Column(name = "RETRAITE", nullable = false)
  private double retraite;

  // cotisations csgd
  @Column(name = "CSGD", nullable = false)
  private double csgd;

  // cotisations csgrds
  @Column(name = "CSGRDS", nullable = false)
  private double csgrds;

  // constructeurs
  public Cotisation() {
  }

  public Cotisation(Long id) {
    this.id = id;
  }

  public Cotisation(Long id, int version, double secu, double retraite, double csgd, double csgrds) {
    this.id = id;
    this.secu = secu;
    this.retraite = retraite;
    this.csgd = csgd;
    this.csgrds = csgrds;
    this.version = version;
  }

  // toString
  @Override
  public String toString() {
    return String.format("Cotisations=[id=%s, version=%s, csgrds=%s, csgd=%s, secu=%s, retraite=%s]", id, version, csgrds, csgd, secu, retraite);
  }

  // getters et setters

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

  public double getSecu() {
    return secu;
  }

  public void setSecu(double secu) {
    this.secu = secu;
  }

  public double getRetraite() {
    return retraite;
  }

  public void setRetraite(double retraite) {
    this.retraite = retraite;
  }

  public double getCsgd() {
    return csgd;
  }

  public void setCsgd(double csgd) {
    this.csgd = csgd;
  }

  public double getCsgrds() {
    return csgrds;
  }

  public void setCsgrds(double csgrds) {
    this.csgrds = csgrds;
  }
  

  // égalité de deux instances ------------
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Cotisation)) {
      return false;
    }
    Cotisation other = (Cotisation) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }
}
