package com.mlrd.mgtg;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mlrd.mgtg.model.RomanNumber;

public class RomanNumeralTest {

   @Test
   public void test_random_numbers() {
	RomanNumber romanNumeral = new RomanNumber("XXI");
	assertEquals(romanNumeral.toDecimalNumber().intValue(), 21);
	
	romanNumeral = new RomanNumber("IX");
	assertEquals(romanNumeral.toDecimalNumber().intValue(), 9);
	
	romanNumeral = new RomanNumber("CMMM");
	assertEquals(romanNumeral.toDecimalNumber().intValue(), 2900);
	
	romanNumeral = new RomanNumber("IV");
	assertEquals(romanNumeral.toDecimalNumber().intValue(), 4);
   }
   
   @Test
   public void test_random_numbers_valid() {
	RomanNumber romanNumeral = new RomanNumber("CMMM");
	assertTrue(romanNumeral.isValid());
   }
   
   @Test
   public void test_numeral_invalid_if_contains_invalid_charactrer() {
	RomanNumber romanNumeral = new RomanNumber("CMMMB");
	assertFalse(romanNumeral.isValid());
   }
	   
}
