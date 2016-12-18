package com.mlrd.mgtg;

import java.util.HashMap;
import java.util.Map;

public class IntergalacticToRomanSymbolMap {

	private Map<String, Character> map = new HashMap<String, Character>();
	
	public void add(String intergalacticSymbol, Character romanSymbol)
	{
		if (RomanNumeral.isValidSymbol(romanSymbol) == false) {
			throw new IllegalArgumentException("Invalid Roman symbol '" + romanSymbol + "'.");
		}
		
		map.put(intergalacticSymbol, romanSymbol);
	}
	
	public Character getRomanSymbol(String intergalacticSymbol)
	{
		return map.get(intergalacticSymbol);
	}
}
