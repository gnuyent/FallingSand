package com.bnguyen.fallingsand.materials;

import java.awt.*;

public class Empty extends Material {
    public Empty() {
        super.setMaterialColor(Color.BLACK);
        super.setName("Empty");
    }

    @Override
    public boolean equals(Object obj) {
        return super.getMaterialColor().equals(Color.BLACK) && super.getName().equals("Empty");
    }
}
