package ir.assignments.one.b;

import ir.assignments.one.a.Frequency;
import ir.assignments.one.a.Utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Counts the total number of words and their frequencies in a text file.
 */
public final class WordFrequencyCounter {
	/**
	 * This class should not be instantiated.
	 */
	private WordFrequencyCounter() {}
	
	/**
	 * Takes the input list of words and processes it, returning a list
	 * of {@link Frequency}s.
	 * 
	 * This method expects a list of lowercase alphanumeric strings.
	 * If the input list is null, an empty list is returned.
	 * 
	 * There is one frequency in the output list for every 
	 * unique word in the original list. The frequency of each word
	 * is equal to the number of times that word occurs in the original list. 
	 * 
	 * The returned list is ordered by decreasing frequency, with tied words sorted
	 * alphabetically.
	 * 
	 * The original list is not modified.
	 * 
	 * Example:
	 * 
	 * Given the input list of strings 
	 * ["this", "sentence", "repeats", "the", "word", "sentence"]
	 * 
	 * The output list of frequencies should be 
	 * ["sentence:2", "the:1", "this:1", "repeats:1",  "word:1"]
	 *  
	 * @param words A list of words.
	 * @return A list of word frequencies, ordered by decreasing frequency.
	 */
	public static ArrayList<Frequency> computeWordFrequencies(ArrayList<String> words) {
		// TODO Write body!
		
		ArrayList<Frequency> res=new ArrayList<Frequency>();
		if (words.size()==0) return res;
		Map<String, Integer> hm = new HashMap<String, Integer>();
	      int x;

	      for (int i=0; i<words.size() ; i++) {
	    	  String buf=words.get(i);
	         if (hm.containsKey(buf)) {
	            int cont = hm.get(buf);
	            hm.put(buf, cont + 1);
	         } else {
	            hm.put(buf, 1);
	         }
	      }
		
	      Iterator it = hm.entrySet().iterator();
	      while (it.hasNext()) {
	          Map.Entry pairs = (Map.Entry)it.next();
//	          System.out.println(pairs.getKey() + "  " + pairs.getValue());
//	          String st=pairs.getKey();
	          Frequency tmp=new Frequency((String)pairs.getKey(),(int)pairs.getValue());
	          it.remove(); // avoids a ConcurrentModificationException
	          res.add(tmp);
	      }
	      
	      
	      return res;
	      
	      
	}
	
	/**
	 * Runs the word frequency counter. The input should be the path to a text file.
	 * 
	 * @param args The first element should contain the path to a text file.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
//		boolean check=Utilities.IsPali("   s i lu lis");
		
		 File file = new File(args[0]);
//		 String filePath = "/Users/silu/Documents/Reddit_data/221te";
//		 File fin = new File(filePath);
		
		ArrayList<String> words = Utilities.tokenizeFile(file);
 		ArrayList<Frequency> frequencies = computeWordFrequencies(words);
		Utilities.printFrequencies(frequencies);
		
//		String bud=words.get(0)+" "+words.get(1);
//		System.out.println(bud);
	}
}
