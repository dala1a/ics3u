import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;

public class A8_ {

	/*
	 * Method Name: CheckSize 
	 * Author: Kyle McKay 
	 * Creation Date: Nov 15 2023
	 * Date: Nov 15 2023 
	 * Description: Peeks at the size of the array
	 * @Parameters: A integer array
	 * @Return Value: Returns the number of lines in a file 
	 * Data Type: integer ARRAY
	 * Dependencies: n/a 
	 * Throws/Exceptions: File IO errors
	 */
	public static int CheckSize(String filename) {
		int NumberOfItems = 0;
		try {
			BufferedReader FileInputPointer = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			while (FileInputPointer.ready() == true) {
				FileInputPointer.readLine(); // Advances the pointer
				NumberOfItems++;
			}
			FileInputPointer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error - this file does not exist");
			return -1; 
		} catch (IOException e) {
			System.out.println("Error" + e.toString());
			return -1;
		}

		return NumberOfItems;
	}

	/*
	 * Method Name: readIn 
	 * Author: Kyle McKay 
	 * Creation Date; Nov 15 2023 Modified
	 * Date: Nov 15 2023
	 * Description: Reads line by line the integers in a file and places in an array
	 * @Parameters: A integer array, and file name as a string
	 * @Return Value: Returns the filled in array 
	 * Data Type: integer ARRAY
	 * Dependencies: n/a 
	 * Throws/Exceptions: File IO exceptions
	 */
	public static String[] readIn(String filename, String[] namesAndMarks) {
		String dataItem;
		try {
			BufferedReader FileInputPointer = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			int i = 0; // index of the array
			while (FileInputPointer.ready() == true) {
				dataItem = FileInputPointer.readLine(); // filter out the mark - do nothing - just advance the file
														// pointer
				dataItem = FileInputPointer.readLine(); // name

				namesAndMarks[i] = dataItem;
				i++;
			}
			FileInputPointer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error - this file does not exist");
		} catch (IOException e) {
			System.out.println("Error" + e.toString());
		}
		return namesAndMarks;
	}

	/*
	 * Method Name: readIn 
	 * Author: Kyle McKay C
	 * Creation Date; Nov 15 2023 
	 * Modified Date: Nov 15 2023
	 * Description: Reads line by line the integers in a file and places in an array
	 * @Parameters: A integer array, and file name as a string
	 * @Return Value: Returns the filled in array 
	 * Data Type: integer ARRAY
	 * Dependencies: n/a 
	 * Throws/Exceptions: File IO exceptions
	 */
	public static double[] readInMark(String filename, double[] mark) {
		String Holder;
		try {
			BufferedReader FileInputPointer = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			int i = 0; // index of the array
			while (FileInputPointer.ready() == true) {
				Holder = FileInputPointer.readLine().toString(); // double mark number
				mark[i] = Double.parseDouble(Holder);
				i += 1;
				Holder = FileInputPointer.readLine().toString(); // Student name filter it out just advance the file
																	// pointer
			}
			FileInputPointer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error - this file does not exist");
		} catch (IOException e) {
			System.out.println("Error" + e.toString());
		}
		return mark;
	}

	/*
	 * Method Name: writeOut 
	 * Author: Kyle McKay 
	 * Creation Date; Nov 15 2023 
	 * Modified Date: Nov 15 2023 
	 * Description: Creates a new file and outputs the doubles and string array to it. 
	 * @Parameters: file name as a string, String Array and a double array
	 * @Return Value: None its a procedure 
	 * Data Type: integer ARRAY 
	 * Dependencies: n/a 
	 * Throws/Exceptions: File IO exceptions
	 */
	public static void writeOut(String filename, String[] names, double[] marks) {
		try {
			PrintWriter outputfile = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			for (int i = 0; i < names.length; i++) {
				outputfile.println(marks[i]);
				outputfile.println(names[i]);
			}
			outputfile.close();
		} catch (Exception e) {
			System.out.println("My Application Error: " + e.toString());
		}

	}

	/*
	 * Method Name: printOut 
	 * Author: Kyle McKay 
	 * Creation Date; Nov 15 2023
	 * Modified Date: Nov 15 2023 
	 * Description: To output the double array and the string array to the console
	 * @Parameters: A double array and a string array
	 * @Return Value: None its a procedure 
	 * Data Type: integer ARRAY 
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	 */
	public static void printOut(double[] TheArray, String[] array) {
		for (int i = 0; i < TheArray.length; i++) {
			System.out.println(array[i] + " has a mark of " + TheArray[i] + "%");
		}
	}

	/*
	 * Method Name: highestMark 
	 * Author: Yunseo Jeon 
	 * Creation Date; May 20 2024
	 * Modified Date: May 20 2024
	 * Description: Find the highest mark in a double array. 
	 * @Parameters: A String array and a double array
	 * @Return Value: the highest mark in the array
	 * Data Type: double  
	 * Dependencies: n/a
	 * Throws/Exceptions: n/a
	 */
	public static double highestMark(String[] array, double[] thearray) {
		double value = 0.0;
		String name = "";
		for (int i = 1; i < thearray.length; i++) {
			if (thearray[i] > thearray[i - 1]) {
				value = thearray[i];
				name = array[i];
			}
		}
		System.out.println(name);
		return value;
	}

