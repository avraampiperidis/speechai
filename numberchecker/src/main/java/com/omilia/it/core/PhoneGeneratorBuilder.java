/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omilia.it.core;

import com.omilia.it.validation.core.SimpleConstraintViolationException;
import com.omilia.it.validation.core.Utils;
import com.omilia.it.validation.core.ValidationContext;
import com.omilia.it.validation.validators.PhoneNumberValidator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Abraham Piperidis
 */
public class PhoneGeneratorBuilder extends GeneratorBuilder {
    
    private String phone;
    private boolean applyValidation;
   
    @Override
    public PhoneGeneratorBuilder with(String phone) throws SimpleConstraintViolationException {
        this.phone = phone;
        return this;
    }
    
    @Override
    public PhoneGeneratorBuilder with(boolean applyValidation) {
        this.applyValidation = applyValidation;
        return this;
    }
    
    @Override
    public Set<NumberRes> generate() {
        //Mandatory validations about phone spaces and blocks length
        new ValidationContext(new PhoneNumberValidator.ValidateInputSequenceLength("Wrong input sequence/spaces!", phone))
                .and(new PhoneNumberValidator.ValidatePhoneOnlyDigits("Only digits and spaces allowed!", phone))
                .handleValidation();
        Set<NumberRes> nums = PhoneParser.phoneNumber(Utils.convertToBlocks(phone))
                .stream().map(x -> new NumberRes(x)).collect(Collectors.toSet());
        if(applyValidation) {
            this.validate(nums);
        }
        return nums;
    }
    
    
    /**
     * Override for custom specific validations
     * @param nums 
     */
    @Override
    public void validate(Set<NumberRes> nums) {
        //and call super.validate for generic ones
        super.validate(nums);
    }
    
}
