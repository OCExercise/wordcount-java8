package org.opencorrelate.exercise.wordcount;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

public class WordCountTest {
	@Test
	public void testApp() {
		List<String> inputs = Arrays.asList(
				"2"
				, "a aa bb cc def ghi"
				, "a a a a a bb bb bb bb c c"
				, "a aa aa aa aa bb cc def ghi"
				, "a aa aa bb aa aa cc def ghi");

		List<Integer> outputs = WordCount.count(inputs);
		List<Integer> expected = Arrays.asList(0, 3, 5, 4, 2);

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
}
