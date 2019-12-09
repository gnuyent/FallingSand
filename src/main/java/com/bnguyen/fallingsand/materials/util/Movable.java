package com.bnguyen.fallingsand.materials.util;

import com.bnguyen.fallingsand.materials.Material;

/**
 * A material that implements custom behavior over time.
 *
 * @author Brandon Nguyen
 */
public interface Movable {
    /**
     * Checks if a certain value is within the bounds of the grid.
     *
     * @param row  An int value that contains the original row to check.
     * @param col  An int value that contains the original column to check.
     * @param grid A two-dimensional array of all particle positions.
     * @return True if bounds are valid. False if bounds are invalid.
     */
    boolean checkBound(int row, int col, Material[][] grid);

    /**
     * Custom material behavior that is run every time the display is updated.
     *
     * @param grid A two-dimensional array of all particle positions.
     * @return An updated two-dimensional array after one particle update.
     */
    Material[][] step(Material[][] grid);

    /**
     * Swaps two materials within the supplied grid.
     *
     * @param row  An int value that contains the original row to swap.
     * @param col  An int value that contains the original column to swap.
     * @param grid A two-dimensional array of all particle positions.
     * @return An updated two-dimensional array after two materials are swapped.
     */
    Material[][] swap(int row, int col, Material[][] grid);
}
