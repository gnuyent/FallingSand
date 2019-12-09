package com.bnguyen.fallingsand.materials;

import com.bnguyen.fallingsand.materials.util.Movable;

import java.awt.Color;
import java.util.Random;

public class Water extends Material implements Movable {
    public Water() {
        super.setMaterialColor(Color.BLUE);
        super.setName("Water");
    }

    @Override
    public boolean equals(Object obj) {
        return super.getMaterialColor().equals(Color.BLUE) && super.getName().equals("Water");
    }

    @Override
    public Material[][] step(Material[][] grid) {
        int randomRow;
        int randomCol;
        Random generator;
        generator = new Random();
        // Generates an integer value from 1 to 3 inclusive.
        direction = generator.nextInt(3) + 1;
        randomRow = generator.nextInt(grid.length);
        randomCol = generator.nextInt(grid[0].length);
        if (checkBound(randomRow, randomCol, grid))
            grid = swap(randomRow, randomCol, grid);
        return grid;
    }

    @Override
    public boolean checkBound(int row, int col, Material[][] grid) {
        if (!(grid[row][col] instanceof Water))
            return false;
        //left
        if (direction == LEFT) {
            return col - 1 >= 0;
            //down
        } else if (direction == DOWN) {
            return row + 1 < grid.length;
            //right
        } else if (direction == RIGHT) {
            return col + 1 < grid[0].length;
        }
        return false;
    }

    @Override
    public Material[][] swap(int row, int col, Material[][] grid) {
        int swapRow = row;
        int swapCol = col;
        Material originalMaterial;
        if (direction == LEFT)
            swapCol--;
        else if (direction == DOWN)
            swapRow++;
        else if (direction == RIGHT)
            swapCol++;
        if (grid[swapRow][swapCol] instanceof Empty) {
            originalMaterial = grid[swapRow][swapCol];
            grid[swapRow][swapCol] = grid[row][col];
            grid[row][col] = originalMaterial;
        }
        return grid;
    }
}
