/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uebung4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 *
 * @author flori
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final Predicate<Integer> isEven = x -> x % 2 == 0;
        final Predicate<Integer> isPositiv = x -> x > 0;
        final IntPredicate isZero = x -> x == 0;
        final IntPredicate isNull = x -> String.valueOf(x) == null;

        List<Integer> testList = new ArrayList<>(Arrays.asList(-4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> ergList = new ArrayList<>();
        System.out.println("IsEven Test");
        System.out.println(testList);
        testList.stream()
                .filter(isEven)
                .forEach(x -> ergList.add(x));
        System.out.println(ergList);
        ergList.clear();
        System.out.println("");
        System.out.println("IsPositiv Test");
        System.out.println("Zahl -4");
        System.out.println(isPositiv.test(-4));
        System.out.println("Zahl 3");
        System.out.println(isPositiv.test(3));
        System.out.println("");
        System.out.println("IsZero Test");
        System.out.println("Zahl 0");
        System.out.println(isZero.test(0));
        System.out.println("");
        System.out.println("IsNull Test");
        System.out.println(isNull.test(0));
        System.out.println("");
        System.out.println("IsPositiv und IsEven Test");
        System.out.println(testList);
        testList.stream()
                .filter(isPositiv.and(isEven))
                .forEach(w -> ergList.add(w));
        System.out.println(ergList);
        ergList.clear();
        System.out.println("");
        System.out.println("IsPositiv and IsEven negated Test");
        System.out.println(testList);
        testList.stream()
                .filter(isPositiv.and(isEven.negate()))
                .forEach(w -> ergList.add(w));
        System.out.println(ergList);
        ergList.clear();
        System.out.println("");               

        final Predicate<String> isShortWord = s -> s.split("").length <= 4;

        System.out.println("IsShortWord Test");
        System.out.println("Wort: Hallo");
        System.out.println(isShortWord.test("Hallo"));
        System.out.println("Wort: Java");
        System.out.println(isShortWord.test("Java"));
    }

}
