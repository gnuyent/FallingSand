package com.bnguyen.fallingsand.materials;

public class DirtyWater extends Water {
    public DirtyWater() {
        super.setMaterialColor( CADETBLUE );
        super.setName( "Dirty Water" );
    }

    @Override
    public boolean equals( Object obj ) {
        return super.getMaterialColor().equals( CADETBLUE ) && super.getName().equals( "Dirty Water" );
    }
}
