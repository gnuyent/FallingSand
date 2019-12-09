package com.bnguyen.fallingsand.materials;

import org.junit.jupiter.api.Test;
import com.bnguyen.fallingsand.materials.Material;

import static org.junit.jupiter.api.Assertions.*;

class MaterialTest {

    @Test
    void testMatch() {
        assertEquals(new Empty(), Material.match(0));
        assertEquals(new Metal(), Material.match(1));
        assertEquals(new Sand(), Material.match(2));
        assertEquals(0, Material.match(new Empty()));
        assertEquals(1, Material.match(new Metal()));
        assertEquals(2, Material.match(new Sand()));
    }

    @Test
    void getMaterialColor() {
    }

    @Test
    void setMaterialColor() {
    }

    @Test
    void getName() {
    }

    @Test
    void setName() {
    }
}