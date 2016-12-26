package com.mlrd.mgtg.question;

public class UnknownQuestionResolver implements QuestionResolver {

	@Override
	public boolean canAnswer(String question) {
		return true;
	}
	
	@Override
	public String getAnswer(String question)
	{
    	return this.getTemplate();
	}
	
	@Override
	public String getTemplate() {
		return "I don't have answer to this question.";
	}

}
