    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uebung5;

import java.util.stream.IntStream;

/**
 *
 * @author flori
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int result = IntStream.of(1,2,3,4,5,6,7,8,9,10).filter(x -> x % 2 != 0).map(x -> (int) Math.pow(x, 2)).reduce(0, (a,b) -> a+b);
        
        System.out.println(result);
    }
    
}
