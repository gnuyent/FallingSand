package com.bnguyen.fallingsand.materials;

import com.bnguyen.fallingsand.materials.util.Movable;

import java.awt.*;
import java.util.Random;

public class Water extends Material implements Movable {
    public Water() {
        super.setMaterialColor( Color.BLUE );
        super.setName( "Water" );
    }

    @Override
    public boolean equals( Object obj ) {
        return super.getMaterialColor().equals( Color.BLUE ) && super.getName().equals( "Water" );
    }

    @Override
    public boolean checkBound( int row, int col, Material[][] grid ) {
        Material focus = grid[row][col];
        if ( !( focus instanceof Water ) )
            return false;
        if ( direction == LEFT ) {
            return col - 1 >= 0;
        } else if ( direction == DOWN ) {
            return row + 1 < grid.length;
        } else if ( direction == RIGHT ) {
            return col + 1 < grid[0].length;
        }
        return false;
    }

    @Override
    public int generateDirection( Random generator ) {
        int randomVal;
        // Generates an integer value from 1 to 3 inclusive.
        randomVal = generator.nextInt( 3 ) + 1;
        return randomVal;
    }

    @Override
    public Material[][] swap( int row, int col, Material[][] grid ) {
        int swapRow = row;
        int swapCol = col;
        Material originalMaterial;
        if ( direction == LEFT )
            swapCol--;
        else if ( direction == DOWN )
            swapRow++;
        else if ( direction == RIGHT )
            swapCol++;
        if ( grid[swapRow][swapCol] instanceof Empty ) {
            originalMaterial = grid[swapRow][swapCol];
            grid[swapRow][swapCol] = grid[row][col];
            grid[row][col] = originalMaterial;
        } else if ( grid[swapRow][swapCol] instanceof Ice ) {
            // 90% chance to become ice
            if ( Math.random() <= 0.9 ) {
                grid[row][col] = grid[swapRow][swapCol];
            }
        }
        return grid;
    }
}
