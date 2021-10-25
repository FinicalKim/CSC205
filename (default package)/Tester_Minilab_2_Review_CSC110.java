/*	This program will test their MinilabReview.java.
	For input, it is expecting:
		the description of the test
		the number of testPhrases to look for
		the testPhrases themselves
		the number of inputs
		the inputs themselves
*/

import java.io.*;
import java.util.regex.*;
import java.util.*;

public class Tester_Minilab_2_Review_CSC110
{
	private static String allResults = "";

	public static void main(String[] args) throws Throwable
	{
		//declare and ArrayList to hold all the input Strings to test
		ArrayList<String> inputAL = new ArrayList<String>();

		//declare a Scanner to read standard input
		Scanner kb = new Scanner(System.in);

		//read in the test description
		String testDescription = kb.nextLine();

		//read in how many testPhrases to look for (in order)
		int numTestPhrases = kb.nextInt();

		kb.nextLine();   //flush leftover ENTER from input stream

		//read in the testPhrases and put them in an ArrayList
		ArrayList<String> testPhraseAL = new ArrayList<String>();
		for (int i=0; i<numTestPhrases; i++)
		{
			String aTestPhrase = kb.nextLine();
			testPhraseAL.add(aTestPhrase);
		}

		//read in the number of test inputs (ints)
		int numInputs = kb.nextInt();

		kb.nextLine();    //flush ENTER from input stream

		//print the description before running the test cases
		System.out.println(testDescription);

		//read in all of the test inputs - keep track of the longest length (for formatting later)
		int longLength=0;
		for (int i=0; i<numInputs; i++)
		{
			//Read the inputs for this particular test    ****** CUSTOMIZE EACH TIME ******
			String allInputs = kb.nextLine();    //grab inputs (all ints are on one line for this input)
			//////allInputs = allInputs + "\n " + kb.nextLine();     //grab other integer inputs on the next line
			inputAL.add(allInputs);

			//keep track of the shortest and longest input String
			if (i==0)     //if first input, it is the longest
				longLength = allInputs.length();
			else if (allInputs.length() > longLength)   //new longest?
				longLength = allInputs.length();
		}

		System.out.println();   //for spacing

		//if there is no input, just call runTest, passing in no input
		if (numInputs == 0)
			runTest(testDescription, "", testPhraseAL, longLength, false, false);

		else		//run ALL of the tests with ALL of the input
		{			//also pass in the testPhrase, the longest input length, and whether to print the test phrase first
			for (int i=0; i<inputAL.size(); i++)
				runTest(testDescription, inputAL.get(i), testPhraseAL, longLength, false, false);
		}

		//now print allResults
		System.out.println(allResults);
	}

	/* ===============================================
	   runTest method -	will call their program to run all tests with kbInput (capturing stdin so kbInput is read in).
	   									it will then look at the results (first capturing stdout) and pick out results with testPhrase in it
	   									to store in allResults (formatted).
	   									that way, we can see the results for different values of kbInput.
	   ===============================================*/
	public static void runTest(String testDescription, String kbInput, ArrayList<String> testPhraseAL, int longLength, boolean outputTestPhrase, boolean fixSpaces)
	{
		InputStream originalInput = System.in;
		PrintStream originalOutput = System.out;
		Scanner contentScan = null;   //up here?
		try
		{
			//set the input stream to the String that is passed in
			InputStream is = new ByteArrayInputStream(kbInput.getBytes());
			System.setIn(is);

			//also capture the output stream so it can be analyzed
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(baos);
			System.setOut(ps);
			System.setErr(ps);

			//run their program (the main method)    ****** CUSTOMIZE EACH TIME ******
			Minilab_2.main(new String[0]);

			//content will hold their entire output
			String content = baos.toString();

			//if there are no specific testPhrases, then print the entire output instead of looking for a specific testPhrase
			if (testPhraseAL.size() == 0)
			{
				allResults = allResults + "input was: " + kbInput.replaceAll("\\n", "\\\\n");
				allResults = allResults + "\n" + content;
			}
			else
			{
				//go through all the testPhrases that are in testPhraseAL
				for (int phraseNum=0; phraseNum<testPhraseAL.size(); phraseNum++)
				{
					String testPhrase = testPhraseAL.get(phraseNum);
					String testResults = "";

					//go through content and only keep the ones that have testPhrase in it     //AFTER the testPhrase
					contentScan = new Scanner(content);
					boolean aftertestPhrase = false;
					while(contentScan.hasNextLine())
					{
						String line = contentScan.nextLine();

						if (line.contains(testPhrase))
							testResults = testResults + line.trim() + "   ";
					}

					if (kbInput.length() > 0 && phraseNum==0)     //it will skip printing the input if its size is 0 (meaning...no input)
					{
						allResults = allResults + "input was: " + kbInput.replaceAll("\\n", "\\\\n");
						for (int i=0; i<(longLength-kbInput.length()) + 6; i++)    //pad so things line up
							allResults = allResults + " ";
					}

					//if looking for an exception, do not output the actual message (every one may differ)
					int exceptionIndex = testResults.indexOf("Exception:");
					if (exceptionIndex != -1)
						testResults = testResults.substring(0,exceptionIndex+9) + " ";

					if (fixSpaces)
						testResults = testResults.replaceAll("\\s+", " ");    //change all white space (tabs, spaces, newlines) to a single space

					//if the testPhrase does not end with ":", then all we want to to output the testPhrase.
					//(this is to handle if the user puts in System.out.print for the prompt)
					if (!testPhrase.endsWith(":"))
					{
						String shortResults = "";
						while (testResults.contains(testPhrase))
						{
							shortResults += testPhrase + " ";
							testResults = testResults.replaceFirst(testPhrase, "");
						}
						testResults = shortResults;
					}
					//if testPhrase ends in a :, then the whole line will be printed, so trim off leading and trailing blanks
					else
						testResults = testResults.trim();

					if (phraseNum==0 && testResults.contains("\\n"))     //if testResults contains a \n, then note that its all on one line...
						allResults = allResults + "result (on one line): " + testResults + " \n";
					else if (phraseNum==0)
						allResults = allResults + "result: " + testResults + " \n";
					else   //not first testPhrase, so just pad so that results line up...
					{
						for (int i=0; i<longLength + 25; i++)    	//instead of printing "input was: and results: ",
							allResults = allResults + " ";											//just pad with blanks so things line up
						allResults = allResults + testResults + " \n";
					}

				}   //end of for loop for testPhrases
			}	//end of else (testPhrases exist)

			//reset the input and the output
			System.setIn(originalInput);
			System.setOut(originalOutput);
			System.setErr(originalOutput);

		}   //end of try
		catch (Throwable ex)
		{
			System.setOut(originalOutput);
			System.setErr(originalOutput);
			System.out.println(ex);
			//ex.printStackTrace();
		}
		finally
		{
			//reset standard output
			System.setOut(originalOutput);
			System.setErr(originalOutput);
		}

	}
}
