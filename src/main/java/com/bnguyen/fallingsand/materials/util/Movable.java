package com.bnguyen.fallingsand.materials.util;

import com.bnguyen.fallingsand.materials.Material;

import java.util.Random;

/**
 * A material that implements custom behavior over time.
 *
 * @author Brandon Nguyen
 */
public interface Movable extends Constants {
    /**
     * Checks if a certain value is within the bounds of the grid.
     *
     * @param row  An int value that contains the original row to check.
     * @param col  An int value that contains the original column to check.
     * @param grid A two-dimensional array of all particle positions.
     * @return True if bounds are valid. False if bounds are invalid.
     */
    boolean checkBound( int row, int col, Material[][] grid );

    /**
     * Custom behavior for determining which direction to move a particle
     *
     * @param r Random object
     * @return int direction to move particle (0-3) (see Constants interface)
     */
    int generateDirection( Random r );

    /**
     * Custom material behavior that is run every time the display is updated.
     *
     * @param grid A two-dimensional array of all particle positions.
     * @return An updated two-dimensional array after one particle update.
     */
    default Material[][] step( Material[][] grid ) {
        int randomRow;
        int randomCol;
        Random generator;
        generator = new Random();
        Material.direction = generateDirection( generator ); // uses global variable from Material class
        randomRow = generator.nextInt( grid.length );
        randomCol = generator.nextInt( grid[0].length );
        if ( checkBound( randomRow, randomCol, grid ) )
            grid = swap( randomRow, randomCol, grid );
        return grid;
    }

    /**
     * Swaps two materials within the supplied grid.
     *
     * @param row  An int value that contains the original row to swap.
     * @param col  An int value that contains the original column to swap.
     * @param grid A two-dimensional array of all particle positions.
     * @return An updated two-dimensional array after two materials are swapped.
     */
    Material[][] swap( int row, int col, Material[][] grid );
}
