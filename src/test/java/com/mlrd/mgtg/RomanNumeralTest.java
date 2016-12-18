package com.mlrd.mgtg;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanNumeralTest {

   @Test
   public void test_random_numbers() {
	RomanNumeral romanNumeral = new RomanNumeral("XXI");
	assertEquals(romanNumeral.toDecimal(), 21);
	
	romanNumeral = new RomanNumeral("IX");
	assertEquals(romanNumeral.toDecimal(), 9);
	
	romanNumeral = new RomanNumeral("CMMM");
	assertEquals(romanNumeral.toDecimal(), 2900);
   }
   
   @Test
   public void test_random_numbers_valid() {
	RomanNumeral romanNumeral = new RomanNumeral("CMMM");
	assertTrue(romanNumeral.isValid());
   }
   
   @Test
   public void test_numeral_invalid_if_contains_invalid_charactrer() {
	RomanNumeral romanNumeral = new RomanNumeral("CMMMB");
	assertFalse(romanNumeral.isValid());
   }
	   
}
