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

    private ArrayList<Integer> potentialValues;
    private int value;

    public Cell() {
        value = -1;
        potentialValues = new ArrayList<>();
    }

    public Cell(int val) {
        if (val <= 0) {
            value = -1;
            potentialValues = new ArrayList<>();
        }
        else {
            value = val;
            potentialValues = null;
        }
    }
}
