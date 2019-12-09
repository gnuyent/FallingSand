package com.bnguyen.fallingsand;

import com.bnguyen.fallingsand.materials.Empty;
import com.bnguyen.fallingsand.materials.Material;
import com.bnguyen.fallingsand.materials.util.Movable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SandLab {
    // refactor grid array to use abstract Material data type
    private Material[][] grid;
    private SandDisplay display;
    // added Material array field for easy traversal of all materials
    private Material[] materials;
    // hooks into SandDisplay
    public static boolean reset = true;

    public SandLab(int numRows, int numCols, Material[] materials) {
        // Initialize display grid
        grid = new Material[numRows][numCols];
        List<String> names = new ArrayList<>();
        reset();
        this.materials = materials;
        for (Material m : materials)
            names.add(m.getName());
        display = new SandDisplay("Falling Sand", numRows, numCols, names);
    }

    //called when the user clicks on a location using the given tool
    private void locationClicked(int row, int col, Material tool) {
        if (grid[row][col] instanceof Empty || tool instanceof Empty)
            grid[row][col] = tool;
    }

    //copies each element of grid into the display
    public void updateDisplay() {
        if (reset)
            reset();
        else {
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    display.setColor(row, col, grid[row][col].getMaterialColor());
                }
            }
        }
    }

    public void reset() {
        reset = false;
        Empty e = new Empty();
        for (Material[] row : this.grid)
            Arrays.fill(row, e);
    }

    //do not modify
    public void run() {
        while (true) {
            for (int i = 0; i < display.getSpeed(); i++) {
                for (Material particle : materials) {
                    if (particle instanceof Movable)
                        grid = ((Movable) particle).step(grid);
                }
            }
            updateDisplay();
            display.repaint();
            display.pause(1);  //wait for redrawing and for mouse
            int[] mouseLoc = display.getMouseLocation();
            if (mouseLoc != null)  //test if mouse clicked
                locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
        }
    }
}
