import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;

public class WordsCounter {
	private static final String INPUT_FILE = "src/tmp/text.txt";
	private static final String OUTPUT_FILE = "src/tmp/wordsCount.txt";

	public static void main(String[] args) {
		File inputFile = new File(INPUT_FILE);
		File outputFile = new File(OUTPUT_FILE);
		Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        System.out.println("Today's date is: "+dateFormat.format(date));

        SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        System.out.println("Today's date is: "+dateformat2.format(date));

		// read file

		String inputString = "";
		String outputString = "";

		try {
			inputString = FileUtils.readFileToString(inputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("******************** Text ********************");
		System.out.println(inputString);
		System.out.println("**********************************************");

		// count words and generate outputString
		String[] words = inputString.toLowerCase().replaceAll("[-.?!)(,:]", "").split("\\s");

		Map<String, Integer> counterMap = new HashMap<>();
		for (String word : words) {
			if (!word.isEmpty()) {
				Integer count = counterMap.get(word);
				if (count == null) {
					count = 0;
				}
				counterMap.put(word, ++count);
			}
		}

		// ----------------------------------------
		// code can be removed

		counterMap = sortByValue(counterMap);

		//

		for (String word : counterMap.keySet()) {
			System.out.println(word + ": " + counterMap.get(word));
			outputString = outputString + word + ": " + counterMap.get(word) + "\n";

		}

		// write outputString to file
		try {
			FileUtils.writeStringToFile(outputFile, outputString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/*
	 * Method for sorting map by value
	 */
	public static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {
		// 1. Convert Map to List of Map
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

		// 2. Sort list with Collections.sort(), provide a custom Comparator
		// Try switch the o1 o2 position for a different order
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o2, Map.Entry<String, Integer> o1) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// 3. Loop the sorted list and put it into a new insertion order Map
		// LinkedHashMap
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		/*
		 * //classic iterator example for (Iterator<Map.Entry<String, Integer>> it =
		 * list.iterator(); it.hasNext(); ) { Map.Entry<String, Integer> entry =
		 * it.next(); sortedMap.put(entry.getKey(), entry.getValue()); }
		 */

		return sortedMap;
	}

}
