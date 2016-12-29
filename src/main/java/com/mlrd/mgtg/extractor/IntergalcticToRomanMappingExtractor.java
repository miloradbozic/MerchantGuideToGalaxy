package com.mlrd.mgtg.extractor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import com.mlrd.mgtg.model.RomanNumber;
import com.mlrd.mgtg.model.RomanNumber.Symbol;
import com.mlrd.util.PatternExtractor;
import com.mlrd.util.PatternExtractor.Result;

public class IntergalcticToRomanMappingExtractor extends BaseInputExtractor<Map<String, RomanNumber.Symbol>> {

	@Override
	protected PatternExtractor getPattern() {
		return PatternExtractor.compile(
				new PatternExtractor.Entry("intergalacticSymbol", "[a-z]+"),
				new PatternExtractor.Entry("is"),
				new PatternExtractor.Entry("romanSymbol", "[I,V,X,C,L,M]")
		);
	}
	
	@Override
	protected Map<String, Symbol> initResult() {
		return new HashMap<String, RomanNumber.Symbol>();
	}

	@Override
	protected Consumer<? super Result> fillFinalResult(Map<String, Symbol> finalResult) {
		return e -> finalResult.put(
				e.get("intergalacticSymbol"),
				RomanNumber.Symbol.valueOf(e.get("romanSymbol"))
    	);
	}
}
