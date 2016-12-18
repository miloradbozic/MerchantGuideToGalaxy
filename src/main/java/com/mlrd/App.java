package com.mlrd;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.mlrd.mgtg.MerchantGuideToGalaxy;
import com.mlrd.util.Resource;

/**
 * App entry point
 *
 */
public class App 
{
    public static void main( String[] args ) throws URISyntaxException, IOException
    {
        for (String line : Resource.readAsList("input.txt")) {
            System.out.println(line);
        }
        MerchantGuideToGalaxy mgtg = new MerchantGuideToGalaxy();
        List<String> output = mgtg.process(Resource.readAsList("input.txt"));
        for(String line : output)
        {
        	System.out.println(line);
        }
    }
}
