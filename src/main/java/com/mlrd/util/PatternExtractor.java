package com.mlrd.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExtractor {

	private Pattern pattern;
	private Entry[] entries;	//todo not sure this is good structure, it is more a Set than array
	
	public static class Entry {
		public String key;
		public String pattern;
		private String value;
		
		public Entry(String key, String pattern)
		{
			this.key = key;
			this.pattern = pattern;
		}
		
		public Entry(String key)
		{
			this.key = key;
			this.pattern = key;
		}
		
		public Entry(String key, String[] values) {
			this.key = key;
			this.pattern = "[" + String.join(", ", values) + "]+"; //"[Silver,Gold,Iron]+"
		}

		public String getValue()
		{
			return this.value;
		}
		
		public String toString()
		{
			return "{key : " + key +", pattern : " + pattern + ", value : " + value +"}";
		}
	}
	
	public static class Result {
		
		private Entry[] entries;
		
		private Result(Entry[] entries) {
			this.entries = entries;
		}
		
		public Entry[] getEntries() {
			return this.entries;
		}
		
		/**
		 * Returns value of the entry with given key
		 */
		//todo refactor functional
		public String get(String key) {
			for(Entry entry : entries) {
				if (entry.key == key) {
					return entry.value;
				}
			}
			return null;
		}
		
	}
	
	public static PatternExtractor compile(PatternExtractor.Entry... entries)
	{
		PatternExtractor extractor = new PatternExtractor();
   	 	extractor.setEntries(entries);
   	 	extractor.setPattern(entries);
   	 	return extractor;
	}
	
	private void setEntries(Entry... entries)
	{
		this.entries = entries;
	}
	
	private void setPattern(Entry... entries)
	{
		//@todo improve this block, to write in more functional way
		String patternString = "";
		for (Entry entry : entries) {
			patternString += "(" + entry.pattern + ") ";
		}
		patternString = patternString.substring(0, patternString.length()-1);
		
		this.pattern = Pattern.compile(patternString);
	}
	
	public boolean condition(String s)
	{
		return this.pattern.matcher(s).matches();
	}

	public Result extract(String s)
	{
		Entry[] entriesOutput = new Entry[this.entries.length];

   	    Matcher matcher = this.pattern.matcher(s);
   	    while (matcher.find()) {
   	    	for (int i=0; i < this.entries.length; ++i) {
   	    		entriesOutput[i] = new Entry(this.entries[i].key, this.entries[i].pattern);
   	    		entriesOutput[i].value = matcher.group(i+1);
   	    	}
   	    }
   	    
   	    return new Result(entriesOutput);
	}
	
}
