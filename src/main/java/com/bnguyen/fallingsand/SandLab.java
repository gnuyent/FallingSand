package com.bnguyen.fallingsand;

import com.bnguyen.fallingsand.materials.*;
import com.bnguyen.fallingsand.materials.util.Movable;

import java.util.Arrays;

public class SandLab {
    public static void main(String[] args) {
        // add newly added materials to this array
        Material[] materials = new Material[]{new Empty(), new Metal(), new Sand(), new Water()};
        SandLab lab = new SandLab(120, 80, materials);
        lab.run();
    }

    // refactor grid array to use abstract Material data type
    private Material[][] grid;
    private SandDisplay display;
    // added Material array field for easy traversal of all materials
    private Material[] materials;

    public SandLab(int numRows, int numCols, Material[] materials) {
        // Initialize display grid
        grid = new Material[numRows][numCols];
        // Fill grid with Empty objects
        for (Material[] row : grid)
            Arrays.fill(row, materials[Material.EMPTY]);

        this.materials = materials;
        String[] names;
        names = new String[materials.length];

        for (int particleType = 0; particleType < names.length; particleType++)
            names[particleType] = materials[particleType].getName();

        display = new SandDisplay("Falling Sand", numRows, numCols, names);
    }

    //called when the user clicks on a location using the given tool
    private void locationClicked(int row, int col, Material tool) {
        if (grid[row][col] instanceof Empty || tool instanceof Empty)
            grid[row][col] = tool;
    }

    //copies each element of grid into the display
    public void updateDisplay() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                display.setColor(row, col, grid[row][col].getMaterialColor());
            }
        }
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