	/*
	 * Method Name: lowestMark 
	 * Author: Yunseo Jeon 
	 * Creation Date; May 20 2024
	 * Modified Date: May 20 2024
	 * Description: Find the lowest mark in a double array. 
	 * @Parameters: A String array and a double array
	 * @Return Value: The lowest mark in the array
	 * Data Type: double  
	 * Dependencies: n/a
	 * Throws/Exceptions: n/a
	 */
	public static double lowestMark(String[] array, double[] thearray) {
		double value = 0.0;
		String name = "";
		for (int i = 1; i < thearray.length; i++) {
			if (thearray[i] < thearray[i - 1]) {
				value = thearray[i];
				name = array[i];
			}
		}
		System.out.println(name);
		return value;
	}

	/*
	 * Method Name: average 
	 * Author: Yunseo Jeon 
	 * Creation Date; May 20 2024
	 * Modified Date: May 20 2024
	 * Description: Find the average mark of the double array. 
	 * @Parameters: A double array
	 * @Return Value: the average of the elements in the array 
	 * Data Type: double  
	 * Dependencies: n/a
	 * Throws/Exceptions: n/a
	 */
	public static double average(double[] theArray) {
		double value = 0.0;
		for (int i = 0; i < theArray.length; i++) {
			value += theArray[i];
		}
		return value / theArray.length;
	}

	/*
	 * Method Name: studentToMark 
	 * Author: Yunseo Jeon 
	 * Creation Date; May 20 2024
	 * Modified Date: May 20 2024
	 * Description: Finds the mark of the student provided. 
	 * @Parameters: A String array, A double array and the name of the student being searched for. 
	 * @Return Value: The mark of the student
	 * Data Type: double  
	 * Dependencies: n/a
	 * Throws/Exceptions: n/a
	 */
	public static double studentToMark(String[] a1, double[] a2, String name) {
		double value = 0.0;
		for (int i = 0; i < a1.length; i++) {
			if (a1[i].equals(name)) {
				value = a2[i];
			}
		}
		if (value == 0.0) {
			System.out.println("This student is not on file! Defaulted to 0%");
		}
		return value;
	}

	/*
	 * Method Name: markToStudent 
	 * Author: Yunseo Jeon 
	 * Creation Date; May 20 2024
	 * Modified Date: May 20 2024
	 * Description: Finds the student based on the mark provided. 
	 * @Parameters: A String array, A double array and the mark being searched for. 
	 * @Return Value: The name of the student
	 * Data Type: String  
	 * Dependencies: n/a
	 * Throws/Exceptions: n/a
	 */
	public static String markToStudent(String[] a1, double[] a2, double mark) {
		String name = null;
		boolean found = false;
		for (int i = 0; i < a2.length; i++) {
			if (a2[i] == mark) {
				name = a1[i];
				found = true;
			}
		}
		if (found == false) {
			System.out.println("This mark doesn't belong to any student!");
		}
		return name;
	}

	/*
	 * Method Name: bellCurveAdd 
	 * Author: Yunseo Jeon 
	 * Creation Date; May 20 2024
	 * Modified Date: May 20 2024
	 * Description: Goes through each element of the mark array and adds the percentage wanted. 
	 * @Parameters: A double array and the percentage being added. 
	 * @Return Value: the double array with updated marks. 
	 * Data Type: double  
	 * Dependencies: n/a
	 * Throws/Exceptions: n/a
	 */
	public static double[] bellCurveAdd(double[] a, double input) {
		for (int i = 0; i < a.length; i++) {
			a[i] += a[i] * (input / 100);
			if (a[i] > 100){
				a[i] = 100;
			}
			a[i] = Math.round(a[i]*100);
			a[i]/=100;
		}
		return a;
	}

	/*
	 * Method Name: bellCurveSubtract 
	 * Author: Yunseo Jeon 
	 * Creation Date; May 20 2024
	 * Modified Date: May 20 2024
	 * Description: Goes through each element of the mark array and subtracts the percentage wanted. 
	 * @Parameters: A double array and the percentage being subtracted. 
	 * @Return Value: the double array with updated marks. 
	 * Data Type: double  
	 * Dependencies: n/a
	 * Throws/Exceptions: n/a
	 */
	public static double[] bellCurveSubtract(double[] a, double input) {
		for (int i = 0; i < a.length; i++) {
			a[i] -= a[i] * (input / 100);
			if (a[i] < 0){
				a[i] = 0;
			}
			a[i] = Math.round(a[i]*100);
			a[i]/=100;
		}
		return a;
	}

