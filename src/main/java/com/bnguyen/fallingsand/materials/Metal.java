package com.bnguyen.fallingsand.materials;

import java.awt.*;

public class Metal extends Material {
    public Metal() {
        super.setMaterialColor(Color.DARK_GRAY);
        super.setName("Metal");
    }

    @Override
    public boolean equals(Object obj) {
        return super.getMaterialColor().equals(Color.DARK_GRAY) && super.getName().equals("Metal");
    }
}
