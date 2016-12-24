package com.mlrd.mgtg;

import java.util.Map;

public class IntergalacticNumberFactory {
	
	private Map<String, RomanNumber.Symbol> mapping;
	
	public IntergalacticNumberFactory(Map<String, RomanNumber.Symbol> mapping)
	{
		this.mapping = mapping;
	}
	
	public void setMapping(Map<String, RomanNumber.Symbol> mapping)
	{
		this.mapping = mapping;
	}
	
	public IntergalacticNumber getIntergalacticNumber(String[] intergalacticNumeral)
	{
		return new IntergalacticNumber(intergalacticNumeral, this.mapping);
	}
	
	public IntergalacticNumber getIntergalacticNumber(String intergalacticNumeral)
	{
		return new IntergalacticNumber(intergalacticNumeral, this.mapping);
	}
}
