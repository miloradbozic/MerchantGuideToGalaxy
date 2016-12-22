package com.mlrd.mgtg;

public class IntergalacticNumberFactory {
	
	private IntergalacticToRomanMapping mapping;
	
	public IntergalacticNumberFactory(IntergalacticToRomanMapping mapping)
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
