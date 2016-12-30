package com.mlrd.mgtg.question.resolver;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mlrd.mgtg.model.IntergalacticNumberFactory;
import com.mlrd.mgtg.model.RomanNumber;
import com.mlrd.mgtg.model.RomanNumber.Symbol;
import com.mlrd.util.PatternExtractor;

public class IntergalacticNumberQuestionResolver implements QuestionResolver {

	private final PatternExtractor extractor;
	private Map<String, RomanNumber.Symbol> mapping;
	private IntergalacticNumberFactory intergalacticNumberFactory;
	
	public IntergalacticNumberQuestionResolver(Map<String, RomanNumber.Symbol> mapping) {
		this.mapping = mapping;
		this.intergalacticNumberFactory = new IntergalacticNumberFactory(this.mapping);
		this.extractor = PatternExtractor.compile(
				new PatternExtractor.Entry("question", "how much is"),
				new PatternExtractor.Entry("intergalacticNumber", this.mapping.keySet()),
				new PatternExtractor.Entry("?", "[?]")
		);
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
    	Integer intergalacticNumber = this.intergalacticNumberFactory.getIntergalacticNumber(intergalacticNumeral).toDecimalNumber();
    	return MessageFormat.format(this.getTemplate(), intergalacticNumeral, intergalacticNumber.intValue());
	}
	
	@Override
	public String getTemplate() {
		return "{0} is {1}";
	}

}
