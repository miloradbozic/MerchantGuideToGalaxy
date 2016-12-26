package com.mlrd.util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Action {
	
	@SafeVarargs
	public static void lists(Consumer<? super String> action, List<String>... data) {
    	Arrays.stream(data)
    	.forEach(list -> list.stream().forEach(action));
    }

}
