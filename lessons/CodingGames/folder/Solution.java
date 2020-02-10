package lessons.CodingGames.folder;

/*public static void main(String[] args) {

    String regex = "([a-zA-Z]+)\1{1,}";
    Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

    Scanner in = new Scanner(System.in);
    int numSentences = Integer.parseInt(in.nextLine());
    
    while (numSentences-- > 0) {
        String input = in.nextLine();
        
        Matcher m = p.matcher(input);
        
        // Check for subsequences of input that match the compiled pattern
        while (m.find()) {
            input = input.replaceAll(m.group(), m.group(2) The replacement. );
        }
        
        // Prints the modified sentence.
        System.out.println(input);
    }
    
    in.close();
}*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String regex = "<([\\w]+)>([\\w]+)<\\1\\>";
		Pattern pattern = Pattern.compile(regex);
		int testCases = Integer.parseInt(in.nextLine());
		while (testCases > 0) {
			String line = in.nextLine();
			Matcher m = pattern.matcher(line);
	        while (m.find()) {
	        	line = line.replaceAll(m.group(), m.group(2));
	        	System.out.println(line);
	        }
			
			testCases--;
		}
	}
}