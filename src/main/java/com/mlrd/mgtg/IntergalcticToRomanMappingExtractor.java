package com.mlrd.mgtg;

import java.util.ArrayList;
import java.util.List;

import com.mlrd.util.StringExtractor;

public class IntergalcticToRomanMappingExtractor {

	private static final StringExtractor extractor = StringExtractor.compile(
			new StringExtractor.Entry("intergalacticSymbol", "[a-z]+"),
			new StringExtractor.Entry("is", "is"),
			new StringExtractor.Entry("romanSymbol", "[I,V,X,C,L,M]")
	);
	
	public static IntergalacticToRomanMapping extract(final List<String> input)
	{		
		IntergalacticToRomanMapping mapping = new IntergalacticToRomanMapping();
	    List<StringExtractor.Entry[]> result = new ArrayList<StringExtractor.Entry[]>();
	    
    	input.stream()
    	.filter( s -> extractor.condition(s))
    	.forEach( s-> result.add(extractor.extract(s)));
	    	
    	for (StringExtractor.Entry[] entries : result) {
    		mapping.add(entries[0].getValue(), entries[2].getValue().toCharArray()[0]); //@todo fix fetching based on key
    	}
	    	
	    return mapping;
	}
	
}
