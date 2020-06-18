/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omilia.it.core;

import com.omilia.it.validation.core.ValidationContext;
import com.omilia.it.validation.validators.PhoneNumberValidator;
import java.util.Set;

/**
 *
 * @author Abraham Piperidis
 */
public abstract class GeneratorBuilder {    
    public abstract Object generate();
    public abstract GeneratorBuilder with(String val);
    public abstract GeneratorBuilder skipGreekPhoneValidation(boolean val);
    
    /**
     * General validations
     * @param nums 
     */
    public void validate(Set<NumberRes> nums) {
        nums.stream().forEach(x-> x.setIsValid(new ValidationContext(new PhoneNumberValidator.ValidateGreekPhoneNumber("Not a valid Greek phone number",x.getPhone()))
                .checkValidation().getErrors().isEmpty()));
    }
}
