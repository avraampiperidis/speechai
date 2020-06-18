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
public class PhoneProvider {
    
    public static Object[] phoneProvider() {
        return new Object[] {
            new Object[]{"5 5"},
            new Object[]{" 5 5  "},
            new Object[]{"697 30 0 0 0 00 340"},
            new Object[]{" 8 52 522"},
        };
    }
    
    
    public static Object[] greekPhoneProvider() {
        return new Object[] {
            new Object[]{"6973001111"},
            new Object[]{"00306976555555"},
            new Object[]{"00302315555556"},
            new Object[]{"6900000000"},
        };
    }
}
