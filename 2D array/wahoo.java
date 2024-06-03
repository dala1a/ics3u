import java.io.*; // Contains commands to read in a file
import java.text.DecimalFormat;
import java.util.Scanner;

public class wahoo {
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
	public static void writeOut(String filename, String[][] data) {
		try {
			PrintWriter outputfile = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			for (int r = 0; r < data.length; r++) {
                for (int c = 0; c < data[r].length; c++) {
                    outputfile.println(data[r][c]);
                }}
			outputfile.close();
		} catch (Exception e) {
			System.out.println("My Application Error: " + e.toString());
		}

	}
    public static int randomNumber(int lower, int upper) {
        int answer = (int) ((Math.random() * (upper - lower)) + lower);
        return answer;
    }

    public static int[][] randomFill2DArray(int[][] array) {
        for (int r = 0; r < array.length; r++) {
            for (int c = 0; c < array[r].length; c++)
                array[r][c] = randomNumber(1, 100);
        }
        return array;
    }

    public static String[][] readIn(String filename, String[][] data) {
        String dataItem;
        try {
            BufferedReader FileInputPointer = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            while (FileInputPointer.ready() == true) {
                for (int r = 0; r < data.length; r++) {
                    for (int c = 0; c < data[r].length; c++) {
                        dataItem = FileInputPointer.readLine();
                        data[r][c] = dataItem;
                    }
                }
            }
            FileInputPointer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error - this file does not exist");
        } catch (IOException e) {
            System.out.println("Error" + e.toString());
        }
        return data;
    }

    public static void printOut(String[][] data) {
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                System.out.print(data[r][c] + "\t");
            }
            System.out.println();
        }
    }

    public static double totalPrecip(String[][] data) {
        double sum = 0;
        for (int r = 1; r < data.length; r++) {
            for (int c = 1; c < data[r].length; c++) {
                sum += Double.parseDouble(data[r][c]);
            }
        }
        return sum;
    }

	public static double largestPrecip (String[][] data, String month){
		double largest = 0;
            for (int r = 1; r < data.length; r++) {
                if (data[r][0].equalsIgnoreCase(month)) {
                    for (int c = 1; c < data[r].length-1; c++) {
                        if (Double.parseDouble(data[r][c]) > Double.parseDouble(data[r][c+1])) {
                            largest = Double.parseDouble(data[r][c]);
                        
                    }
				}
			}
		}
        return largest;
	}

    public static double smallestPrecip (String[][] data, String month){
		double smallest = 0;
            for (int r = 1; r < data.length; r++) {
                if (data[r][0].equalsIgnoreCase(month)) {
                    for (int c = 1; c < data[r].length-1; c++) {
                        if (Double.parseDouble(data[r][c]) < Double.parseDouble(data[r][c+1])) {
                            smallest = Double.parseDouble(data[r][c]);
                        
                    }
				}
			}
		}
        return smallest;
	}

    public static double averageDirection (String[][] data, String direction){
		double average = 0;
            for (int r = 0; r < data[0].length; r++) {
                if (data[0][r].equalsIgnoreCase(direction)) {
                for (int c = 1; c < data.length; c++) {
                    average += Double.parseDouble(data[c][r]);
				}
			}
		}
        return average/(data.length-1);
	}
    public static double averageMonth (String[][] data, String month){
		double average = 0;
            for (int r = 1; r < data.length; r++) {
                if (data[r][0].equalsIgnoreCase(month)) {
                for (int c = 1; c < data[r].length; c++) {
                    average += Double.parseDouble(data[r][c]);
				}
			}
		}
        return average/(data[1].length-1);
	}

    public static void main(String[] args) {
        Scanner userinput = new Scanner(System.in);
        System.out.println("Please enter a filename to read?");
        String fname = userinput.nextLine();
        int SizeOfArray = CheckSize(fname);
        System.out.println("# of items in the file: " + SizeOfArray);
        String[][] precippy = new String[SizeOfArray / 5][SizeOfArray / 7];
        readIn(fname, precippy);
        int choice = 0;                //choice for the main menu
        String stringChoice = "";    //choice for menu 1
        
        DecimalFormat x = new DecimalFormat("0.0");
        do {
            System.out.println("\nMenu \n1. View total precipitation for all areas \n2. Find the largest precipitation for a month \n3. Find the smallest precipitation for a given month \n4. Find average precipitation for the direction \n5. Find average precipitation for specified month \n6. Print data in table format \n7. Write out to file: stats.txt \n8.Exit \nType in number of choice!");
            choice = Integer.parseInt(userinput.nextLine().trim());
            

            switch (choice) {
                case 1: //view total
                    System.out.println("\nTotal precipitation for all areas: " + x.format(totalPrecip(precippy)));
                    break;
                case 2: //highest
                    System.out.println("\nInput a month: ");
                    stringChoice = userinput.nextLine().trim();
                    System.out.println("\n" + stringChoice + "'s highest precipitation was: " + largestPrecip(precippy, stringChoice));
                    break;
                case 3: //lowest
                    System.out.println("Input a month: ");
                    stringChoice = userinput.nextLine().trim();
                    System.out.println("\n" + stringChoice + "'s smallest precipitation was: " + smallestPrecip(precippy, stringChoice));
                    break;
                case 4: //Find and print to the screen the average precipitation for the direction provided by user
                    System.out.println("Input a direction: ");
                    stringChoice = userinput.nextLine().trim();
                    System.out.println("\n" + stringChoice + "'s average precipitation was: " + averageDirection(precippy, stringChoice));
                    break;
                case 5: //average precipitation for user specified month
                    System.out.println("Input a month: ");
                    stringChoice = userinput.nextLine().trim();
                    System.out.println("\n" + stringChoice + "'s average precipitation was: " + averageMonth(precippy, stringChoice));
                    break;
                case 6: //print out table
                    printOut(precippy);
                    break;
                case 7: //write out
                    writeOut("stats.txt", precippy);
                    System.out.println("Written out to file: stats.txt");
                    break;
                }
        } while (choice != 8);

        userinput.close();
    }
}
