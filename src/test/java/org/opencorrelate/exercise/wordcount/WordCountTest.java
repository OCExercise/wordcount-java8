package org.opencorrelate.exercise.wordcount;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

public class WordCountTest {
	
	
	@Test
	public void testWordCount()  throws Exception {
		List<String> inputs = Arrays.asList(
				"a aa bb cc def ghi"
				, "a a a a a bb bb bb bb c c"
				, "a b c d e ab ba cd dc c d ghi"
				, "a aa aa aa aa bbb ccc def ghi"
				, "a aa aa bbb aa aa ccc defg ghi");

		List<Integer> outputs = WordCount.count(inputs);
		List<Integer> expected = Arrays.asList(3, 5, 5, 4, 2);

		assertEquals(expected.size(), outputs.size());

		// Zip expected with output and apply assertions
		IntStream.range(0, expected.size()).forEach(i -> {
			Integer e = expected.get(i);
			Integer o = outputs.get(i);
			assertEquals(
					String.format("Line %d: expected %d, not %d", i+1, e, o)
					, e, o);
		});
	}
	
	
	@Test
	public void testWordCountWithFileInput() throws Exception {
		URL url = getClass().getResource("/input.txt");
		assertNotNull(url);
		
		List<String> inputs = WordCount.open(url.getPath()); 
		
		assertNotNull(inputs);
		assertNotSame(0, inputs.size());
				
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testWordCountWithFileInputAndNoDatasetCount() throws Exception {
		URL url = getClass().getResource("/input-nocount.txt");
		assertNotNull(url);
		
		WordCount.open(url.getPath()); 
		
				
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testWordCountWithFileInputAndWrongDatasetCount() throws Exception {
		URL url = getClass().getResource("/input-wrongcount.txt");
		assertNotNull(url);
		
		WordCount.open(url.getPath()); 
		
				
	}
}
