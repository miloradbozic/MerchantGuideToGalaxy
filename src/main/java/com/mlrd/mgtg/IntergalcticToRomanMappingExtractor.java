package com.mlrd.mgtg;

import java.util.ArrayList;
import java.util.List;

import com.mlrd.util.PatternExtractor;

public class IntergalcticToRomanMappingExtractor {

	private static final PatternExtractor extractor = PatternExtractor.compile(
			new PatternExtractor.Entry("intergalacticSymbol", "[a-z]+"),
			new PatternExtractor.Entry("is", "is"),
			new PatternExtractor.Entry("romanSymbol", "[I,V,X,C,L,M]")
	);
	
	private static IntergalacticToRomanMapping mapping = new IntergalacticToRomanMapping();
	
	//@todo breaks SRP
	public static IntergalacticToRomanMapping extract(final List<String> input)
	{		
	    List<PatternExtractor.Result> results = new ArrayList<PatternExtractor.Result>();
	    
	    //process input
    	input.stream()
    	.filter( s -> extractor.condition(s))
    	.forEach( s-> results.add(extractor.extract(s)));
	    	
    	//extract intergalactiMapping
    	for (PatternExtractor.Result result : results) {
    		mapping.add(
				result.get("intergalacticSymbol"),
				result.get("romanSymbol").charAt(0)
    		);
    	}
	    	
	    return mapping;
	}
	
}
