package com.bnguyen.fallingsand.materials;

import java.awt.*;

/**
 * Base class for all materials.
 *
 * @author Brandon Nguyen
 */
public abstract class Material {
    public static final int EMPTY = 0, METAL = 1, SAND = 2, WATER = 3;
    protected static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    protected int direction = DOWN;
    private Color materialColor;
    private String name;

    /**
     * Matches a given particle identifier to the particle object.
     *
     * @param particleType Particle identifier to match.
     * @return A specific Material object defined by the given particle type.
     * @throws IllegalArgumentException if the given particle type is unable to be matched.
     */
    public static Material match(int particleType) throws IllegalArgumentException {
        switch (particleType) {
            case EMPTY:
                return new Empty();
            case METAL:
                return new Metal();
            case SAND:
                return new Sand();
            case WATER:
                return new Water();
            default:
                throw new IllegalArgumentException(particleType + " is not a valid particle type.");
        }
    }

    /**
     * Matches a given Material to the particle identifier.
     *
     * @param particle Material to match.
     * @return An int defined by the given particle.
     * @throws IllegalArgumentException if the given Material is unable to be matched.
     */
    public static int match(Material particle) throws IllegalArgumentException {
        switch (particle.getName()) {
            case "Empty":
                return EMPTY;
            case "Metal":
                return METAL;
            case "Sand":
                return SAND;
            case "Water":
                return WATER;
            default:
                throw new IllegalArgumentException(particle.getName() + " is not a valid Material.");
        }
    }

    public Color getMaterialColor() {
        return materialColor;
    }

    protected void setMaterialColor(Color materialColor) {
        this.materialColor = materialColor;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public abstract boolean equals(Object obj);
}
