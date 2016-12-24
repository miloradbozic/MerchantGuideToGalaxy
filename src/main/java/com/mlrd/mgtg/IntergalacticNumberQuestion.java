package com.mlrd.mgtg;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mlrd.util.PatternExtractor;

public class IntergalacticNumberQuestion {
	//glob glob Silver is 34 Credits
	private static final PatternExtractor extractor = PatternExtractor.compile(
			new PatternExtractor.Entry("question", "how much is"),
			new PatternExtractor.Entry("intergalacticNumber", "[pish, glob,prok,tegj ]+"),
			new PatternExtractor.Entry("?", "[?]")
	);
	
	private static final List<String> answers = new ArrayList<String>();
	public static List<String> extract(final List<String> input, Map<String, RomanNumber.Symbol> mapping)
	{		
	    List<PatternExtractor.Result> results = new ArrayList<PatternExtractor.Result>();
	    
    	input.stream()
    	.filter( s -> extractor.condition(s))
    	.forEach( s-> results.add(extractor.extract(s)));
	    	
    	IntergalacticNumberFactory intergalacticNumberFactory = new IntergalacticNumberFactory(mapping);
    	
    	for (PatternExtractor.Result result : results) {
    		String intergalacticNumeral = result.get("intergalacticNumber");
    		Integer intergalacticNumber = intergalacticNumberFactory.getIntergalacticNumber(intergalacticNumeral).toDecimalNumber();
    		
    		answers.add(intergalacticNumeral + " is " + intergalacticNumber.intValue());
	    }
		    	
		return answers;
	}
}
