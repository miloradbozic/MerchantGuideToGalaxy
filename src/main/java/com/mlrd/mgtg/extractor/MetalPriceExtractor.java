package com.mlrd.mgtg.extractor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.mlrd.mgtg.model.IntergalacticNumber;
import com.mlrd.mgtg.model.IntergalacticNumberFactory;
import com.mlrd.mgtg.model.RomanNumber;
import com.mlrd.util.PatternExtractor;
import com.mlrd.util.PatternExtractor.Result;

public class MetalPriceExtractor extends BaseInputExtractor<Map<String, Integer>> {

	private Map<String, RomanNumber.Symbol> mapping;
	private String[] metals;
	
	public MetalPriceExtractor(String[] metals) {
		this.metals = metals;
	}
	
	public MetalPriceExtractor(String[] metals, Map<String, RomanNumber.Symbol> mapping) {
		this.metals = metals;
		this.mapping = mapping;
	}
	
	public void setMapping(Map<String, RomanNumber.Symbol> mapping) {
		this.mapping = mapping;
	}
	
	@Override
	protected PatternExtractor getPattern() {
		
		if (mapping == null) {
			throw new IllegalStateException("Mapping has to be set prior to call to this method.");
		}

		//example: 'glob glob Silver is 34 Credits'
		return PatternExtractor.compile(
				new PatternExtractor.Entry("intergalacticNumber", mapping.keySet().stream().toArray(String[]::new)),
				new PatternExtractor.Entry("metal", metals),
				new PatternExtractor.Entry("is", "is"),
				new PatternExtractor.Entry("value", "[0-9]*[1-9][0-9]*"), //TODO improve class to have types etc..
				new PatternExtractor.Entry("Credits", "[Credit,Credits]+")
		);
	}
	
	@Override
	protected Map<String, Integer> initResult() {
		return new HashMap<String, Integer>();
	}

	@Override
	protected Consumer<? super Result> fillFinalResult(Map<String, Integer> finalResult) {
		return e -> {
			IntergalacticNumberFactory intergalacticNumberFactory = new IntergalacticNumberFactory(mapping);
			
			String metal = e.get("metal");
			Integer intergalacticNumber = intergalacticNumberFactory.getIntergalacticNumber(e.get("intergalacticNumber")).toDecimalNumber();
			Integer value = Integer.parseInt(e.get("value"));
			Integer basePrice = value / intergalacticNumber;
			
			IntergalacticNumber in = intergalacticNumberFactory.getIntergalacticNumber(e.get("intergalacticNumber"));
			
			if (metal.equals("Gold")) {
				System.out.println(intergalacticNumber + " " + value + " " + basePrice + " " + in.toRomanNumber().toString());
			}
			
			finalResult.put(metal, basePrice);
		};
	}
}
