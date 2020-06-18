/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omilia.it.validation.validators;

import com.omilia.it.validation.core.SimpleConstraintViolationException;
import com.omilia.it.validation.core.Utils;
import com.omilia.it.validation.core.ValidatorBase;
import java.util.StringTokenizer;

/**
 *
 * @author Abraham Piperidis
 */
public final class PhoneNumberValidator {
    private PhoneNumberValidator(){}
    
    
    public final static class ValidatePhoneOnlyDigits extends ValidatorBase {
        private final String phone;
        public ValidatePhoneOnlyDigits(String err,String p) {
            super(err);
            this.phone = p;
        }
        @Override
        public void validate(SimpleConstraintViolationException ex) throws SimpleConstraintViolationException {
            if(!phone.matches("^[0-9 ]+$")) {
                ex.addError(getError());
            }
            super.validate(ex);
        }
    }
    
    
    public final static class ValidateInputSequenceLength extends ValidatorBase {
        private final String phone;
        public ValidateInputSequenceLength(String err,String p) {
            super(err);
            this.phone = p;
        }
        
        @Override
        public void validate(SimpleConstraintViolationException ex) throws SimpleConstraintViolationException {
            StringTokenizer st = new StringTokenizer(phone);
            while (st.hasMoreTokens()) {
                if(st.nextToken().length() > 3) {
                    ex.addError(getError());
                    break;
                }
            }
            super.validate(ex);
        }
    }
    
    
    public final static class ValidateGreekPhoneNumber extends ValidatorBase {
        private final String phone;
        public ValidateGreekPhoneNumber(String err,String p) {
            super(err);
            this.phone = p;
        }
        @Override
        public void validate(SimpleConstraintViolationException ex) throws SimpleConstraintViolationException {
            String p = Utils.removeSpaces(phone);
            if((p.length() == 10 && (p.startsWith("2") || p.startsWith("69")))
                    || (p.length() == 14 && (p.startsWith("00302") || p.startsWith("003069")))) {
                super.validate(ex);
                return;
            }
            ex.addError(getError());
            super.validate(ex);
        }
    }
    
}
