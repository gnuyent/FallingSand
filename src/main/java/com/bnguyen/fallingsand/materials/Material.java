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
        if (particleType == EMPTY)
            return new Empty();
        else if (particleType == METAL)
            return new Metal();
        else if (particleType == SAND)
            return new Sand();
        else if (particleType == WATER)
            return new Water();
        else
            throw new IllegalArgumentException(particleType + " is not a valid particle type.");
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
                return 0;
            case "Metal":
                return 1;
            case "Sand":
                return 2;
            case "Water":
                return 3;
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
