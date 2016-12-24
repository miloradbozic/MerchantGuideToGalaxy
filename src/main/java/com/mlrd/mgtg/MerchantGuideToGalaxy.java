package com.mlrd.mgtg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MerchantGuideToGalaxy
{
    public List<String> process(final List<String> input) throws IOException
    {
       final Map<String, RomanNumber.Symbol> mapping = IntergalcticToRomanMappingExtractor.extract(input);
       final Map<String, Integer> metalPrices = MetalPriceExtractor.extract(input, mapping); 
       //final List<String> answers = answerQuestions(input);
       final List<String> answers = IntergalacticNumberQuestion.extract(input, mapping);
       final List<String> answers2 = MetalPriceQuestion.extract(input, mapping, metalPrices);
       
       System.out.println(mapping);
       System.out.println(metalPrices);
       System.out.println(answers);
       System.out.println(answers2);
       
       return answers;
    }
    
    private List<String> answerQuestions(final List<String> input)
    {
    	List<String> answers = new ArrayList<String>();
    	
    	
    	return answers;
    }
    
    private String answerValueQuestion(String line)
    {
    	IntergalacticNumber intergalacticNumeral = extractIntergalacticNumber(line);
    	return "(1)answer to the " + line;
    }
    
    private IntergalacticNumber extractIntergalacticNumber(String line) {
		// TODO Auto-generated method stub
		return null;
	}

	private String answerMaterialQuestion(String line)
    {
    	return "(2)answer to the " + line;
    }
    
    private String answerUnknownQuestion(String line)
    {
    	return "I don't have answer for this question: " + line;
    }
}
