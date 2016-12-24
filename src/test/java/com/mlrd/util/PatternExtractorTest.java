package com.mlrd.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class PatternExtractorTest {

	@Test
	public void test_pattern() {
		PatternExtractor extractor = PatternExtractor.compile(
			new PatternExtractor.Entry("intergalacticSymbol", "[a-z]+"),
			new PatternExtractor.Entry("is", "is"),
			new PatternExtractor.Entry("romanSymbol", "[I,V,X,C,L,M]"));
		
		assertTrue(extractor.condition("glob is I"));
		assertTrue(extractor.condition("glob is V"));
		assertFalse(extractor.condition("prok is Z"));
	}
	
	@Test
	public void test_pattern2() {
		PatternExtractor extractor = PatternExtractor.compile(
				new PatternExtractor.Entry("intergalacticNumber", "[glob,prok ]+"),
				new PatternExtractor.Entry("is", "is"));
			
		assertTrue(extractor.condition("glob glob is"));
		assertTrue(extractor.condition("glob prok is"));
		assertFalse(extractor.condition("123 is"));
	}
	
	@Test
	public void test_pattern3() {
		PatternExtractor extractor = PatternExtractor.compile(
				new PatternExtractor.Entry("intergalacticNumber", "[glob,prok ]+"),
				new PatternExtractor.Entry("metal", "[Silver,Gold,Iron]+"),
				new PatternExtractor.Entry("is", "is"),
				new PatternExtractor.Entry("value", "[0-9]*[1-9][0-9]*"),
				new PatternExtractor.Entry("Credits", "[Credit,Credits]+"));
			
		assertTrue(extractor.condition("glob glob Silver is 346 Credits"));
		assertFalse(extractor.condition("glob prok is"));
		assertFalse(extractor.condition("123 is"));
	}
	
	@Test
	public void test_pattern4() {
		PatternExtractor extractor = PatternExtractor.compile(
				new PatternExtractor.Entry("question", "how much is"),
				new PatternExtractor.Entry("intergalacticNumber", "[pish, glob,prok,tegj ]+"),
				new PatternExtractor.Entry("?", "[?]")
		);
			
		assertTrue(extractor.condition("how much is pish tegj glob glob ?"));
	}
	
	
}
