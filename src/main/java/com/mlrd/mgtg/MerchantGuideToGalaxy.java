package com.mlrd.mgtg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.mlrd.mgtg.extractor.IntergalcticToRomanMappingExtractor;
import com.mlrd.mgtg.extractor.MetalPriceExtractor;
import com.mlrd.mgtg.model.RomanNumber;
import com.mlrd.mgtg.question.QuestionAnswerEngine;
import com.mlrd.mgtg.question.resolver.IntergalacticNumberQuestionResolver;
import com.mlrd.mgtg.question.resolver.MetalPriceQuestionResolver;
import com.mlrd.mgtg.question.resolver.UnknownQuestionResolver;

public class MerchantGuideToGalaxy
{
	private IntergalcticToRomanMappingExtractor intergalacticToRomanMappingExtractor;
	private MetalPriceExtractor metalPricesExtractor;

	public MerchantGuideToGalaxy(
			IntergalcticToRomanMappingExtractor intergalacticToRomanMappingExtractor,
			MetalPriceExtractor metalPricesExtractor
	) {
		this.intergalacticToRomanMappingExtractor = intergalacticToRomanMappingExtractor;
		this.metalPricesExtractor = metalPricesExtractor;
	}
	
    public List<String> process(final List<String> input) throws IOException
    {
	   final Map<String, RomanNumber.Symbol> mapping = intergalacticToRomanMappingExtractor.extract(ImmutableList.copyOf(input));
	   
	   metalPricesExtractor.setMapping(mapping);
	   final Map<String, Integer> metalPrices = metalPricesExtractor.extract(ImmutableList.copyOf(input));
	   
	   final QuestionAnswerEngine questionAnswerEngine = new QuestionAnswerEngine(
			   new IntergalacticNumberQuestionResolver(mapping),
			   new MetalPriceQuestionResolver(mapping, metalPrices),
			   new UnknownQuestionResolver()
	   );
       
       return  questionAnswerEngine.getAnswers(input);
    }
}
