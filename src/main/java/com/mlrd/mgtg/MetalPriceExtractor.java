package com.mlrd.mgtg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mlrd.util.PatternExtractor;

public class MetalPriceExtractor {
	//glob glob Silver is 34 Credits
	private static final PatternExtractor extractor = PatternExtractor.compile(
			new PatternExtractor.Entry("intergalacticNumber", "[glob,prok,pish ]+"),
			new PatternExtractor.Entry("metal", "[Silver,Gold,Iron]+"),
			new PatternExtractor.Entry("is", "is"),
			new PatternExtractor.Entry("value", "[0-9]*[1-9][0-9]*"), //TODO improve class to have types etc..
			new PatternExtractor.Entry("Credits", "[Credit,Credits]+")
	);
	
	private static Map<String, Integer> metalPrices = new HashMap<String, Integer>();
	
	//@todo violates SRP
	//@todo results should be in Double, not Integer!
	public static Map<String, Integer> extract(final List<String> input, Map<String, RomanNumber.Symbol> mapping)
	{		
	    List<PatternExtractor.Result> results = new ArrayList<PatternExtractor.Result>();
	    
    	input.stream()
    	.filter( s -> extractor.condition(s))
    	.forEach( s-> results.add(extractor.extract(s)));
	    	
    	IntergalacticNumberFactory intergalacticNumberFactory = new IntergalacticNumberFactory(mapping);
    	
    	for (PatternExtractor.Result result : results) {
    		String metal = result.get("metal");
    		Integer intergalacticNumber = intergalacticNumberFactory.getIntergalacticNumber(result.get("intergalacticNumber")).toDecimalNumber();
    		Integer value = Integer.parseInt(result.get("value")); //@todo can we handle this nicer?
    		Integer basePrice = value / intergalacticNumber;
    		
    		IntergalacticNumber in = intergalacticNumberFactory.getIntergalacticNumber(result.get("intergalacticNumber"));
    		
    		if (metal.equals("Gold")) {
    			System.out.println(intergalacticNumber + " " + value + " " + basePrice + " " + in.toRomanNumber().toString());
    		}
    		
    		metalPrices.put(metal, basePrice);
    	}
	    	
	    return metalPrices;
	}
}
