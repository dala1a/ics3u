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
		double largest = 0;
            for (int r = 1; r < data.length; r++) {
                if (data[r][0].equalsIgnoreCase(month)) {
                    for (int c = 1; c < data[r].length-1; c++) {
                        if (Double.parseDouble(data[r][c]) < Double.parseDouble(data[r][c+1])) {
                            largest = Double.parseDouble(data[r][c]);
                        
                    }
				}
			}
		}
        return largest;
	}
    
    public static void main(String[] args) {
        Scanner userinput = new Scanner(System.in);
        System.out.println("Please enter a filename to read?");
        String fname = userinput.nextLine();
        int SizeOfArray = CheckSize(fname);
        System.out.println("# of items in the file: " + SizeOfArray);
        String[][] precippy = new String[SizeOfArray / 5][SizeOfArray / 7];
        readIn(fname, precippy);
        printOut(precippy);
        int choice1 = 0;
        String choice2 = "";
        DecimalFormat x = new DecimalFormat("0.0");
        do {
            System.out.println("\nMenu \n1. View total precipitation for all areas \n2. Find the largest precipitation for a month \n3. Find the smallest precipitation for a given month \n7.Exit \nType in number of choice!");
            choice1 = Integer.parseInt(userinput.nextLine().trim());
            

            switch (choice1) {
                case 1: //view total
                    System.out.println("\nTotal precipitation for all areas: " + x.format(totalPrecip(precippy)));
                    break;
                case 2: //highest
                    System.out.println("\nInput a month: ");
                    choice2 = userinput.nextLine().trim();
                    System.out.println("\n" + choice2 + "'s highest precipitation was: " + largestPrecip(precippy, choice2));
                    break;
                case 3: //lowest
                    System.out.println("Input a month: ");
                    choice2 = userinput.nextLine().trim();
                    System.out.println("\n" + choice2 + "'s smallest precipitation was: " + smallestPrecip(precippy, choice2));
                    break;
                }
        } while (choice1 != 7);

        userinput.close();
    }
}
