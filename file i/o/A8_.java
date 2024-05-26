import java.util.Scanner;
import java.io.*; // Contains commands to read in a file
import java.text.DecimalFormat;

public class A8_ {

	/*
	 * Method Name: CheckSize Author: Kyle McKay Creation Date; Nov 15 2023 Modified
	 * Date: Nov 15 2023 Description: Peeks at the size of the array
	 * 
	 * @Parameters: A integer array
	 * 
	 * @Return Value: Returns the number of lines in a file Data Type: integer ARRAY
	 * Dependencies: n/a Throws/Exceptions: File IO errors
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
		} catch (IOException e) {
			System.out.println("Error" + e.toString());
		}

		return NumberOfItems;
	}

	/*
	 * Method Name: readIn Author: Kyle McKay Creation Date; Nov 15 2023 Modified
	 * Date: Nov 15 2023 Description: Reads line by line the integers in a file
	 * places in an array
	 * 
	 * @Parameters: A integer array, and file name as a string
	 * 
	 * @Return Value: Returns the filled in array Data Type: integer ARRAY
	 * Dependencies: n/a Throws/Exceptions: File IO exceptions
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

				//System.out.println("Item read in:" + dataItem);
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

	public static double[] readInMark(String filename, double[] mark) {
		String Holder;
		try {
			BufferedReader FileInputPointer = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			int i = 0; // index of the array
			while (FileInputPointer.ready() == true) {
				Holder = FileInputPointer.readLine().toString(); // double mark number
				mark[i] = Double.parseDouble(Holder);
				i += 1;
				Holder = FileInputPointer.readLine().toString(); // Student name filter it out just advance the file pointer
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
	 * Method Name: writeOut Author: Kyle McKay Creation Date; Nov 15 2023 Modified
	 * Date: Nov 15 2023 Description: Creates a file of the integer array
	 * 
	 * @Parameters: A integer array and the file name as a string.
	 * 
	 * @Return Value: None its a procedure Data Type: integer ARRAY Dependencies:
	 * n/a Throws/Exceptions: File IO exceptions
	 */
	public static void writeOut(String filename, int[] Array) {
		try {
			PrintWriter outputfile = new PrintWriter(new BufferedWriter(new FileWriter(filename)));

			for (int i = 0; i < Array.length; i++) {
				outputfile.println(Array[i]);
			}

			outputfile.close();

		} catch (Exception e) {
			System.out.println("My Application Error: " + e.toString());
		}

	}

	/*
	 * Method Name: printOut Author: Kyle McKay Creation Date; Nov 15 2023 Modified
	 * Date: Nov 15 2023 Description: To output a integer array to console
	 * 
	 * @Parameters: A integer array
	 * 
	 * @Return Value: None its a procedure Data Type: integer ARRAY Dependencies:
	 * n/a Throws/Exceptions: n/a
	 */
	public static void printOut(double[] TheArray, String[] array) {
		for (int i = 0; i < TheArray.length; i++) {
			System.out.println(array[i] + " has a mark of " + TheArray[i] + "%");
		}
	}

