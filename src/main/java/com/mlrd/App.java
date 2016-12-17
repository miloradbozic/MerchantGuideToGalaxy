package com.mlrd;

import java.io.IOException;
import java.net.URISyntaxException;

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
        MerchantGuideToGalaxy mgtg = new MerchantGuideToGalaxy();
        mgtg.process(Resource.readAsList("input.txt"));
    }
}
