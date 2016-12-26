package com.mlrd.mgtg.question;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import com.mlrd.mgtg.question.resolver.QuestionResolver;

public class QuestionAnswerEngine {
	
	private QuestionResolver[] questionResolvers;
	
	public QuestionAnswerEngine(QuestionResolver... questionResolvers) {
		this.questionResolvers = questionResolvers;
	}
	
	public List<String> getAnswers(List<String> input) {
    	return input.stream().filter(this::isQuestion).map(this::findAnswer).collect(Collectors.toList());
	}
	
	private String findAnswer(String question) throws NoSuchElementException  {
		Optional<String> answer = Arrays.stream(questionResolvers)
										.filter(reslover -> reslover.canAnswer(question))
										.map( resolver -> resolver.getAnswer(question))
										.findFirst();
		 
		 if (! answer.isPresent()) {
			 throw new NoSuchElementException("No resolver found for question '" + question +"'");
		 }
		 
		 return answer.get();
	}
	
	private boolean isQuestion(String s) {
		return s.endsWith("?");
	}

}
