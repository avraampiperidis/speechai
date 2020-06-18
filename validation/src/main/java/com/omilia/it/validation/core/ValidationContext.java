/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omilia.it.validation.core;

/**
 *
 * @author Abraham Piperidis
 * Chain of responsibility dp
 */
public final class ValidationContext<T extends ValidatorBase> {
    public static enum DispatchOnFail {
        NO,
        YES
    }
    private T validator;
    
    public ValidationContext(T t, DispatchOnFail failOnConstraint) {
        this.validator = t;
        this.validator.setFailOnConstraint(failOnConstraint);
    }
    
    public ValidationContext(T t) {
        this(t,DispatchOnFail.YES);
    }
    
    public ValidationContext<T> and(T t) {
        t.setFailOnConstraint(this.validator.failOnConstraint);
        this.validator = t.setSuccessor(validator);
        return this;
    }
  
    public void handleValidation() {
        SimpleConstraintViolationException ex = this.checkValidation();
        if (!ex.getErrors().isEmpty()) {
            throw ex;
        }
    }
    
    public SimpleConstraintViolationException checkValidation()  {
        return this.checkValidation(new SimpleConstraintViolationException());
    }
    
    public SimpleConstraintViolationException checkValidation(SimpleConstraintViolationException ex)  {
        validator.validate(ex);
        return ex;
    }
 
}
