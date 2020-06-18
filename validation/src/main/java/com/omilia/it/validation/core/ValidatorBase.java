/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omilia.it.validation.core;

/**
 *
 * @author Abraham Piperidis
 * Base class for validations.
 * ALL validators MUST extends this class and implement their validation logic
 */
public abstract class ValidatorBase {
    private ValidatorBase successor;
    private final String error;
    protected ValidationContext.DispatchOnFail failOnConstraint;
    
    final void setFailOnConstraint(ValidationContext.DispatchOnFail fail) {
        this.failOnConstraint = fail;
    }
    
    public ValidatorBase(String err) {
        this.error = err;
    }
    
    final protected ValidatorBase getSuccessor() {
        return successor;
    }
    
    final protected <T extends ValidatorBase> T setSuccessor(ValidatorBase successor) {
        this.successor = successor;
        return (T) this;
    }
    
    public String getError() {
        return this.error;
    }
        
    public void validate(SimpleConstraintViolationException violation) throws SimpleConstraintViolationException {
        //If any error happend so far and dispatcher is configured to stop on error any pending validations
        if (this.failOnConstraint.equals(ValidationContext.DispatchOnFail.NO) && !violation.getErrors().isEmpty()) {
            throw violation;
        }
        if (this.successor != null) {
            this.successor.validate(violation);
        }
    }
}
