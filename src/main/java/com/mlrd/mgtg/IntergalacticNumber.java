package com.mlrd.mgtg;

import java.util.ArrayList;
import java.util.List; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntergalacticNumber {
	
	private IntergalacticToRomanMapping mapping;
	private String[] numeral;

	public IntergalacticNumber(String[] numeral, IntergalacticToRomanMapping mapping)
	{
		this.mapping = mapping;
		this.numeral = numeral;
	}
	
	public IntergalacticNumber(String numeral, IntergalacticToRomanMapping mapping)
	{
		this.mapping = mapping;
		this.numeral = numeral.split("\\s+");
	}
	
	public IntergalacticNumber(String[] numeral)
	{
		this.numeral = numeral;
	}
	
	public IntergalacticNumber(String numeral)
	{
		this.numeral = numeral.split("\\s+");
	}
	
	public void setMapping(IntergalacticToRomanMapping mapping)
	{
		this.mapping = mapping;
	}
	
	/**
	 * Extracts all intergalactic numerals from string
	 * @param string
	 * @return
	 */
	public IntergalacticNumber extract(String string)
	{
		Pattern pattern = Pattern.compile("(\\[)(.*?)(\\])");
        Matcher matcher = pattern.matcher(string);

        List<String> listMatches = new ArrayList<String>();

        while(matcher.find())
        {
            listMatches.add(matcher.group(2));
        }

        for(String s : listMatches)
        {
            System.out.println(s);
        }
        
        return null; //TODO
	}
	
	/**
	 * Convert Intergalactic numeral to Roman numeral based on conversion map
	 * @return RomanNumeral
	 */
	public RomanNumber toRomanNumeral()
	{
		if (this.mapping == null) {
			throw new IllegalStateException("Intergalactic to Roman mapping missing.");
		}
		
		String romanNumeral = "";
		for(int i = 0; i < numeral.length; ++i)
		{
			romanNumeral += mapping.getRomanSymbol(numeral[i]);
		}
		
		return new RomanNumber(romanNumeral);
	}
	
}
