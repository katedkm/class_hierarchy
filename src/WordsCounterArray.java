import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class WordsCounterArray {

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
		String[] words = inputString.toLowerCase().replaceAll("[-.?!)(,:\\n]", "").split("\\s");
		String[] uniqueWords;
		int count = 0;
		uniqueWords = getUniqueKeys(words);
		for (String word : uniqueWords) {
			if (null == word) {
				break;
			}
			for (String s : words) {
				if (word.equals(s)) {
					count++;
				}
			}
			System.out.println(word +": " + count);
			outputString = outputString + word + ": " + count + "\n";
			count = 0;
		}

		// write outputString to file
		try {
			FileUtils.writeStringToFile(outputFile, outputString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String[] getUniqueKeys(String[] words) {
		String[] uniqueWords = new String[words.length];
		uniqueWords[0] = words[0];
		int uniqueKeyIndex = 1;
		boolean keyAlreadyExists = false;
		for (int i = 1; i < words.length; i++) {
			for (int j = 0; j <= uniqueKeyIndex; j++) {
				if (words[i].equals(uniqueWords[j])) {
					keyAlreadyExists = true;
				}
			}
			if (!keyAlreadyExists) {
				uniqueWords[uniqueKeyIndex] = words[i];
				uniqueKeyIndex++;
			}
			keyAlreadyExists = false;
		}
		return uniqueWords;
	}
}
