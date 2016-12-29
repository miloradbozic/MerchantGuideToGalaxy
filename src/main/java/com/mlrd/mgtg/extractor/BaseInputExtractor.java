package com.mlrd.mgtg.extractor;

import java.util.List;
import java.util.stream.Stream;
import java.util.function.Consumer;
import com.mlrd.util.PatternExtractor;
import com.mlrd.util.PatternExtractor.Result;

public abstract class BaseInputExtractor<T> {
	
	protected abstract PatternExtractor getPattern();
	protected abstract T initResult();
	protected abstract Consumer<? super Result> fillFinalResult(T finalResult);
	
	public Stream<Result> applyPattern(final List<String> input) {
		return input.stream()
    	.filter( line -> this.getPattern().condition(line))
    	.map( line -> this.getPattern().extract(line));
	}
	
	public T extract(final List<String> input)
	{
		T finalResult = initResult();
		applyPattern(input).forEach(
				fillFinalResult(finalResult)
		);
		
	    return finalResult;
	}
	
}
