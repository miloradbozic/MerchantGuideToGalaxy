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
	
	public static IntergalacticToRomanMapping extract(final List<String> input)
	{		
		IntergalacticToRomanMapping mapping = new IntergalacticToRomanMapping();
	    List<PatternExtractor.Entry[]> result = new ArrayList<PatternExtractor.Entry[]>();
	    
    	input.stream()
    	.filter( s -> extractor.condition(s))
    	.forEach( s-> result.add(extractor.extract(s)));
	    	
    	for (PatternExtractor.Entry[] entries : result) {
    		mapping.add(entries[0].getValue(), entries[2].getValue().toCharArray()[0]); //@todo fix fetching based on key
    	}
	    	
	    return mapping;
	}
	
}
