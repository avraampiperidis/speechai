/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omilia.it.core;

/**
 *
 * @author Abraham Piperidis
 */
public class Provider {
    
    public static Object[] phoneProvider() {
        return new Object[] {
            new Object[]{32,"69 73 00 13 40"},
            new Object[]{60,"0 0 30 69 71 22 4 254"}
        };
    }
    
    public static Object[] invalidPhoneProvider() {
        return new Object[] {
            new Object[]{"6970111011"},
            new Object[]{"0 0 30 69 7158 22 4 254"},
        };
    }
       
}
