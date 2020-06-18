/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omilia.it.runner;

import com.omilia.it.core.GeneratorBuilder;
import com.omilia.it.core.NumberRes;
import com.omilia.it.core.PhoneGeneratorBuilder;
import com.omilia.it.core.PhoneParser;
import com.omilia.it.validation.core.SimpleConstraintViolationException;
import com.omilia.it.validation.core.Utils;
import com.omilia.it.validation.core.ValidationContext;
import com.omilia.it.validation.validators.PhoneNumberValidator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * This is a simple main class just for demonstration
 */
public class MainDemo {
    
    
    public static void main(String[] a) {
        System.out.println();
        System.out.println("||-----Welcome-----||");
        System.out.println("|>--Enter a phone number to run the program. OR type exit");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            System.out.println();
            String phone = sc.nextLine();
            if ("exit".equalsIgnoreCase(phone)) {
                break;
            }
            //validate input
            SimpleConstraintViolationException ex = new ValidationContext(new PhoneNumberValidator.ValidatePhoneOnlyDigits("* !Phone number does MUST contain only digits and spaces!\n", phone), ValidationContext.DispatchOnFail.YES)
                    .and(new PhoneNumberValidator.ValidateInputSequenceLength("* !Phone blocks should be up to 3 chars!\n", phone))
                    .and(new PhoneNumberValidator.ValidateGreekPhoneNumber("* !Not a valid Greek phone number!\n", phone))
                    .checkValidation();
            if (!ex.getErrors().isEmpty()) {
                System.out.println("!Wrong input...");
                ex.getErrors().stream().forEach(System.out::println);
                System.out.println("|>--Enter another phone number");
                continue;
            }
            List<String> blocks = Utils.convertToBlocks(phone);
            phone = Utils.toString(blocks);
            System.out.println("|>--Phone number entered:" + phone);
            System.out.println("|>--1 number Interpretation:" + phone);
            System.out.println("|>--Possible identical numbers found....");
            Set<String> identicals = PhoneParser.phoneNumber(blocks);
            identicals.forEach((n) -> {
                SimpleConstraintViolationException scv = new ValidationContext(new PhoneNumberValidator.ValidateGreekPhoneNumber("Wrong phone format", n),
                        ValidationContext.DispatchOnFail.YES)
                        .checkValidation();
                System.out.println("phone:" + n + "(" + n.length() + ")" + "," + (scv.getErrors().isEmpty() ? "VALID" : "INVALID"));
            });
            System.out.println("|>--Enter another phone number");
        }
        System.out.println("|>--Exiting program--|");
    }

}
