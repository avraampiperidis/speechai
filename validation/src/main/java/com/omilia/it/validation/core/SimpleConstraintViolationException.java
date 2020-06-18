/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omilia.it.validation.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abraham Piperidis
 */
public class SimpleConstraintViolationException extends RuntimeException {
    public final List<String> pairs = new ArrayList<>();
    
    public void addError(String err) {
        pairs.add(err);
    }
    
    public List<String> getErrors() {
        return this.pairs;
    }
    
}
