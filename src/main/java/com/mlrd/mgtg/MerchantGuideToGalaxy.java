package com.mlrd.mgtg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MerchantGuideToGalaxy
{
    public List<String> process(final List<String> input) throws IOException
    {
       final IntergalacticToRomanMapping mapping = extractIntergalacticToRomanMapping(input);
       
       //final List<String> answers = answerQuestions(input);
       //return answers;
       return new ArrayList<String>();
    }
    
    private IntergalacticToRomanMapping extractIntergalacticToRomanMapping(final List<String> input)
    {
    	IntergalacticToRomanMapping mapping = new IntergalacticToRomanMapping();
    	
    	input.stream()
    	.filter( s -> Extractor.condition(s))
    	.forEach( s-> mapping.add(Extractor.extract(s)));
    	
    	System.out.println(mapping);
    	return null;
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
