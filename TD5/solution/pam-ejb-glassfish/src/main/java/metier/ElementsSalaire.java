/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.io.Serializable;

/**
 *
 * @author j.fasquel
 */
public class ElementsSalaire implements Serializable {
    
// champs privés
private double salaireBase;
private double cotisationsSociales;
private double indemnitesEntretien;
private double indemnitesRepas;
private double salaireNet;

// constructeurs
public ElementsSalaire() {}

public ElementsSalaire(double salaireBase, double cotisationsSociales, double indemnitesEntretien, double indemnitesRepas, double salaireNet)
{        
this.salaireBase = salaireBase;
this.cotisationsSociales = cotisationsSociales;
this.indemnitesEntretien = indemnitesEntretien;
this.indemnitesRepas = indemnitesRepas;
this.salaireNet = salaireNet;
}

// toString
@Override
public String toString() 
{
return String.format("[salaire base=%s, cotisations sociales=%s, indemnités d'entretien=%s, indemnités de repas= %s,salaire net=%s]",
        salaireBase, cotisationsSociales, indemnitesEntretien, indemnitesRepas, salaireNet);
}
// getters et setters
//...
public double getSalaireNet() {return salaireNet;}

public double getSalaireBase() {return salaireBase;}

public double getIndemnitesRepas() {return indemnitesRepas;}

}
