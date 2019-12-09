package com.bnguyen.fallingsand.materials;

import java.awt.*;

public class Ice extends Material {
    public Ice() {
        super.setMaterialColor( Color.WHITE );
        super.setName( "Ice" );
    }

    @Override
    public boolean equals( Object obj ) {
        return super.getMaterialColor().equals( Color.WHITE ) && super.getName().equals( "Ice" );
    }
}
