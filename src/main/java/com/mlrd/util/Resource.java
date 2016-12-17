package com.mlrd.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Resource {
	
	public static List<String> readAsList(String resource) throws URISyntaxException, IOException
	{
		URL inputURL = ClassLoader.getSystemResource(resource);
		
		if(inputURL == null) {
			throw new IOException("Resource " + resource + " does not exist.");
		}
		
		URI inputURI = inputURL.toURI();
		FileSystem zipfs = initFileSystem(inputURI);
        final List<String> input = Files.readAllLines(Paths.get(inputURI));
        
        if (zipfs != null) {
        	zipfs.close();
        }
        
        return input;
	}
	
	private static FileSystem initFileSystem(URI uri) throws IOException
	{
	    try
	    {
	        return FileSystems.getFileSystem(uri);
	    } catch( FileSystemNotFoundException e ) {
	        Map<String, String> env = new HashMap<>();
	        env.put("create", "true");
	        return FileSystems.newFileSystem(uri, env);
	    } catch (java.lang.IllegalArgumentException e2) {
	    	//@todo Eclipse builder reads from generated-sources directory and returns "Path component should be '/'"
	    	return null;
	    }
	}
}
