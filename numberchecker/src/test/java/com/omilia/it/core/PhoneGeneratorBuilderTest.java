/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omilia.it.core;

import com.omilia.it.validation.core.SimpleConstraintViolationException;
import java.util.Set;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Abraham Piperidis
 */
@RunWith(JUnitParamsRunner.class)
public class PhoneGeneratorBuilderTest {
    //Could use a Mockito
    private GeneratorBuilder service;
    
    @Before
    public void before() {
        this.service = new PhoneGeneratorBuilder();
    }
    
    @Test(expected = SimpleConstraintViolationException.class)
    @Parameters(source = Provider.class, method = "invalidPhoneProvider")
    public void testGenerateFail(String phone) {
        this.service.with(phone).skipGreekPhoneValidation(false).generate();
    }
    
    
    @Test
    @Parameters(source = Provider.class, method = "phoneProvider")
    public void testGenerate(int results,String phone) {
        Set<NumberRes> res = (Set<NumberRes>) this.service.with(phone).skipGreekPhoneValidation(false).generate();
        Assert.assertTrue(res.stream().anyMatch(x->x.isValid()));
    }

}
