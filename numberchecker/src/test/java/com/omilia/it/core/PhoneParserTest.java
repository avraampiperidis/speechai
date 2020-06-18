/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omilia.it.core;

import com.omilia.it.validation.core.Utils;
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
public class PhoneParserTest {
    
    @Test
    @Parameters(source = Provider.class, method = "phoneProvider")
    public void testPhoneNumber(int results,String phone) {
        Assert.assertEquals(results,PhoneParser.phoneNumber(Utils.convertToBlocks(phone)).size());
    }
    
}
