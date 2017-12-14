/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.forms;

import java.util.List;

/**
 *
 * @author usrlocal
 */
public class HistoryElement {
  
  private static int rankS;
  
  private int rank;

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getJours() {
    return jours;
  }

  public void setJours(int jours) {
    this.jours = jours;
  }

  public double getHeures() {
    return heures;
  }

  public void setHeures(double heures) {
    this.heures = heures;
  }

  public double getSalaireNet() {
    return salaireNet;
  }

  public void setSalaireNet(double salaireNet) {
    this.salaireNet = salaireNet;
  }
  private String name;
  private int jours;
  private double heures;
  private double salaireNet;

  public HistoryElement(String name, int jours, double heures, double salaireNet) {
    this.rank = rankS++;
    this.name = name;
    this.jours = jours;
    this.heures = heures;
    this.salaireNet = salaireNet;
  }
  
  public HistoryElement() {
    
  }
  
}
