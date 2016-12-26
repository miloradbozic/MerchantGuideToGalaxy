package com.mlrd.mgtg.question;

public interface QuestionResolver {
	public boolean canAnswer(String question);
	public String getAnswer(String question);
	public String getTemplate();
	
}
