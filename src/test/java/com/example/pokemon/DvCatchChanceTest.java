package com.example.pokemon;

import com.example.pokemon.model.dv.DvCatchChance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DvCatchChanceTest {

    DvCatchChance _catchChance1;
    DvCatchChance _catchChance123;
    DvCatchChance _catchChance255;

    public DvCatchChanceTest() {
        setup();
    }

    @BeforeEach
    void setup() {
        _catchChance1 = DvCatchChance.valueOf(1);
        _catchChance123 = DvCatchChance.valueOf(123);
        _catchChance255 = DvCatchChance.valueOf(255);
    }

    @Test
    void testValueOf() {
        assertSame(_catchChance1, DvCatchChance.valueOf(1));
        assertSame(_catchChance123, DvCatchChance.valueOf(123));
        assertSame(_catchChance255, DvCatchChance.valueOf(255));

        assertThrows(RuntimeException.class, () -> DvCatchChance.valueOf(0), "No valid catch rate.");
        assertThrows(RuntimeException.class, () -> DvCatchChance.valueOf(256), "No valid catch rate.");
        assertThrows(RuntimeException.class, () -> DvCatchChance.valueOf(Integer.MIN_VALUE), "No valid catch rate.");
        assertThrows(RuntimeException.class, () -> DvCatchChance.valueOf(Integer.MAX_VALUE), "No valid catch rate.");
    }

    @Test
    void testSame() {
        assertSame(_catchChance1, _catchChance1);
        assertNotSame(_catchChance1, _catchChance123);
        assertNotSame(_catchChance1, _catchChance255);
    }

    @Test
    void testEquals() {
        assertTrue(_catchChance1.equals(DvCatchChance.valueOf(1)));
        assertEquals(_catchChance1, DvCatchChance.valueOf(1));  //wird equals von der DvCatchChance-Klasse verwendet?
        assertTrue(_catchChance123.equals(DvCatchChance.valueOf(123)));
        assertEquals(_catchChance123, DvCatchChance.valueOf(123));
        assertTrue(_catchChance255.equals(DvCatchChance.valueOf(255)));
        assertEquals(_catchChance255, DvCatchChance.valueOf(255));

        assertTrue(_catchChance1.equals(_catchChance1));
        assertEquals(_catchChance1, _catchChance1);
        assertFalse(_catchChance1.equals(_catchChance123));
        assertEquals(_catchChance123, _catchChance123);
        assertFalse(_catchChance1.equals(_catchChance255));
        assertEquals(_catchChance255, _catchChance255);
    }

    @Test
    void testHashCode() {
        assertEquals(_catchChance1.hashCode(), DvCatchChance.valueOf(1).hashCode());
        assertEquals(_catchChance123.hashCode(), DvCatchChance.valueOf(123).hashCode());
        assertEquals(_catchChance255.hashCode(), DvCatchChance.valueOf(255).hashCode());

        assertEquals(_catchChance1.hashCode(), _catchChance1.hashCode());
        assertNotEquals(_catchChance1.hashCode(), _catchChance123.hashCode());
        assertNotEquals(_catchChance1.hashCode(), _catchChance255.hashCode());
    }

    @Test
    void testToString() {
        double d = Math.pow(10, 2);
        System.out.println((Math.round(0.579999 * d) / d));
        assertEquals("" + _catchChance1.getCatchRate() + " (2%)", _catchChance1.toString());
        assertEquals("" + _catchChance123.getCatchRate() + " (58%)", _catchChance123.toString());
        assertEquals("" + _catchChance255.getCatchRate() + " (100%)", _catchChance255.toString());
    }
}
