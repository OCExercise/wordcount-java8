package org.opencorrelate.exercise.wordcount;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordCount {
	
	
	public static Integer count(String input)
	{
		
		List<String> words = Arrays.asList(input.split("\\s+"));
		int max = words
				.stream()
				.filter(w -> !(w.matches("^[0-9]+$")))		// Ignore numbers
				
				.collect(Collectors.toConcurrentMap(		// Count consecutive occurrences of word lengths
						w -> { 
							return w.length(); 
						}
						, w -> 1
						, Integer::sum))
				.values()
				.stream()									// Get max consecutive occurences
				.reduce(Integer::max)
				.orElse(0);									// Zero if input has no words
				
				
				
		
		return max;
	}
	
	
	public static List<Integer> count(List<String> inputs) {
		
		List<Integer> outputs = inputs
				.stream()
				.map(input -> WordCount.count(input))
				.collect(Collectors.toList());
		
		return outputs;
	}

}
