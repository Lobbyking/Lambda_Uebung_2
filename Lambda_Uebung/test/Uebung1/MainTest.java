/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uebung1;

import static Uebung1.Main.weapons;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author flori
 */
public class MainTest {

    public MainTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testFirstComp() {
        File f = new File("weapons.csv");
        try {
            List<String> temp = new ArrayList<>();
            temp = Files.readAllLines(f.toPath());

            temp.stream()
                    .skip(1)
                    .map(s -> s.split(";"))
                    .forEach((t) -> {
                        String name = t[0];
                        CombatType cT = CombatType.valueOf(t[1]);
                        DamageType dT = DamageType.valueOf(t[2]);
                        int damage = Integer.valueOf(t[3]);
                        int speed = Integer.valueOf(t[4]);
                        int strength = Integer.valueOf(t[5]);
                        int value = Integer.valueOf(t[6]);
                        weapons.add(new Weapon(name, cT, dT, damage, speed, strength, value));
                    });

        } catch (Exception e) {
            System.out.println("Fehler");
        }

        weapons.sort((o1, o2) -> {
            return o2.getDamage() - o1.getDamage();
        });

        Weapon w = weapons.get(0);

        for (int i = 1; i < weapons.size(); ++i) {
            if (w.getDamage() >= weapons.get(i).getDamage()) {
                assertTrue("Richtig sortiert", true);
            } else {
                assertFalse("Falsch sortiert", true);
            }
        }
    }

    @Test
    public void testSecondComp() {
        File f = new File("weapons.csv");
        try {
            List<String> temp = new ArrayList<>();
            temp = Files.readAllLines(f.toPath());

            temp.stream()
                    .skip(1)
                    .map(s -> s.split(";"))
                    .forEach((t) -> {
                        String name = t[0];
                        CombatType cT = CombatType.valueOf(t[1]);
                        DamageType dT = DamageType.valueOf(t[2]);
                        int damage = Integer.valueOf(t[3]);
                        int speed = Integer.valueOf(t[4]);
                        int strength = Integer.valueOf(t[5]);
                        int value = Integer.valueOf(t[6]);
                        weapons.add(new Weapon(name, cT, dT, damage, speed, strength, value));
                    });

        } catch (Exception e) {
            System.out.println("Fehler");
        }

        weapons.sort((Weapon o1, Weapon o2) -> {
            if (!o1.getcT().equals(o2.getcT())) {
                return o1.getcT().toString().compareTo(o2.getcT().toString());
            } else if (!o1.getdT().equals(o2.getdT())) {
                return o1.getdT().toString().compareTo(o2.getdT().toString());
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        });

        CombatType comb = weapons.get(0).getcT();  //MELEE
        DamageType dama = weapons.get(0).getdT();  //BLUNT
        String name = weapons.get(0).getName();    //Crom Faeyr

        for (int i = 6; i < weapons.size(); ++i) {
            if (comb.toString().compareTo(weapons.get(i).getcT().toString()) > 0 || comb.toString().compareTo(weapons.get(i).getcT().toString()) == 0) {
                if (dama.toString().compareTo(weapons.get(i).getdT().toString()) > 0 || dama.toString().compareTo(weapons.get(i).getdT().toString()) == 0) {
                    if (name.compareTo(weapons.get(i).getName()) < 0) {
                        assertTrue("Richtig sortiert", true);
                    } else {
                        assertFalse("Falsch Sortiert", true);
                    }
                } else {
                    dama = weapons.get(i).getdT();
                }
            } else {
                comb = weapons.get(i).getcT();
                if (weapons.get(i).getdT() != dama) {
                    dama = weapons.get(i).getdT();
                }
            }
        }
    }
}
