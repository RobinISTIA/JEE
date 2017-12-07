/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author j.fasquel
 */
@Entity
@Table(name = "albums")
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a")})
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "TITRE")
    private String titre;
    @Basic(optional = false)
    @Column(name = "NBTRACKS")
    private int nbtracks;
    @Basic(optional = false)
    @Column(name = "ANNEE")
    private int annee;
    @Basic(optional = false)
    @Column(name = "PRIX")
    private double prix;
    @Basic(optional = false)
    @Column(name = "VERSION")
    private int version;
    @JoinColumn(name = "AUTEUR_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Auteur auteurId;

    public Album() {
    }

    public Album(Long id) {
        this.id = id;
    }

    public Album(Long id, String titre, int nbtracks, int annee, double prix, int version) {
        this.id = id;
        this.titre = titre;
        this.nbtracks = nbtracks;
        this.annee = annee;
        this.prix = prix;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getNbtracks() {
        return nbtracks;
    }

    public void setNbtracks(int nbtracks) {
        this.nbtracks = nbtracks;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Auteur getAuteurId() {
        return auteurId;
    }

    public void setAuteurId(Auteur auteurId) {
        this.auteurId = auteurId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Album[ id=" + id + " ]";
    }
    
}
