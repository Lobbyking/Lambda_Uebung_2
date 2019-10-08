/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.streams;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author flori
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Streams streams = new Streams();

        //Int Array
        int[] ints = new int[1000];

        for (int i = 0; i < ints.length; ++i) {
            ints[i] = (int) (Math.random() * (100 - 1) + 1);
            System.out.println(ints[i]);
        }

        double average = streams.average(ints);

        System.out.println(average);

        //String Array
        String[] strings = new String[10];

        //97 - 122
        for (int i = 0; i < strings.length; ++i) {
            String add = "";

            for (int j = 0; j < 10; ++j) {
                int randi = (int) (Math.random() * (122 - 97) + 1) + 97;
                add = add + Character.toString((char) randi);
            }

            strings[i] = add;
        }

        List<String> upperCase = streams.upperCase(strings);

        System.out.println(upperCase);
        
        //Weapons.csv lesen
        List<Weapon> weapons = new ArrayList<>();
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
        
        
    }

}
