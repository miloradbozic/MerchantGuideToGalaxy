package com.mlrd;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.mlrd.mgtg.MerchantGuideToGalaxy;
import com.mlrd.mgtg.extractor.IntergalcticToRomanMappingExtractor;
import com.mlrd.mgtg.extractor.MetalPriceExtractor;
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
    	final String[] metals = {"Silver", "Gold", "Iron"};
    	
        MerchantGuideToGalaxy merchantGuideToGalaxy = new MerchantGuideToGalaxy(
        		new IntergalcticToRomanMappingExtractor(),
        		new MetalPriceExtractor(metals)
        );
        List<String> output = merchantGuideToGalaxy.process(input);
        Action.lists(System.out::println, input, output);
    }
}
