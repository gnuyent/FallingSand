package com.bnguyen.fallingsand.materials;

public class DirtySand extends Sand {
    public DirtySand() {
        super.setMaterialColor( DARKKHAKI );
        super.setName( "Dirty Sand" );
    }

    @Override
    public boolean equals( Object obj ) {
        return super.getMaterialColor().equals( DARKKHAKI ) && super.getName().equals( "Dirty Sand" );
    }
}
