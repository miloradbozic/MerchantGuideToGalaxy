package com.mlrd.mgtg.question;

import java.text.MessageFormat;
import java.util.Map;
import com.mlrd.mgtg.model.IntergalacticNumberFactory;
import com.mlrd.mgtg.model.RomanNumber;
import com.mlrd.util.PatternExtractor;

public class MetalPriceQuestionResolver implements QuestionResolver{
	private static final PatternExtractor extractor = PatternExtractor.compile(
			new PatternExtractor.Entry("question", "how many Credits is"),
			new PatternExtractor.Entry("intergalacticNumber", "[pish, glob,prok,tegj ]+"),
			new PatternExtractor.Entry("metal", "[Silver,Gold,Iron]+"),
			new PatternExtractor.Entry("?", "[?]")
	);
	
	private Map<String, RomanNumber.Symbol> mapping;
	private IntergalacticNumberFactory intergalacticNumberFactory;
	private Map<String, Integer> metalPrices;
	
	public MetalPriceQuestionResolver(Map<String, RomanNumber.Symbol> mapping, Map<String, Integer> metalPrices) {
		this.mapping = mapping;
		this.intergalacticNumberFactory = new IntergalacticNumberFactory(this.mapping);
		this.metalPrices = metalPrices;
	}
	
	@Override
	public boolean canAnswer(String question) {
		return extractor.condition(question);
	}
	
	@Override
	public String getAnswer(String question)
	{
    	if (! canAnswer(question)) {
    		return null;
    	}
    	
    	PatternExtractor.Result result = extractor.extract(question);
		String intergalacticNumeral = result.get("intergalacticNumber");
		String material = result.get("metal");
		Integer intergalacticNumber = this.intergalacticNumberFactory.getIntergalacticNumber(intergalacticNumeral).toDecimalNumber();
		Integer metalUnitPrice = this.metalPrices.get(material);
		Integer totalPrice = intergalacticNumber.intValue() * metalUnitPrice.intValue();
		return MessageFormat.format(this.getTemplate(), intergalacticNumeral, material, totalPrice);
	}
	
	@Override
	public String getTemplate() {
		return "{0} {1} is {2}";
	}
}
