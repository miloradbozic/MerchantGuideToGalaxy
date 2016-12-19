package com.mlrd.mgtg;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {

	private static final Pattern validPattern = Pattern.compile("([a-z]+) (is) ([I,V,X,C,L,M])");
	
	public static boolean condition(String s)
	{
		return validPattern.matcher(s).matches();
	}

	public static Map.Entry<String, Character> extract(String s) {
		
   	 	List<String> chunks = new LinkedList<String>();
   	    Matcher matcher = validPattern.matcher(s);
   	    while (matcher.find()) {
   	        chunks.add( matcher.group(1) );
   	        chunks.add( matcher.group(3) );
   	     Map.Entry<String, Character> result =  new AbstractMap.SimpleEntry<String, Character>( matcher.group(1), matcher.group(3).toCharArray()[0]);
		
   	     return result;
   	    }
   	    
   	    return null;

   	    
	}
	
}
