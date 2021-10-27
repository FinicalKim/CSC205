//This will run test cases for the Segment class (Minilab assignment).
//It will not prompt for input, //but is expecting input of the form "testing <what to test>"

public class SegmentTester_Minilab_7_Segment
{
	public static void main(String[ ] args)
	{
		//get the arguments for the test - note no prompt
		java.util.Scanner kb = new java.util.Scanner(System.in);
		String test = kb.nextLine();

		if (test.equalsIgnoreCase("testing default constructor") ||
			test.equalsIgnoreCase("testing all"))
		{
			System.out.println("\n-----------------------------");
			boolean printDescription = true;
			boolean checkChanges = true;

			try
			{
				if (printDescription)
					System.out.println("\n==>Testing default constructor/toString()");
				Segment theSegment = new Segment();
				System.out.println(theSegment);
			}
			catch (Throwable ex)
			{
				System.out.println(ex.getClass().getName());    //just prints name of exception; needed for Hypergrade
				//ex.printStackTrace();         //in case the user wants more information on the exception
			}
		}

		//***************************************************
		//***************************************************
		if (test.equalsIgnoreCase("testing 2 parameter constructor") ||
			test.equalsIgnoreCase("testing all"))
		{
			Point p1 = null;
			String p1OrigToString = "<empty>";
			Point p2 = null;
			String p2OrigToString = "<empty>";
			Segment theSegment = null;
			String origToString = "<empty>";

			Point[ ] arg1Array = { null, new Point(2,4), new Point(2, 0) };
			Point[ ] arg2Array = { null, new Point(2,0) };

			System.out.println("\n-----------------------------");
			boolean printDescription = true;
			boolean checkChanges = true;

			for (int arg1Index = 0; arg1Index<arg1Array.length; arg1Index++)
				for (int arg2Index = 0; arg2Index<arg2Array.length; arg2Index++)
				{
					p1 = arg1Array[arg1Index];
					if (p1 != null)
						p1OrigToString = p1.toString();
					p2 = arg2Array[arg2Index];
					if (p2 != null)
						p2OrigToString = p2.toString();

					try
					{
						if (printDescription)
							System.out.println("\n==>Testing 2 parameter constructor/toString(), passing in " + p1 +  " and " + p2);
						theSegment = new Segment(p1, p2);
						System.out.println(theSegment);
					}
					catch (Throwable ex)
					{
						System.out.println(ex.getClass().getName());    //just prints name of exception; needed for Hypergrade
						//ex.printStackTrace();         //in case the user wants more information on the exception
					}
					finally
					{
						if ( p1!=null && p2!=null && (!p1OrigToString.equals(p1.toString()) || (!p2OrigToString.equals(p2.toString()))) )
							System.out.println("...but one or more of the argument Points CHANGED during the operation");
					}
				}
		}

		//***************************************************
		//***************************************************
		if (test.equalsIgnoreCase("testing 1 parameter constructor") ||
			test.equalsIgnoreCase("testing all"))
		{
			Point p2 = null;
			String p2OrigToString = "<empty>";
			Segment theSegment = null;
			String origToString = "<empty>";

			System.out.println("\n-----------------------------");
			boolean printDescription = true;
			boolean checkChanges = true;

			//separate try-catch to pass in null
			try
			{
				if (printDescription)
					System.out.println("\n==>Testing 1 parameter constructor/toString(), passing in " + null);
				theSegment = new Segment(p2);
				System.out.println(theSegment);
			}
			catch (Throwable ex)
			{
				System.out.println(ex.getClass().getName());    //just prints name of exception; needed for Hypergrade
				//ex.printStackTrace();         //in case the user wants more information on the exception
			}
			finally
			{
				if ( p2 !=  null && (!p2OrigToString.equals(p2.toString())) )
					System.out.println("...but the argument Point changed during the operation");
			}

			//a different try-catch to build up (x,y) points and test them
			int[ ] argsXArray = { 2, 0 };
			int [ ] argsYArray = { 0, -4 };

			for (int x2Index = 0; x2Index<argsXArray.length; x2Index++)
				for (int y2Index = 0; y2Index<argsYArray.length; y2Index++)
				{
					p2 = new Point(argsXArray[x2Index], argsYArray[y2Index]);
					p2OrigToString = p2.toString();

					try
					{
						if (printDescription)
							System.out.println("\n==>Testing 1 parameter constructor/toString(), passing in " + p2);
						theSegment = new Segment(p2);
						System.out.println(theSegment);
					}
					catch (Throwable ex)
					{
						System.out.println(ex.getClass().getName());    //just prints name of exception; needed for Hypergrade
						//ex.printStackTrace();         //in case the user wants more information on the exception
					}
					finally
					{
						if ( p2 != null && (!p2OrigToString.equals(p2.toString())) )
							System.out.println("...but the argument Point changed during the operation");
					}
				}
		}


		//***************************************************
		//***************************************************
		if (test.equalsIgnoreCase("testing copy constructor") ||
			test.equalsIgnoreCase("testing all"))
		{
			System.out.println("\n-----------------------------");
			boolean printDescription = true;
			boolean checkChanges = true;

			//-------------------------------------------------------------
			Segment[ ] segmentArray = {	null,
																new Segment(new Point(5,6), new Point(3,-1)),
																new Segment(new Point(0,2), new Point(-3,4))
															};
			Segment theSegment = null;
			String origToString = "<empty>";
			Segment argSegment = null;
			String argOrigToString = "<empty>";

			for (int i=0; i<segmentArray.length; i++)
			{
				try
				{
					argSegment = segmentArray[i];
					if (argSegment != null)
						argOrigToString = argSegment.toString();
					if (printDescription)
						System.out.println("\n==>Testing copy constructor (translate must work), passing in " + argSegment);
					theSegment = new Segment(argSegment);
					origToString = theSegment.toString();
					System.out.println("Segment that was created is:  " + theSegment);
				}
				catch (Throwable ex)
				{
					System.out.println(ex.getClass().getName());	//just prints name of exception; needed for Hypergrade
					//ex.printStackTrace();         //in case the user wants more information on the exception
				}
				finally
				{
					if (checkChanges && argSegment != null && !argSegment.toString().equals(argOrigToString))
						System.out.println("...but the argument Segment CHANGED during the operation");
					else if (argSegment != null)
					{
						argSegment.translate(1, 1);     //change the argSegment to see if Segment changes too (shallow)
						if (checkChanges && !origToString.equals(theSegment.toString()))
							System.out.println("...but the copy was a SHALLOW copy");
					}
				}
			}

		}

		//***************************************************
		//***************************************************
		if (test.equalsIgnoreCase("testing translate") ||
			test.equalsIgnoreCase("testing all"))
		{
			System.out.println("\n-----------------------------");
			boolean printDescription = true;
			boolean checkChanges = false;
			Segment theSegment = null;
			String origToString = "<empty>";

			//moves
			int[ ] xMoves = 			{	3,  0 };
			int[ ] yMoves = 			{	0, -2 };

			for (int xIndex=0; xIndex<xMoves.length; xIndex++)
				for (int yIndex=0; yIndex<yMoves.length; yIndex++)
					try
					{
						int changeX = xMoves[xIndex];
						int changeY = yMoves[yIndex];
						theSegment = new Segment( new Point(2,1), new Point(3,-1) );
						origToString = theSegment.toString();
						System.out.println("\n==>Testing translate("+changeX+","+changeY+") method of " + theSegment);
						theSegment.translate(changeX, changeY);
						System.out.println("Segment is now: " + theSegment);
					}
					catch(Throwable ex)
					{
						System.out.println(ex.getClass().getName());	//just prints name of exception; needed for Hypergrade
						//ex.printStackTrace();         //in case the user wants more information on the exception
					}
					finally
					{
						if (checkChanges && !origToString.equals(theSegment.toString()))
							System.out.println("...but the Segment CHANGED during the operation");
					}
		}

		//***************************************************
		//***************************************************
		if (test.equalsIgnoreCase("testing length") ||
			test.equalsIgnoreCase("testing all"))
		{
			System.out.println("\n-----------------------------");
			boolean printDescription = true;
			boolean checkChanges = true;
			Point p1 = null;
			String p1OrigToString = "<empty>";
			Point p2 = null;
			String p2OrigToString = "<empty>";
			Segment theSegment = null;
			String origToString = "<empty>";

			int[ ] arg1XArray = { 0, 5 };
			int [ ] arg1YArray = { 4 };
			int[ ] arg2XArray = { 3, 5 };
			int [ ] arg2YArray = { 0 };

			for (int x1Index = 0; x1Index<arg1XArray.length; x1Index++)
				for (int y1Index = 0; y1Index<arg1YArray.length; y1Index++)
					for (int x2Index = 0; x2Index<arg2XArray.length; x2Index++)
						for (int y2Index = 0; y2Index<arg2YArray.length; y2Index++)
						{
							try
							{
								p1 = new Point(arg1XArray[x1Index], arg1YArray[y1Index]);
								p1OrigToString = p1.toString();
								p2 = new Point(arg2XArray[x2Index], arg2YArray[y2Index]);
								p2OrigToString = p2.toString();

								theSegment = new Segment( p1, p2 );
								origToString = theSegment.toString();
								System.out.println("\n==>Testing length() of " + theSegment);
								double result = theSegment.length();
								java.text.DecimalFormat df = new java.text.DecimalFormat("#.###");
								System.out.println("Length is: " + df.format(result));
							}
							catch(Throwable ex)
							{
								System.out.println(ex.getClass().getName());	//just prints name of exception; needed for Hypergrade
								ex.printStackTrace();         //in case the user wants more information on the exception
							}
							finally
							{
								if (checkChanges && theSegment!= null && !origToString.equals(theSegment.toString()))
									System.out.println("...but the Segment CHANGED during the operation");
							}
						}
		}

		//***************************************************
		//***************************************************
		if (test.equalsIgnoreCase("testing isAnEndpoint") ||
			test.equalsIgnoreCase("testing all"))
		{
			System.out.println("\n-----------------------------\n");
			boolean printDescription = true;
			boolean checkChanges = true;
			Segment theSegment = null;
			String origToString = "<empty>";
			Point argPoint = null;
			String origArgToString = "<empty>";

			//2D array of [triangle][vertices]
			Point[ ] testPoints = 	{	null,
													new Point(1,2), new Point(1,3), new Point(2,3),
													new Point(3,4), new Point(4,5)
												};

			for (int i=0; i<testPoints.length; i++)   //go through each possible triangle
			{
				try
				{
					theSegment = new Segment(new Point(1,2), new Point(3,4));
					origToString = theSegment.toString();
					argPoint = testPoints[i];
					if (argPoint != null)
						origArgToString = argPoint.toString();

					System.out.println("\n==>Testing " + theSegment + "     isAnEndpoint(" + argPoint + ")");
					boolean result = theSegment.isAnEndpoint(argPoint);
					System.out.println(result);
				}
				catch(Throwable ex)
				{
					System.out.println(ex.getClass().getName());	//just prints name of exception; needed for Hypergrade
					//ex.printStackTrace();         //in case the user wants more information on the exception
				}
				finally
				{
					if (checkChanges && !origToString.equals(theSegment.toString()))
						System.out.println("...but the Segment CHANGED during the operation");
					if (checkChanges && argPoint != null && !origArgToString.equals(argPoint.toString()))
						System.out.println("...but the argument Point CHANGED during the operation");
				}
			}
		}

		//***************************************************
		//***************************************************
		if (test.equalsIgnoreCase("testing equals") ||
			test.equalsIgnoreCase("testing all"))
		{
			System.out.println("\n-----------------------------\n");
			boolean printDescription = true;
			boolean checkChanges = true;

			Segment theSegment = new Segment(new Point(1,2), new Point(3,4));
			String origToString = "<empty>";
			Object argObject = null;
			String argOrigToString = "<empty>";

			Object[ ] argArray = 	{ 	null,
													theSegment.toString(),
													new Segment(new Point(1,2), new Point(5,6)),
													new Segment(new Point(7,8), new Point(3,4)),
													new Segment(new Point(1,2), new Point(3,4)),       //correct one
													new Segment(new Point(3,4), new Point(1,2))       //also correct one
												};

			for (int argIndex=0; argIndex<argArray.length; argIndex++)
			{
				try
				{
					theSegment = new Segment(new Point(1,2), new Point(3,4));
					origToString = theSegment.toString();

					argObject = argArray[argIndex];
					System.out.print("\n==>Testing whether " + theSegment + " .equals " + argObject);
					if (argObject != null && argObject.getClass() == "".getClass())     //String
						System.out.println(" (as a STRING)");
					else
						System.out.println();

					if (argObject != null)
						argOrigToString = argObject.toString();

					boolean result = theSegment.equals(argObject);
					System.out.println(result);
				}
				catch (Throwable ex)
				{
					System.out.println(ex.getClass().getName());	//just prints name of exception; needed for Hypergrade
					ex.printStackTrace();         //in case the user wants more information on the exception
				}
				finally
				{
					if (checkChanges && !theSegment.toString().equals(origToString))
						System.out.println("...but the original Segment CHANGED during the operation");
					if (checkChanges && argObject!=null && !argObject.toString().equals(argOrigToString))
						System.out.println("...but the argument Segment CHANGED during the operation");
				}
			}
		}


	}
}
