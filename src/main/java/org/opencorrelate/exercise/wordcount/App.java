package org.opencorrelate.exercise.wordcount;

import java.util.List;

import gnu.getopt.Getopt;

public class App 
{
    public static void main( String[] args )
    {
    	
    	if (args.length < 1) {
    		usage();
    		System.exit(-1);
    	}
    	
    	Getopt g = new Getopt("wordcount", args, "f:");
    	
    	int c;
    	while ((c = g.getopt()) != -1) {
    		switch (c) 
    		{
    			case 'f':
				count(g);
    				break;
    			
    			default:
    				usage();
    				System.exit(-1);
    		}
    	}
    	
        
    }


	private static void count(Getopt g) {
		
		try {
			String path = g.getOptarg();
			List<String> inputs = WordCount.open(path);
			WordCount
				.count(inputs)
				.stream()
				.forEach(i -> System.out.println(i));
		} catch (Exception e) {
			System.err.println(e.getMessage());
			usage();
		}
	}
    
    
    public static void usage() {
    	System.err.println("Usage: wordcount -f <input file>");
    }
}
