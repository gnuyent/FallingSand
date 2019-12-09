package com.bnguyen.fallingsand.materials;

import com.bnguyen.fallingsand.materials.util.Movable;

import java.awt.*;
import java.util.Random;

public class Sand extends Material implements Movable {
    public Sand() {
        super.setMaterialColor( Color.YELLOW );
        super.setName( "Sand" );
    }

    @Override
    public boolean checkBound( int row, int col, Material[][] grid ) {
        Material focusMaterial = grid[row][col]; // Value of given row/col
        if ( !( row + 1 < grid.length ) )
            return false;
        Material belowMaterial = grid[row + 1][col]; // Value below given row/col
        boolean focusLocation = focusMaterial instanceof Sand; // Validity of given row/col
        boolean belowLocation = belowMaterial instanceof Empty || belowMaterial instanceof Water; // Validity below given row/col
        return focusLocation && belowLocation;
    }

    @Override
    public int generateDirection( Random r ) {
        return DOWN; // direction not needed
    }

    @Override
    public Material[][] swap( int row, int col, Material[][] grid ) {
        Material originalMaterial = grid[row + 1][col];
        if ( originalMaterial instanceof DirtyWater ) {
            DirtySand ds = new DirtySand();
            grid[row + 1][col] = ds; // replace dirty water with dirty sand
        } else
            grid[row + 1][col] = grid[row][col];
        if ( originalMaterial instanceof Empty )
            grid[row][col] = originalMaterial;
        else if ( originalMaterial instanceof Water ) {
            Empty e = new Empty();
            grid[row][col] = e;
        }
        return grid;
    }

    @Override
    public boolean equals( Object obj ) {
        return super.getMaterialColor().equals( Color.YELLOW ) && super.getName().equals( "Sand" );
    }
}
