package Uebung5;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

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
    public static void main(String[] args) {
        boolean result = vergleich((a) -> a == 5, 5);
        anzeige((Integer i) -> System.out.println("Vergleich " + i + " == 5 " + result),5);
        boolean result1 = biVergleich((a,b) -> a == b * 2,10,5);
        biAnzeige((Integer i1, Integer i2) -> 
                System.out.println("Das Ergebnis des Testes " + i2 + " * 2 == "
                + i1 + " mit BiPredicate ist " + result1), 10,5);
        Integer result6 = biBerechnung((Integer i1, Integer i2) -> i1 + i2,5,10);
        biAnzeige((Integer i1, Integer i2) -> 
        System.out.println("Der Wert der BiFunction mit den Argumenten "
                + i1 + " und " + i2 + " ist " + result6), 10,5);
        
        Integer erg = berechnungmitBinaryOperator((Integer i1, Integer i2) -> Integer.max(i1, i2), 1, 10);
        anzeige((Integer i) -> System.out.println("BinaryOperator Maximum von 1 und 10: " + i), erg);   
                
    }
    
    public static boolean vergleich(Predicate<Integer> predicate, Integer i){       
        return predicate.test(i);
    };
    
    public static void anzeige(Consumer<Integer> consumer, Integer i){
        consumer.accept(i);
    };
    
    public static boolean biVergleich(BiPredicate<Integer,Integer> biPredicate, Integer i1, Integer i2){        
        return biPredicate.test(i1, i2);
    };
    
    public static void biAnzeige(BiConsumer<Integer, Integer> biConsumer, Integer i1, Integer i2){
        biConsumer.accept(i1, i2);
    };
    
    public static Integer berechnung(Function<Integer,Integer> function, Integer i){
        return function.apply(i);
    };
    
    public static Integer biBerechnung(BiFunction<Integer, Integer, Integer> function, Integer i1, Integer i2){
        Integer c = function.apply(i1, i2);
        return c;
    };
    
    public static Integer berechnungmitBinaryOperator(BinaryOperator<Integer> binaryOperator, Integer i1, Integer i2){
        return binaryOperator.apply(i1, i2);
    }
}
