package com.mlrd.mgtg.model;

public class RomanNumber {

	private String numeral;
	
	public enum Symbol { 
		I(1), V(5), X(10), L(50), C(100), D(500), M(1000); 
		private int value; 
		
		private Symbol(Integer value) {
			this.value = value; 
		}
		
		public static boolean isValid(Character c) {
			for (Symbol v : Symbol.values()) {
				if (v.name().equals(String.valueOf(c))) {
					return true;
				}
			}

			return false;
		}
		public static boolean isValid(int character) {
			Character c = (char) character;
			return isValid(c); //@TODO find out why tests fail if I put here directly (char) character ?
		}
		
		public static Symbol valueOf(Character c) {
			return valueOf(String.valueOf(c));
		}
		
		public Integer getDecimalValue() {
			return value;
		}
	};
	
	public RomanNumber(String numeral)
	{
		//@todo need validation it contains valid characters only
		this.numeral = numeral;
	}
	
	public Integer toDecimalNumber()
	{
		int result = 0;
		
		for(int i = 0; i < this.numeral.length(); ++i) {
			int current = Symbol.valueOf(this.numeral.charAt(i)).getDecimalValue();//;valueMap.get(this.numeral.charAt(i));
			//take the next char and check if bigger
			int next = (i < this.numeral.length()-1) ? Symbol.valueOf(this.numeral.charAt(i+1)).getDecimalValue() : 0;
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
		return this.numeral.chars().allMatch(Symbol::isValid);
	}
	
	public String toString()
	{
		return numeral;
	}
	
	
}
