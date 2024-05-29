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
    //Yunseo Jeon
    /*
     * randomly generate a number between 1 and 100 for each element n the array
o print the elements in a 10 X 10 table format
o find and print the largest element in the array along with the location (row,
column)
o print the first column of elements
o print the last row of elements
o calculate the sum of all the elements in the array
o search for an item and print the location it was found (row, column). State if
it was not found in the array
     */
    public static int randomNumber(int lower, int upper) {
		int answer = (int) ((Math.random() * (upper - lower)) + lower);
		return answer;
	}
    public static int[][] randomFill2DArray(int[][] array) {
		for (int r = 0; r < array.length; r++) {
            for (int c = 0; c< array[r].length; c++)
			array[r][c] = randomNumber(1, 100);
		}
		return array;
	}
    public static String[][] readIn(String filename, String[][] data) {
		String dataItem;
		try {
			BufferedReader FileInputPointer = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			//int i = 0; // index of the array
			while (FileInputPointer.ready() == true) {
                for (int r = 0; r < data.length; r++){
                    for (int c = 0; c < data[r].length;c++){
                        dataItem = FileInputPointer.readLine();
                        data[r][c] = dataItem;
                    }
                }
				dataItem = FileInputPointer.readLine(); // filter out the mark - do nothing - just advance the file pointer
				//i++;
				//System.out.println("Item read in:" + dataItem);
				
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
            for (int c = 0; c < data[r].length; c++){
                System.out.print(data[r][c] + "\t");
            }
            System.out.println();
		}
	}
	public static double totalPrecip(String[][] data){
		double sum = 0;
		for (int r = 0; r < data.length; r++){
			for (int c = 0; c < data[r].length; c++){
				sum += Double.parseDouble(data[r][c]);
			}
		}
		return sum;
	}
    public static void main(String[] args) {
        Scanner userinput = new Scanner(System.in);
		System.out.println("Please enter a filename to read?");
		String fname = userinput.nextLine();
		int SizeOfArray = CheckSize(fname);
		// System.out.println("# of items in the file: " + SizeOfArray);
        String[][] precippy = new String[SizeOfArray/5] [SizeOfArray/7];
        readIn(fname, precippy);
        printOut(precippy);

		int choice = 0;
		DecimalFormat x = new DecimalFormat("0.00");
		do {
			System.out.println("\nMenu \n1. View total precipitation for all areas \n2. View highest mark \n3. View lowest mark \n4. View class average \n5. Search (Student or Mark) \n6. Bell Curve \n7.Exit \nType in number of choice!");
			choice = Integer.parseInt(userinput.nextLine().trim());

			switch (choice) {
			case 1:

        
        userinput.close();
        
    }
   

}