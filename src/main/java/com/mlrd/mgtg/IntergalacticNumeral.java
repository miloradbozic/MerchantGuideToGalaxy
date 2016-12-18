package com.mlrd.mgtg;

public class IntergalacticNumeral {
	
	private IntergalacticToRomanSymbolMap mapping;
	private String[] numeral;

	public IntergalacticNumeral(String[] numeral, IntergalacticToRomanSymbolMap mapping)
	{
		this.mapping = mapping;
		this.numeral = numeral;
	}
	
	public IntergalacticNumeral(String numeral, IntergalacticToRomanSymbolMap mapping)
	{
		this.mapping = mapping;
		this.numeral = numeral.split("\\s+");
	}
	
	/**
	 * Convert Intergalactic numeral to Roman numeral based on conversion map
	 * @return RomanNumeral
	 */
	public RomanNumeral toRomanNumeral()
	{
		String romanNumeral = "";
		for(int i = 0; i < numeral.length; ++i)
		{
			romanNumeral += mapping.getRomanSymbol(numeral[i]);
		}
		
		return new RomanNumeral(romanNumeral);
	}
	
}
