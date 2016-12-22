package com.mlrd.mgtg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MerchantGuideToGalaxy
{
    public List<String> process(final List<String> input) throws IOException
    {
       final IntergalacticToRomanMapping mapping = IntergalcticToRomanMappingExtractor.extract(input);
       final Map<String, Integer> metalPrices = MetalPriceExtractor.extract(input, mapping);
       
       System.out.println(mapping);
       System.out.println(metalPrices);
       
       final List<String> answers = answerQuestions(input);
       return answers;
    }
    
    private List<String> answerQuestions(final List<String> input)
    {
    	List<String> answers = new ArrayList<String>();
    	
    	for(String line : input) {
    		if (!line.endsWith("?")) {
    			continue;
    		}
    		
    		String answer = null;
			if (line.startsWith("how much is")) {
				answer = answerValueQuestion(line);
			} else if (line.startsWith("how many Credits is")) {
				answer = answerMaterialQuestion(line);
			} else {
				answer = answerUnknownQuestion(line);
			}
			
    		answers.add(answer);
    	}
    	
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
