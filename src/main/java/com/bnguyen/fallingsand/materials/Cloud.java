package com.bnguyen.fallingsand.materials;

import com.bnguyen.fallingsand.materials.util.Movable;

import java.util.Random;

public class Cloud extends Material implements Movable {
    private boolean atTop = false; // boolean flag if particle is at the top of the screen

    public Cloud() {
        super.setMaterialColor( SMOKE );
        super.setName( "Cloud" );
    }

    @Override
    public boolean equals( Object obj ) {
        return super.getMaterialColor().equals( SMOKE ) && super.getName().equals( "Cloud" );
    }

    @Override
    public boolean checkBound( int row, int col, Material[][] grid ) {
        Material focus = grid[row][col];
        if ( !( focus instanceof Cloud ) )
            return false;
        if ( row - 1 == 0 ) // prevents from turning to water too early
            atTop = true;
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
            grid[swapRow][swapCol] = grid[row][col]; // make particle above cloud
            grid[row][col] = originalMaterial; // make particle focused empty
        } else if ( grid[swapRow][swapCol] instanceof Gas ) {
            Empty e = new Empty();
            DirtyWater dw = new DirtyWater();
            grid[swapRow][swapCol] = e; // remove gas particle
            grid[row][col] = dw; // create dirty water particle
        } else if ( atTop ) {
            atTop = false; // change flag as soon as possible
            Water w = new Water(); // turn into water
            grid[row][col] = w;
        }

        return grid;
    }
}
