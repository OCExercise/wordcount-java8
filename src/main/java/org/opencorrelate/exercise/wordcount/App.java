package org.opencorrelate.exercise.wordcount;

import gnu.getopt.Getopt;

public class App 
{
    public static void main( String[] args )
    {
    	
    	if (args.length < 1) {
    		usage();
    		System.exit(-1);
    	}
    	
    	Getopt g = new Getopt("wordcount", args, "i:");
    	
    	int c;
    	while ((c = g.getopt()) != -1) {
    		switch (c) 
    		{
    			case 'i':
    				String input = g.getOptarg();
    				System.out.println(input);
    				break;
    			
    			default:
    				usage();
    				System.exit(-1);
    		}
    	}
    	
        
    }
    
    
    public static void usage() {
    	System.err.println("Usage: wordcount -i <input string>");
    }
}
