/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuj;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Travis
 */
public class Cell {

    private List<Integer> potentialValues;
    
    private int value;

    public Cell() {
        value = 0;
        potentialValues = new ArrayList<>();
        //System.out.println("Building a cell!");
    }

    public Cell(int val) {
        if (val <= 0) {
            value = 0;
            potentialValues = new ArrayList<>();
        } else {
            value = val;
            potentialValues = null;
        }
    }

    public void setPot(int v) {
        // TODO: stuff
        if (!potentialValues.contains(v)) {
            potentialValues.add(v);
        }
    }
    
    public int getTotalPots() {
        return potentialValues.size();
    }
    
    public boolean isPotential(int v) {
        return potentialValues.contains(v);
    }
    
    public void set(int v) {
        value = v;
        potentialValues = null;
    }
    
    public int getValue() {
        return value;
    }
}
