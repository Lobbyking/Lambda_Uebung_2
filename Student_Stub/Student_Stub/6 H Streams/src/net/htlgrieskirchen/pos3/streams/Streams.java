package net.htlgrieskirchen.pos3.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Streams {

    public double average(int[] numbers) {
        double erg = Arrays.stream(numbers).reduce(0, (int a, int b) -> a + b);

        return erg / numbers.length;
    }

    public List<String> upperCase(String[] strings) {
        List<String> erg = new ArrayList<>();

        Arrays.stream(strings)
                .forEach(a -> erg.add(a.toUpperCase()));

        return erg;
    }

    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        Comparator<Weapon> comparator = Comparator.comparing(Weapon::getDamage);

        if (weapons.size() != 0) {
            Weapon erg = weapons.stream().min(comparator).get();

            return erg;
        } else {
            return null;
        }
    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        Comparator<Weapon> comparator = Comparator.comparing(Weapon::getMinStrength);

        if (weapons.size() != 0) {
            Weapon erg = weapons.stream().max(comparator).get();

            return erg;
        } else {
            return null;
        }
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        List<Weapon> erg = new ArrayList<>();

        weapons.stream()
                .forEach(w -> {
                    if (w.getDamageType() == DamageType.MISSILE) {
                        erg.add(w);
                    }
                });

        return erg;
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        if (weapons.size() != 0) {
            Weapon erg = weapons.stream()
                    .max((a, b) -> a.getName().length() - b.getName().length())
                    .get();

            return erg;
        } else {
            return null;
        }
    }

    public List<String> toNameList(List<Weapon> weapons) {
        List<String> erg = new ArrayList<>();

        weapons.stream()
                .forEach(w -> erg.add(w.getName()));

        return erg;
    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        int[] erg = new int[weapons.size()];
        List<Integer> temp = new ArrayList<>();
        weapons.stream()
                .forEach(w -> {
                    erg[temp.size()] = w.getSpeed();
                    temp.add(1);
                });

        return erg;
    }

    public int sumUpValues(List<Weapon> weapons) {
        int erg = weapons.stream()
                .map(w -> w.getValue())
                .reduce(0, (a, b) -> a + b);

        return erg;
    }

    public long sumUpHashCodes(List<Weapon> weapons) {
        long erg = weapons.stream()
                .mapToLong(w -> w.hashCode())
                .sum();

        return erg;
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        List<Weapon> erg = new ArrayList<>();

        weapons.stream()
                .forEach(w -> {
                    if (!erg.contains(w)) {
                        erg.add(w);
                    }
                });

        return erg;
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        weapons.stream()
                .forEach(w -> w.setValue((int) (w.getValue() * 1.1)));
    }
}
