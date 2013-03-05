/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuj;

import java.util.ArrayList;

/**
 *
 * @author Travis
 */
public class Cell {

    private ArrayList<Integer> rowPotentialValues;
    private ArrayList<Integer> colPotentialValues;
    private ArrayList<Integer> boxPotentialValues;
    private int value;

    public Cell() {
        value = 0;
        rowPotentialValues = new ArrayList<>();
        colPotentialValues = new ArrayList<>();
        boxPotentialValues = new ArrayList<>();

        //System.out.println("Building a cell!");
    }

    public Cell(int val) {
        if (val <= 0) {
            value = 0;
            rowPotentialValues = new ArrayList<>();
            colPotentialValues = new ArrayList<>();
            boxPotentialValues = new ArrayList<>();
        } else {
            value = val;
            rowPotentialValues = null;
            colPotentialValues = null;
            boxPotentialValues = null;
        }
    }

    public void setRowPot(int v) {
        // TODO: stuff
        if (!rowPotentialValues.contains(v)) {
            rowPotentialValues.add(v);
        }
    }

    public void setColPot(int v) {
        // TODO: stuff
        if (!colPotentialValues.contains(v)) {
            colPotentialValues.add(v);
        }
    }

    public void setBoxPot(int v) {
        // TODO: stuff
        if (!boxPotentialValues.contains(v)) {
            boxPotentialValues.add(v);
        }
    }
    
    public int getTotalRowPots() {
        return rowPotentialValues.size();
    }

    public int getTotalColPots() {
        return colPotentialValues.size();
    }
    
    public int getTotalBoxPots() {
        return boxPotentialValues.size();
    }
    
    public void set(int v) {
        value = v;
        rowPotentialValues = null;
            colPotentialValues = null;
            boxPotentialValues = null;
    }
    
    public int getValue() {
        return value;
    }
}
