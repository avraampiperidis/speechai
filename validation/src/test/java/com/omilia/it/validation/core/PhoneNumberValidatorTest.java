/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omilia.it.validation.core;

import com.omilia.it.validation.validators.PhoneNumberValidator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Abraham Piperidis
 */

@RunWith(JUnitParamsRunner.class)
public class PhoneNumberValidatorTest {
    
    
    @Test(expected = SimpleConstraintViolationException.class)
    public void testValidatePhoneOnlyDigitsFail() {
        new ValidationContext(new PhoneNumberValidator
                .ValidatePhoneOnlyDigits(null,"69765A5485"))
                .handleValidation();
    }
    
    @Test
    @Parameters(source = PhoneProvider.class, method = "phoneProvider")
    public void testValidateInputSequenceLength(String value) {
         new ValidationContext(new PhoneNumberValidator.ValidateInputSequenceLength(null,value)).handleValidation();
    }
    
    @Test
    @Parameters(source = PhoneProvider.class, method = "greekPhoneProvider")
    public void testValidateGreekPhoneNumber(String phone) {
        new ValidationContext(new PhoneNumberValidator.ValidateGreekPhoneNumber(null,phone)).handleValidation();
    }
    
    
    @Test
    public void testValidatePhoneOnlyDigits() {
         new ValidationContext(new PhoneNumberValidator
                .ValidatePhoneOnlyDigits(null,"6976585485"))
                .handleValidation();
    }
    
    
    @Test(expected = SimpleConstraintViolationException.class)
    public void testValidateInputSequenceLengthFail() {
         new ValidationContext(new PhoneNumberValidator
                .ValidateInputSequenceLength(null,"697 25 6265 5"))
                .handleValidation();
    }
    
    @Test(expected = SimpleConstraintViolationException.class)
    public void testValidateGreekPhoneNumberFail() {
        new ValidationContext(new PhoneNumberValidator
                .ValidateGreekPhoneNumber(null,"343234"))
                .handleValidation();
    }
    
    @Test
    public void testValidateGreekPhoneNumberTemp() {
        SimpleConstraintViolationException ex = new ValidationContext(new PhoneNumberValidator
                .ValidateGreekPhoneNumber(null,"6559884"),ValidationContext.DispatchOnFail.YES)
                .and(new PhoneNumberValidator
                .ValidateGreekPhoneNumber(null,"5545sdfas555"))
                .checkValidation();
        assertEquals(2,ex.getErrors().size());
    }
    
    
}