	public static double highestMark(String[] array, double[] thearray) {
		double value = 0.0; 
		String name = "";
		for (int i = 1; i < thearray.length; i++) {
			if (thearray[i] > thearray[i-1]) {
				value = thearray[i];
				name = array[i];
			}
		}
		System.out.println(name);
		return value;
	}
	public static double lowestMark(String[] array, double[] thearray) {
		double value = 0.0; 
		String name = "";
		for (int i = 1; i < thearray.length; i++) {
			if (thearray[i] < thearray[i-1]) {
				value = thearray[i];
				name = array[i];
			}
		}
		System.out.println(name);
		return value;
	}
	public static double average(double[] theArray) {
		double value = 0.0; 
		for (int i = 0; i < theArray.length; i++) {
			value+=theArray[i];
		}
		return value/theArray.length;
	}
	public static double studentToMark(String[] a1, double[] a2, String name) {
		double value = 0.0; 
		for (int i = 0; i < a1.length; i++) {
			if (a1[i].equals(name)){
				value = a2[i];
			}
		}
		if (value == 0.0){
			System.out.println("This student is not on file! Defaulted to 0%");
		}
		return value;
	}
	public static String markToStudent(String[] a1, double[] a2, double mark) {
		String name = null; 
		for (int i = 0; i < a2.length; i++) {
			if (a2[i] == mark){
				name = a1[i];
			}
		}
		if (name.equals(null)){
			System.out.println("This mark doesn't belong to any student!");
		}
		return name;
	}
	public static double[] bellCurve(double[] a, double input) {
		for (int i = 0; i < a.length; i++) {
			a[i]+= 1 + input/100;
		}
		return a;
	}
	public static void main(String[] args) {
		Scanner userinput = new Scanner(System.in);
		System.out.println("Please enter a filename to read?");
		String fname = userinput.nextLine();
		int SizeOfArray = CheckSize(fname);
		System.out.println("# of items in the file: " + SizeOfArray);
		double[] marks = new double[SizeOfArray / 2];
		String[] names = new String[SizeOfArray / 2];
		int choice = 0; // User's choice in menu
		int choice2=0; //User's choice in Search (Student or Mark) menu
		int choice3=0;//User's choice in bell curve menu
		names = readIn(fname, names);
		marks = readInMark(fname, marks);
		DecimalFormat x = new DecimalFormat("0.00");
		do {
			System.out.println("\nMenu \n1. View student marks \n2. View highest mark \n3. View lowest mark \n4. View class average \n5. Search (Student or Mark) \n6. Bell Curve \n7.Exit \nType in number of choice!");
			choice = Integer.parseInt(userinput.nextLine().trim());

			switch (choice) {
			case 1:
				printOut(marks, names);
				break;
			case 2:
				System.out.println("\nStudent with the highest mark: ");
				System.out.println(highestMark(names,marks) + "%");
				break;
			case 3://View lowest mark
				System.out.println("\nStudent with the lowest mark: ");
				System.out.println(lowestMark(names,marks) + "%");
				break;
			case 4://View class average
				System.out.println("\nClass Average: ");
				System.out.println(x.format(average(marks)) + "%");
				break;
			case 5://Search (Student or Mark)
				do {
					System.out.println("\nSubmenu \n1. Search Student \n2. Search Mark \n3. Exit \nType in number of choice!");
					choice2 = Integer.parseInt(userinput.nextLine().trim());
					switch (choice2) {
						case 1://search student
						String name = userinput.nextLine();
						System.out.println(name + " has a mark of " + studentToMark(names,marks,name) + "%");
						break;
						case 2://search student
						double mark = Double.parseDouble(userinput.nextLine().trim());
						System.out.println(markToStudent(names,marks,mark) + " has a mark of " + mark + "%");
						break;
						case 3://exit
						System.out.println("Exited!");
						break;
						default:
						System.out.println("Choose a valid option!");
					}
				}while(choice2 != 3);
			case 6://Bell Curve
			do {
				System.out.println("\nSubmenu \n1. Enter value to change the averages by \n2. Search Mark \n3. Exit \nType in number of choice!");
				choice3 = Integer.parseInt(userinput.nextLine().trim());
				switch (choice3) {
					case 1://enter increase or decrease number
					System.out.println("Enter amount to change averages by: ");
					double percent = Double.parseDouble(userinput.nextLine());
					System.out.println("Would you like to save new grades or just view? (Save or View)");
					String answer = userinput.nextLine().toLowerCase().trim();
					if (answer == "save"){
						marks = bellCurve(marks,percent);
						printOut(marks,names);
						System.out.println("New Average: " + average(marks) + "%");
					}
					else{
						printOut(bellCurve(marks,percent),names);
						printOut(marks,names);
					}
					
					break;
					case 2://search student
					double mark = Double.parseDouble(userinput.nextLine().trim());
					System.out.println(markToStudent(names,marks,mark) + " has a mark of " + mark + "%");
					break;
					case 3://exit
					System.out.println("Exited!");
					break;
					default:
					System.out.println("Choose a valid option!");
				}
			}while(choice2 != 3);
			case 7://Exit
				System.out.println("Exited!");
				break;
			default:
				System.out.println("Choose a valid choice!");
				break;
			}
		} while (choice != 7);

		System.out.println("Please enter a filename to write?");
		//String fname2 = userinput.nextLine();
		//writeOut(fname2, ArrayOfFile);

		userinput.close();
	}// end of main
}