package com.bnguyen.fallingsand.materials.util;

import java.awt.*;

/**
 * Constants and global variables
 */
public interface Constants {
    /**
     * Particle Identifiers
     */
    int EMPTY = 0, METAL = 1, SAND = 2, WATER = 3, ICE = 4, GAS = 5, CLOUD = 6;
    /**
     * Color names
     */
    Color SALMON = new Color( 255, 160, 122 ),
            DARKKHAKI = new Color( 189, 183, 107 ),
            CADETBLUE = new Color( 95, 158, 160 ),
            SMOKE = new Color( 190, 190, 190 );
    /**
     * Directions
     */
    int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
}
