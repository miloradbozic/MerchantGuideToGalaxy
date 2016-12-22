package com.mlrd.mgtg;

import java.util.ArrayList;
import java.util.List;

import com.mlrd.util.PatternExtractor;

public class MetalPriceExtractor {
	//glob glob Silver is 34 Credits
	private static final PatternExtractor extractor = PatternExtractor.compile(
			new PatternExtractor.Entry("intergalacticNumber", "[glob,prok ]+"),
			new PatternExtractor.Entry("metal", "[Silver,Gold,Iron]+"),
			new PatternExtractor.Entry("is", "is"),
			new PatternExtractor.Entry("value", "[0-9]*[1-9][0-9]*"),
			new PatternExtractor.Entry("Credits", "[Credit,Credits]+")
	);
	
	public static IntergalacticToRomanMapping extract(final List<String> input, IntergalacticToRomanMapping mapping)
	{		
	    List<PatternExtractor.Entry[]> result = new ArrayList<PatternExtractor.Entry[]>();
	    
    	input.stream()
    	.filter( s -> extractor.condition(s))
    	.forEach( s-> result.add(extractor.extract(s)));
	    	
    	for (PatternExtractor.Entry[] entries : result) {
    		//mapping.add(entries[0].getValue(), entries[2].getValue().toCharArray()[0]); //@todo fix fetching based on key
    		for (PatternExtractor.Entry entry : entries) {
    			System.out.println(entry);
    		}
    	}
	    	
	    return mapping;
	}
}
