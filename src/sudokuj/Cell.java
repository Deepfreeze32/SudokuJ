package sudokuj;

import java.util.ArrayList;
import java.util.List;

/**
 * The Cell class to describe a cell in a Sudoku puzzle.
 * @author Deepfreeze32
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
    
    public boolean empty() {
        return potentialValues.isEmpty();
    }
    
    public int getTotalPots() {
        return potentialValues.size();
    }
    
    public boolean isPotential(int v) {
        return potentialValues.contains(v);
    }
    
    public void set() {
        if (potentialValues.size() == 1) {
            value = potentialValues.get(0);
            potentialValues = null;
        }
    }
    
    public void remove(int v) {
        potentialValues.remove(potentialValues.indexOf(v));
    }
    
    public void set(int v) {
        value = v;
        potentialValues = null;
    }
    
    public int getValue() {
        return value;
    }
}
