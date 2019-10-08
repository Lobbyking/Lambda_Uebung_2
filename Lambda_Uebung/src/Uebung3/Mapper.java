/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uebung3;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author flori
 */
public interface Mapper<S, T> {
    
    public T map(S x);
    
    public default List<T> mapAll(List<S> names){
        List<T> erg = new ArrayList<>();
        
        names.stream()
                .forEach(w -> erg.add(map(w)));
        
        return erg;
    };
}
