package com.bnguyen.fallingsand.materials;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SandTest {

    @Test
    void step() {
    }

    @Test
    void testEquals() {
        Material[][] grid = new Material[50][50];
        Empty e = new Empty();
        Sand s = new Sand();
        for (Material[] row : grid)
            Arrays.fill(row, e);

        grid[0][0] = new Sand();
//        while(grid[0][0].equals(s) && ) {
//
//        }

    }
}