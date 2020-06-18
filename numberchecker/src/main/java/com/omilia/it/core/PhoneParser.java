/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omilia.it.core;

import com.omilia.it.validation.core.Utils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Abraham Piperidis
 * 
 * functions to find abiguity similar phone numbers
 */
public class PhoneParser {
    
    public static Set<String> phoneNumber(List<String> list) {
        Set<String> results = new HashSet<>();
        results.add(Utils.toString(list));
        for (int i = 0; i < list.size(); i++) {
            parse(list, i, results);
        }
        return results;
    }

    private static void append(List<String> copyList, int i, String substring, StringBuilder line, Set<String> results) {
        copyList.set(i, substring);
        line.append(substring);
        parse(copyList, i, results);
    }

    private static void parse(List<String> blocks, int index, Set<String> results) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < blocks.size(); i++) {
            String block = blocks.get(i);
            if (i != index) {
                if (block.length() > 1) {
                    if (block.length() == 2) {
                        if ((!block.equals("00") && !block.equals("11") && !block.equals("12") && !block.startsWith("0"))) {
                            if (block.charAt(1) == '0') {
                                append(new ArrayList<>(blocks), i, block.substring(0, 1), line, results);
                            } else {
                                append(new ArrayList<>(blocks), i, block.substring(0, 1) + "0" + block.substring(1, 2), line, results);
                            }
                        } else {
                            line.append(block);
                        }
                    } else if (block.length() == 3) {
                        if (block.charAt(1) == '0' && block.charAt(2) == '0') {
                            block = block.substring(0, 1);
                            append(new ArrayList<>(blocks), i, block, line, results);
                        } else {
                            String ch = (block.charAt(1) == '0' && block.charAt(2) != '0')
                                    ? block.substring(2, 3) : block.substring(1, 3);
                            block = block.substring(0, 1) + "00" + ch;
                            append(new ArrayList<>(blocks), i, block, line, results);
                        }
                    }
                } else if (block.length() == 1) {
                    line.append(block);
                }
            } else if (i == index) {
                line.append(block);
            }
            if (i == blocks.size() - 1) {
                results.add(line.toString());
                line = new StringBuilder();
            }
        }
    }
}
