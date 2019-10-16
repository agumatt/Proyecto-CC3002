package model;

import model.units.IUnit;

import java.util.ArrayList;

public class Tactician {

 private String name;
 private IUnit selectedUnit;
 private final ArrayList<Tactician> units = new ArrayList<>();

 public String getName() {
   return name;
 }
}
