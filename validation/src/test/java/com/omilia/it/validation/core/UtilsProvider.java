/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omilia.it.validation.core;

/**
 *
 * @author Abraham Piperidis
 */
public class UtilsProvider {
    
    
    public static Object[] numbersProvider() {
        return new Object[] {
            new Object[]{3,"1 1 1"},
            new Object[]{3,"143   122 21"},
            new Object[]{5,"   14 1 21 213 2   "}
        };
    }
    
    
    public static Object[] numbersProvider2() {
        return new Object[] {
            new Object[]{"111","    1   1  1"},
            new Object[]{"6973111111","  6 97   3 111 1          11"},
            new Object[]{"",""},
            new Object[]{"12345","12345"}
        };
    }
}
