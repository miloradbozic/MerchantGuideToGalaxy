package com.mlrd;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.mlrd.mgtg.MerchantGuideToGalaxy;
import com.mlrd.util.Action;
import com.mlrd.util.Resource;

/**
 * App entry point
 *
 */
public class App 
{
    public static void main( String[] args ) throws URISyntaxException, IOException
    {
    	final List<String> input = Resource.readAsList("input.txt");
        MerchantGuideToGalaxy merchantGuideToGalaxy = new MerchantGuideToGalaxy();
        List<String> output = merchantGuideToGalaxy.process(Resource.readAsList("input.txt"));
        Action.lists(System.out::println, input, output);
    }
    

}
