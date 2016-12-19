package com.mlrd.mgtg;

public class IntergalacticNumeralFactory {
	
	private IntergalacticToRomanMapping mapping;
	
	public IntergalacticNumeralFactory(IntergalacticToRomanMapping mapping)
	{
		this.mapping = mapping;
	}
	
	public void setMapping(IntergalacticToRomanMapping mapping)
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
