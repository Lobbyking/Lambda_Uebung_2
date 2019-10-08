package Uebung1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author flori
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static List<Weapon> weapons = new ArrayList<>();

    public static void main(String[] args) {
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

        weapons.sort((Weapon o1, Weapon o2) -> {
            if (!o1.getcT().equals(o2.getcT())) {
                return o1.getcT().toString().compareTo(o2.getcT().toString());
            } else if (!o1.getdT().equals(o2.getdT())) {
                return o1.getdT().toString().compareTo(o2.getdT().toString());
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        });

        Printable p1 = (weapons) -> {
            weapons.stream().
                    forEach((t) -> {
                        System.out.println(t.getName() + " " + t.getcT() + " " + t.getdT() + " " + t.getDamage() + " " + t.getSpeed() + " " + t.getStrength() + " " + t.getValue());
                    });
        };

        p1.print(weapons);

        System.out.println("");

        Printable p2 = ((weapons) -> {
            int cole1 = 0;
            int cole2 = 0;
            int cole3 = 0;
            int cole4 = 0;
            int cole5 = 0;
            int cole6 = 0;
            int cole7 = 0;

            for (int i = 0; i < weapons.size(); ++i) {
                String name = weapons.get(i).getName();
                if (name.length() > cole1) {
                    cole1 = name.length();
                }
                String ct = weapons.get(i).getcT().toString();
                if (ct.length() > cole2) {
                    cole2 = ct.length();
                }
                String dt = weapons.get(i).getdT().toString();
                if (dt.length() > cole3) {
                    cole3 = dt.length();
                }
                String damage = String.valueOf(weapons.get(i).getDamage());
                if (damage.length() > cole4) {
                    cole4 = damage.length();
                }
                String speed = String.valueOf(weapons.get(i).getSpeed());
                if (speed.length() > cole5) {
                    cole5 = speed.length();
                }
                String strength = String.valueOf(weapons.get(i).getStrength());
                if (strength.length() > cole6) {
                    cole6 = strength.length();
                }
                String value = String.valueOf(weapons.get(i).getValue());
                if (value.length() > cole7) {
                    cole7 = value.length();
                }
            }

            System.out.println("+-----------------+------+--------+--+-+--+-----+");
            
            for (int i = 0; i < weapons.size(); ++i) {
                String name = weapons.get(i).getName();
                if (name.length() == cole1) {
                    System.out.print("|" + name + "|");
                } else {
                    System.out.print("|" + name);
                    for (int j = name.length(); j < cole1; ++j) {
                        System.out.print(" ");
                    }
                    System.out.print("|");
                }
                String ct = weapons.get(i).getcT().toString();
                if (ct.length() == cole2) {
                    System.out.print(ct + "|");
                } else {
                    System.out.print(ct);
                    for (int j = ct.length(); j < cole2; ++j) {
                        System.out.print(" ");
                    }
                    System.out.print("|");
                }
                String dt = weapons.get(i).getdT().toString();
                if (dt.length() == cole3) {
                    System.out.print(dt + "|");
                } else {
                    System.out.print(dt);
                    for (int j = dt.length(); j < cole3; ++j) {
                        System.out.print(" ");
                    }
                    System.out.print("|");
                }
                String damage = String.valueOf(weapons.get(i).getDamage());
                if (damage.length() == cole4) {
                    System.out.print(damage + "|");
                } else {
                    System.out.print(damage);
                    for (int j = damage.length(); j < cole4; ++j) {
                        System.out.print(" ");
                    }
                    System.out.print("|");
                }
                String speed = String.valueOf(weapons.get(i).getSpeed());
                if (speed.length() == cole5) {
                    System.out.print(speed + "|");
                } else {
                    System.out.print(speed);
                    for (int j = speed.length(); j < cole5; ++j) {
                        System.out.print(" ");
                    }
                    System.out.print("|");
                }
                String strength = String.valueOf(weapons.get(i).getStrength());
                if (strength.length() == cole6) {
                    System.out.print(strength + "|");
                } else {
                    System.out.print(strength);
                    for (int j = strength.length(); j < cole6; ++j) {
                        System.out.print(" ");
                    }
                    System.out.print("|");
                }
                String value = String.valueOf(weapons.get(i).getValue());
                if (value.length() == cole7) {
                    System.out.print(value + "|");
                } else {
                    System.out.print(value);
                    for (int j = value.length(); j < cole7; ++j) {
                        System.out.print(" ");
                    }
                    System.out.print("|");
                }
                System.out.println("");
            }
            System.out.println("+-----------------+------+--------+--+-+--+-----+");

        });

        p2.print(weapons);

    }
}
