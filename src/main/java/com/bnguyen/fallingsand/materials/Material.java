package com.bnguyen.fallingsand.materials;

import java.awt.*;

import static com.bnguyen.fallingsand.materials.util.Constants.*;

/**
 * Base class for all materials.
 *
 * @author Brandon Nguyen
 */
public abstract class Material {
    public static int direction = DOWN; // set default down as most particles are affected by gravity
    private Color materialColor;
    private String name;

    /**
     * Matches a given particle identifier to the particle object.
     *
     * @param particleType Particle identifier to match.
     * @return A specific Material object defined by the given particle type.
     * @throws IllegalArgumentException if the given particle type is unable to be matched.
     */
    public static Material match( int particleType ) throws IllegalArgumentException {
        switch ( particleType ) {
            case EMPTY:
                return new Empty();
            case METAL:
                return new Metal();
            case SAND:
                return new Sand();
            case WATER:
                return new Water();
            case ICE:
                return new Ice();
            case GAS:
                return new Gas();
            case CLOUD:
                return new Cloud();
            default:
                throw new IllegalArgumentException( particleType + " is not a valid particle type." );
        }
    }

    /**
     * Matches a given Material to the particle identifier.
     *
     * @param particle Material to match.
     * @return An int defined by the given particle.
     * @throws IllegalArgumentException if the given Material is unable to be matched.
     */
    public static int match( Material particle ) throws IllegalArgumentException {
        switch ( particle.getName() ) {
            case "Empty":
                return EMPTY;
            case "Metal":
                return METAL;
            case "Sand":
                return SAND;
            case "Water":
                return WATER;
            case "Ice":
                return ICE;
            case "Gas":
                return GAS;
            case "Cloud":
                return CLOUD;
            default:
                throw new IllegalArgumentException( particle.getName() + " is not a valid Material." );
        }
    }

    public Color getMaterialColor() {
        return materialColor;
    }

    protected void setMaterialColor( Color materialColor ) {
        this.materialColor = materialColor;
    }

    public String getName() {
        return name;
    }

    protected void setName( String name ) {
        this.name = name;
    }

    public abstract boolean equals( Object obj ); // in case custom behavior needs to be checked
}
