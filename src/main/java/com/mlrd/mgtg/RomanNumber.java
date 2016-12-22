package com.mlrd.mgtg;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RomanNumber {

	private String numeral;
	
	private final static Map<Character, Integer> valueMap = new TreeMap<Character, Integer>(); //@todo HashMap ?
	
	static {
		valueMap.put('I', 1);
		valueMap.put('V', 5);
		valueMap.put('X', 10);
		valueMap.put('L', 50);
		valueMap.put('C', 100);
		valueMap.put('D', 500);
		valueMap.put('M', 1000);		
	}
	
	public static Set<Character> getValidSymbols()
	{
		return valueMap.keySet();
	}
	
	public static boolean isValidSymbol(Character symbol)
	{
		return valueMap.containsKey(symbol);
	}
	
	public RomanNumber(String numeral)
	{
		//@todo need validation it contains valid characters only
		this.numeral = numeral;
	}
	
	public Integer toDecimalNumber()
	{
		int result = 0;
		
		for(int i = 0; i < this.numeral.length(); ++i) {
			int current = valueMap.get(this.numeral.charAt(i));
			//take the next char and check if bigger
			int next = (i < this.numeral.length()-1) ? valueMap.get(this.numeral.charAt(i+1)) : 0;
			if (next > current) {
				current = next - current;
				i+=1;
			}

			result += current;
		}
		
		return result;
	}
	
	public boolean isValid()
	{
		Set<Character> validCharactersSet = valueMap.keySet();
		String validCharacters = validCharactersSet.toString();
		if (this.numeral.matches("^" + validCharacters + "+$")) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString()
	{
		return numeral;
	}
	
	
}
