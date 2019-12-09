package com.bnguyen.fallingsand.materials;

import com.bnguyen.fallingsand.materials.util.Movable;

import java.awt.*;
import java.util.Random;

public class Sand extends Material implements Movable {
    public Sand() {
        super.setMaterialColor(Color.YELLOW);
        super.setName("Sand");
    }

    @Override
    public Material[][] step(Material[][] grid) {
        int randomRow;
        int randomCol;
        Random generator;
        generator = new Random();
        // 0(inclusive) to total rows - 1 (inclusive)
        randomRow = generator.nextInt(grid.length - 1);
        // 0(inclusive) to total cols (exclusive)
        randomCol = generator.nextInt(grid[0].length);
        if (checkBound(randomRow, randomCol, grid))
            grid = swap(randomRow, randomCol, grid);
        return grid;
    }

    @Override
    public boolean checkBound(int row, int col, Material[][] grid) {
        Material focusMaterial = grid[row][col]; // Value of given row/col
        Material belowMaterial = grid[row + 1][col]; // Value below given row/col
        boolean focusLocation = focusMaterial instanceof Sand; // Validity of given row/col
        boolean belowLocation = belowMaterial instanceof Empty || belowMaterial instanceof Water; // Validity below given row/col
        if (focusLocation && belowLocation)
            return true;
        else
            return false;
    }

    @Override
    public Material[][] swap(int row, int col, Material[][] grid) {
        Material originalMaterial = grid[row + 1][col];
        grid[row + 1][col] = grid[row][col];
        if (originalMaterial instanceof Empty)
            grid[row][col] = originalMaterial;
        else if (originalMaterial instanceof Water) {
            Empty e = new Empty();
            grid[row][col] = e;
        }
        return grid;
    }

    @Override
    public boolean equals(Object obj) {
        return super.getMaterialColor().equals(Color.YELLOW) && super.getName().equals("Sand");
    }
}
