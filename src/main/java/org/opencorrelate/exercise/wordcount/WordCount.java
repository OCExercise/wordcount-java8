package org.opencorrelate.exercise.wordcount;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class WordCount {
	
	
	public static Integer count(String input)
	{
		
		final List<String> words = Arrays.asList(input.split("\\s+"));
		
		final List<List<Integer>> consecutiveWordGroups = words
				.stream()
	            .reduce(new ArrayList<List<Integer>>(),						// Perform a fold on original word list.  
	                    
	            		(l, word) -> {										
	                        
	                    	if (l.isEmpty()) {								// initialize list for a given input if need be
	                            l.add(new ArrayList<>());
	                        }
	                        
	                        List<Integer> last = l.get(l.size() - 1);		// grab the backwards head
	                        
							if (!last.isEmpty() && !last.contains(word.length())) {	// split off a new consecutive word group if backwards head doesn't contain word
								List<Integer> newLast = new ArrayList<Integer>();
								newLast.add(word.length());
	                            l.add(newLast);
	                            
	                        } else {										// add word to backwards head if it does contain word
	                            last.add(word.length());								
	                        }
	                        
	                        return l;
	                    },
	            		
	                    (list1, list2) -> {
	                            list1.addAll(list2);
	                            return list1;
	                    });
		
		final int max = consecutiveWordGroups 								// Return size of largest consecutive word group
				.stream()
				.map( l -> l.size())
				.max( (s1, s2) -> s1 - s2 )
				.orElse(0);
		
		return max;
	}
	
	
	public static List<Integer> count(List<String> inputs) {
		
		List<Integer> outputs = inputs
				.stream()
				.map(input -> WordCount.count(input))
				.collect(Collectors.toList());
		
		return outputs;
	}
	
	
	public static List<String> open(String path) throws Exception {
		
		Supplier<LinkedList<String>> supplier = () -> new LinkedList<String>();
		
		File file = new File(path);
		
		LinkedList<String> lines = Files
				.lines(file.toPath())
				.map(s -> s.trim())
				.collect(Collectors.toCollection(supplier));
		
		int count;
		try {
			count = Integer.parseInt(lines.pop());
		} catch (Exception e) {
			throw new UnsupportedOperationException("Unable to parse dataset count", e);
		}
		
		if (count != lines.size()) {
			throw new UnsupportedOperationException(String.format("Expected %d datasets, got %d", count, lines.size()));
		}
				
		
		return lines;
	}

}
