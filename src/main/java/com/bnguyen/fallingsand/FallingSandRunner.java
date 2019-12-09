package com.bnguyen.fallingsand;

import com.bnguyen.fallingsand.materials.*;

public class FallingSandRunner {
    public static void main(String[] args) {
        // add newly added materials to this array
        Material[] materials = new Material[]{new Empty(), new Metal(), new Sand(), new Water()};
        SandLab lab = new SandLab(120, 80, materials);
        lab.run();
    }
}
