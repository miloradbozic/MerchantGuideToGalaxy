package com.mlrd.mgtg;

import java.util.HashMap;
import java.util.Map;

public class IntergalacticToRomanMapping {

	private Map<String, Character> map = new HashMap<String, Character>();
	
	public void add(String intergalacticSymbol, Character romanSymbol)
	{
		if (RomanNumber.isValidSymbol(romanSymbol) == false) {
			throw new IllegalArgumentException("Invalid Roman symbol '" + romanSymbol + "'.");
		}
		
		map.put(intergalacticSymbol, romanSymbol);
	}
	
	public void add(Map.Entry<String, Character> entry)
	{
		this.add(entry.getKey(), entry.getValue());
	}
	
	public Character getRomanSymbol(String intergalacticSymbol)
	{
		return map.get(intergalacticSymbol);
	}
	
	public String toString()
	{
		return this.map.toString();
	}
}
