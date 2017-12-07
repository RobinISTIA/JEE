package forms;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;


@ManagedBean
@RequestScoped
public class Form {
  
  /** Creates a new instance of Form */
  public Form() {
  }
  
  // champs du formulaire
  private String inputText="texte";
  private String[] selectManyListBox=new String[]{"1","3"};
  private String selectOneMenu="1";
  //private String[] selectManyMenu=new String[]{"1","2"};
  //private boolean selectBooleanCheckbox=true;
  private String selectOneRadio="2";
  
  private String selectOneMenuDynamic="1";
  
  // �v�nements
  public String submit(){
    return null;
  }
  
  // getters et setters
  
  public String getSelectManyListBoxValue(){
    return getValue(selectManyListBox);
  }
  
   
  private String getValue(String[] chaines){
    String value="[";
    for(String chaine : chaines){
      value+=" "+chaine;
    }
    return value+"]";
  }
  
  
  public String[] getSelectManyListBox() {
    return selectManyListBox;
  }
  
  public void setSelectManyListBox(String[] selectManyListBox) {
    this.selectManyListBox = selectManyListBox;
  }
  
  public String getSelectOneMenu() {
    return selectOneMenu;
  }
  
  public void setSelectOneMenu(String selectOneMenu) {
    this.selectOneMenu = selectOneMenu;
  }
    
  public String getInputText() {
    return inputText;
  }
  
  public void setInputText(String inputText) {
    this.inputText = inputText;
  }
    
   
  public String getSelectOneRadio() {
    return selectOneRadio;
  }

  public void setSelectOneRadio(String selectOneRadio) {
    this.selectOneRadio = selectOneRadio;
  }
  
  
    public String getSelectOneMenuDynamic() {
    return selectOneMenuDynamic;
  }
  
  public void setSelectOneMenuDynamic(String selectOneMenu) {
    this.selectOneMenuDynamic = selectOneMenu;
  }
  public SelectItem[] getSelectOneMenuDynamicItems() {
    return getItems("D",3);
  }
  private SelectItem[] getItems(String label, int qte) {
    SelectItem[] items=new SelectItem[qte];
    for(int i=0;i<qte;i++){
      items[i]=new SelectItem(i,label+i);
    }
    return items;
  }

}