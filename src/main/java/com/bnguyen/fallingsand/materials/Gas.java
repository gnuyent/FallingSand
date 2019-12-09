package com.bnguyen.fallingsand.materials;

import com.bnguyen.fallingsand.materials.util.Movable;

import java.util.Random;

/**
 * Places a gas particle in any direction one tile away from the cursor.
 */
public class Gas extends Material implements Movable {
    public Gas() {
        super.setMaterialColor( SALMON );
        super.setName( "Gas" );
    }

    @Override
    public boolean equals( Object obj ) {
        return super.getMaterialColor().equals( SALMON ) && super.getName().equals( "GAS" );
    }

    @Override
    public boolean checkBound( int row, int col, Material[][] grid ) {
        Material focus = grid[row][col];
        if ( !( focus instanceof Gas ) )
            return false;
        if ( direction == LEFT ) {
            return col - 1 >= 0;
        } else if ( direction == UP ) {
            return row - 1 >= 0;
        } else if ( direction == RIGHT ) {
            return col + 1 < grid[0].length;
        }
        return false;
    }

    @Override
    public int generateDirection( Random generator ) {
        int randomVal;
        // Generates an integer value from 0 to 3 inclusive, excluding 1.
        do {
            randomVal = generator.nextInt( 4 );
        } while ( randomVal == DOWN );
        return randomVal;
    }

    @Override
    public Material[][] swap( int row, int col, Material[][] grid ) {
        int swapRow = row;
        int swapCol = col;
        Material originalMaterial;
        if ( direction == LEFT )
            swapCol--;
        else if ( direction == UP )
            swapRow--;
        else if ( direction == RIGHT )
            swapCol++;
        if ( grid[swapRow][swapCol] instanceof Empty ) {
            originalMaterial = grid[swapRow][swapCol];
            grid[swapRow][swapCol] = grid[row][col]; // make particle above gas
            grid[row][col] = originalMaterial; // make particle focused empty
        }
        return grid;
    }
}
