/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omilia.it.validation.core;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Abraham Piperidis
 */
public class Utils {
    
    public static List<String> convertToBlocks(String phone) {
        List<String> parts = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(phone);
        while (st.hasMoreTokens()) {
            parts.add(st.nextToken());
        }
        return parts;
    }
    
    
    public static String toString(List<String> blocks) {
        return blocks.stream().reduce("", String::concat);
    }
    
    //could be implemented more efficient
    public static String removeSpaces(String phone) {
        return toString(convertToBlocks(phone));
    }
}