	public static void main(String[] args) {
		Scanner userinput = new Scanner(System.in);	// Scanner initalized
		boolean fileFound = false; 
		int SizeOfArray = 0;
		String fname = ""; 
		DecimalFormat x = new DecimalFormat ("0.0");
		// Checking if the file exists or not. 
		do {
			System.out.println("\nPlease enter a filename to read?");
			fname = userinput.nextLine(); 
			SizeOfArray = CheckSize(fname); 

			if(SizeOfArray <= 0)
				System.out.println("Please Try again!");
			else 
				fileFound = true; 
		} while(fileFound != true); 

		System.out.println("# of items in the file: " + SizeOfArray);
		double[] marks = new double[SizeOfArray / 2];
		String[] names = new String[SizeOfArray / 2];
		int choice = 0; // User's choice in menu
		int choice2 = 0; // User's choice in Search (Student or Mark) menu
		int choice3 = 0;// User's choice in bell curve menu
		names = readIn(fname, names);	
		marks = readInMark(fname, marks);
		

		do {
			System.out.println("\nMenu \n1. View student marks \n2. View highest mark \n3. View lowest mark \n4. View class average \n5. Search (Student or Mark) \n6. Bell Curve \n7. Exit \nType in number of choice!");
			choice = Integer.parseInt(userinput.nextLine().trim());

			switch (choice) {
				case 1:// View all the marks
					System.out.println();
					printOut(marks, names);
					break;
				case 2:// View Highest mark
					System.out.println("\nStudent with the highest mark: ");
					System.out.println(highestMark(names, marks) + "%");
					break;
				case 3:// View lowest mark
					System.out.println("\nStudent with the lowest mark: ");
					System.out.println(lowestMark(names, marks) + "%");
					break;
				case 4:// View class average
					System.out.println("\nClass Average: ");
					System.out.println(x.format(average(marks)) + "%");
					break;
				case 5:// Search (Student or Mark)
					do {
						System.out.println("\nSubmenu \n1. Search Student \n2. Search Mark \n3. Exit \nType in number of choice!"); 
							choice2 = Integer.parseInt(userinput.nextLine().trim());
							switch (choice2) {
								case 1:// search student
									System.out.println("\nInput student name:");
									try { 
										String name = userinput.nextLine();
										System.out.println("\n" + name + " has a mark of " + studentToMark(names, marks, name) + "%");
									} catch(Exception e) { 
										System.out.println("Input a valid name!");
										break; 
									}
									break;
								case 2:// search mark
									System.out.println("\nInput student mark: (just numbers)");
									// Try and catch for any misinputs
									try { 
										double mark = Double.parseDouble(userinput.nextLine().trim());
										String name = markToStudent(names, marks, mark); 
										// Check if the student exists. 
										if(name != null)
											System.out.println("\n" + name + " has a mark of " + mark + "%");
									} catch(Exception e) { 
										System.out.println("Input a valid mark!");
										break; 
									}
									break;
								case 3:// exit
									System.out.println("Exited!");
									break;
								default:
									System.out.println("Choose a valid option!");
							}
					} while (choice2 != 3);
					break;
				case 6:// Bell Curve
					do {
						System.out.println("\nSubmenu \n1. Enter the percentage to increase the averages by \n2. Enter the percentage to decrease the averages by. \n3. Exit \nType in number of choice!");
						choice3 = Integer.parseInt(userinput.nextLine().trim());

						switch (choice3) {
						case 1:// enter increase number
								System.out.println("Enter amount to change averages by: ");
								double percent = (double) Integer.parseInt(userinput.nextLine()); 

								System.out.println("\n Marks after the Change. \n");
								printOut(bellCurveAdd(marks, percent), names);	// Add new percentages and print it. 

								System.out.println("\n1. Save \n2. Re-adjust Marks \nType in number of choice!");
								int answer = Integer.parseInt(userinput.nextLine().trim());

								
								if (answer == 1) {
									System.out.println();
									writeOut("student2.txt", names, marks);
									marks = readInMark(fname, marks); // reset marks to how it was before
									System.out.println("New file made, written to student2.txt");
								} else {
									marks = readInMark(fname, marks); // reset marks to how it was before
								}
							break;

							case 2:// enter decrease number
								System.out.println("Enter amount to change averages by: ");
								double percent2 = (double) Integer.parseInt(userinput.nextLine()); 

								System.out.println("\n Marks after the Change. \n");
								printOut(bellCurveSubtract(marks, percent2), names); // Subtract new percentages and print it. 

								System.out.println("\n1. Save \n2. Re-adjust Marks \nType in number of choice!");
								int answer2 = Integer.parseInt(userinput.nextLine().trim());

								if (answer2 == 1) {
									System.out.println();
									writeOut("student2.txt", names, marks);
									marks = readInMark(fname, marks); // reset marks to how it was before
									System.out.println("New file made!");
								} else {
									marks = readInMark(fname, marks); // reset marks to how it was before
								}
							break;
							case 3:// exit
								System.out.println("Exited!");
								break;
							default:
								System.out.println("Choose a valid option!");
						}
					} while (choice3 != 3);
					break;
				case 7:// Exit
					System.out.println("Exited!");
					System.exit(0);
					break;
				default:
					System.out.println("Choose a valid choice!");
					break;
			}
		} while (choice != 7);

		userinput.close(); // Scanner close
	}// end of main
}	// end of class. 
