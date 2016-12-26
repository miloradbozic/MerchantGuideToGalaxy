package com.mlrd.mgtg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mlrd.mgtg.extractor.IntergalcticToRomanMappingExtractor;
import com.mlrd.mgtg.extractor.MetalPriceExtractor;
import com.mlrd.mgtg.model.RomanNumber;
import com.mlrd.mgtg.question.IntergalacticNumberQuestionResolver;
import com.mlrd.mgtg.question.MetalPriceQuestionResolver;
import com.mlrd.mgtg.question.QuestionAnswerEngine;
import com.mlrd.mgtg.question.UnknownQuestionResolver;

public class MerchantGuideToGalaxy
{
    public List<String> process(final List<String> input) throws IOException
    {
       final Map<String, RomanNumber.Symbol> mapping = IntergalcticToRomanMappingExtractor.extract(input);
       final Map<String, Integer> metalPrices = MetalPriceExtractor.extract(input, mapping);
       
       final QuestionAnswerEngine questionAnswerEngine= new QuestionAnswerEngine(
    		   new IntergalacticNumberQuestionResolver(mapping),
    		   new MetalPriceQuestionResolver(mapping, metalPrices),
    		   new UnknownQuestionResolver()
       );
       
       return  questionAnswerEngine.getAnswers(input);
       
    }
}
