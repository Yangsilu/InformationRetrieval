package ir.assignments.one.a;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * A collection of utility methods for text processing.
 */
public class Utilities {
	/**
	 * Reads the input text file and splits it into alphanumeric tokens.
	 * Returns an ArrayList of these tokens, ordered according to their
	 * occurrence in the original text file.
	 * 
	 * Non-alphanumeric characters delineate tokens, and are discarded.
	 *
	 * Words are also normalized to lower case. 
	 * 
	 * Example:
	 * 
	 * Given this input string
	 * "An input string, this is! (or is it?)"
	 * 
	 * The output list of strings should be
	 * ["an", "input", "string", "this", "is", "or", "is", "it"]
	 * 
	 * @param input The file to read in and tokenize.
	 * @return The list of tokens (words) from the input file, ordered by occurrence.
	 * @throws IOException 
	 */
	public static ArrayList<String> tokenizeFile(File input) throws IOException {
		// TODO Write body!
		
		 FileInputStream fis = new FileInputStream(input);
		 BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		 
		 String line = null;
		 ArrayList<String> tokens = new ArrayList<>();
		while ((line = br.readLine()) != null) { //read lines
//			System.out.println(line);
			line = line.replaceAll("[^A-Za-z0-9]"," "); //only keep alphanumber
			StringTokenizer st = new StringTokenizer(line); //tokenizer
		     while (st.hasMoreTokens()) {
		    	 tokens.add(st.nextToken().toLowerCase());
//		    	 System.out.println(tokens.size());
//		    	 System.out.println(tokens.get(tokens.size() - 1)  );
		     }
			
		}
		 
		br.close();
		return tokens;
		//return null;
	}
	
	public static boolean IsPali(String word){
		
		int left,right;
		left=0;
		right=word.length()-1;
		
		while(left<right){
			
			if(word.charAt(left)==' ') left++;
			else if(word.charAt(right)==' ') right--;
			else{
				if(word.charAt(left)!=word.charAt(right)) return false;
				left++;
				right--;
			}
			
		}
		
		return true;
	}
	
	/**
	 * Takes a list of {@link Frequency}s and prints it to standard out. It also
	 * prints out the total number of items, and the total number of unique items.
	 * 
	 * Example one:
	 * 
	 * Given the input list of word frequencies
	 * ["sentence:2", "the:1", "this:1", "repeats:1",  "word:1"]
	 * 
	 * The following should be printed to standard out
	 * 
	 * Total item count: 6
	 * Unique item count: 5
	 * 
	 * sentence	2
	 * the		1
	 * this		1
	 * repeats	1
	 * word		1
	 * 
	 * 
	 * Example two:
	 * 
	 * Given the input list of 2-gram frequencies
	 * ["you think:2", "how you:1", "know how:1", "think you:1", "you know:1"]
	 * 
	 * The following should be printed to standard out
	 * 
	 * Total 2-gram count: 6
	 * Unique 2-gram count: 5
	 * 
	 * you think	2
	 * how you		1
	 * know how		1
	 * think you	1
	 * you know		1
	 * 
	 * @param frequencies A list of frequencies.
	 */
	public static void printFrequencies(ArrayList<Frequency> frequencies) {
		// TODO Write body!
		if (frequencies.size()==0) {
			System.out.println("\nTotal count: "+0);
			System.out.println("Unique count: "+0+"\n");
			return;
		}

		int sum=0;
		for(int i=0;i<frequencies.size();i++){
			sum=sum+frequencies.get(i).getFrequency();
		}
		
		boolean isWhitespace = frequencies.get(0).getText().indexOf(" ") != -1;
		
		if(isWhitespace){

			System.out.println("\nTotal 2-gram count: "+sum);
			System.out.println("Unique 2-gram count: "+frequencies.size()+"\n");
		}else{

			System.out.println("\nTotal item count: "+sum);
			System.out.println("Unique item count: "+frequencies.size()+"\n");
		}
		
		
		for(int i=0;i<frequencies.size();i++){
			System.out.printf("%s %10d\n", frequencies.get(i).getText() , frequencies.get(i).getFrequency());
		}
		
	
		
	}
}
