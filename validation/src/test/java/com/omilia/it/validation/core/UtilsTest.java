/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omilia.it.validation.core;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Abraham Piperidis
 */
@RunWith(JUnitParamsRunner.class)
public class UtilsTest {
    
    @Test
    @Parameters(source = UtilsProvider.class, method = "numbersProvider")
    public void testConvertToBlocks(int expected, String value) {
        Assert.assertEquals(expected,Utils.convertToBlocks(value).size());
    }
    
    
    @Test
    @Parameters(source = UtilsProvider.class, method = "numbersProvider2")
    public void testRemoveSpaces(String expected, String value) {
        Assert.assertEquals(expected,Utils.removeSpaces(value));
    }
    
}
