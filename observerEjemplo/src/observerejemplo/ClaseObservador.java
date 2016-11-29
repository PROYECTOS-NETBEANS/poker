package observerejemplo;

import java.util.Observable;

public class ClaseObservador extends Observable{
  
 private int colorSeleccionado;
 private String color;
  
 public ClaseObservador(){
   
 }
 public void setColorSeleccionado(int i) {
    this.colorSeleccionado = i;
    System.out.println("cambio en negocio");
    setChanged();
    notifyObservers();
    
 }
 public int getColorSeleccionado() {
  return colorSeleccionado;
 }
 public void setColor(String color) {
  this.color = color;
 }
 public String getColor() {
  return color;
 }
}