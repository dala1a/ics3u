public class App {
	/*
	 * Method Name: randomNumber Author: K. McKay Creation Date; April 10, 2024
	 * Description: generate random number between two values
	 * 
	 * @Parameters: high number and low number
	 * 
	 * @Return Value: integer Data Type: integer Throws/Exceptions: n/a
	 */
	public static int randomNumber(int lower, int upper) {
		int answer = (int) ((Math.random() * (upper - lower)) + lower);
		return answer;
	}

	/*
	 * Method Name: randomFillArray Author: Yunseo Jeon Creation Date; April 23,
	 * 2024 Description: fills array with random values
	 * yeehaw
	 * @Parameters: list
	 * 
	 * @Return Value: array Data Type: array Dependencies: n/a Throws/Exceptions:
	 * n/a
	 */
	public static int[] randomFillArray(int[] list, int upper) {
		for (int i = 0; i < list.length; i++) {
			list[i] = randomNumber(1, upper);
		}
		return list;
	}

	public static long getTime() {
		long tick = System.nanoTime();
		return tick;
		// long beforeSort = getTime();
		// long afterSort = getTime(); //afterSort time in milliseconds
		// long time = (afterSort ‐ beforeSort) / 1000000000;
	}

	/*
	 * Method Name: printArray 
     * Author: Yunseo Jeon 
     * Creation Date; April 23, 2024
	 * Description: prints values of array
	 * @Parameters: list
	 * @Return Value: array 
     * Data Type: array Dependencies: n/a 
     * Throws/Exceptions:
	 * n/a
	 */
	public static void printArray(int[] list, int columns) {
		for (int i = 0; i < list.length; i += columns) {
			for (int j = 0; j < columns; j++) {
				System.out.print(list[i + j] + "\t");
			}
			System.out.print("\n");
		}
		// pressAnyKeyToContinue();
	}

	public static int[] copyArray(int[] A, int[] B) {
		for (int i = 0; i < A.length; i++) {
			B[i] = A[i];
		}
		return B;
	}

	public static void bubbleSortASC(int data[]) {
		int tmp;
		int j = 0;
		boolean sorted = false;
		while ((!sorted) && (j < data.length)) {
			sorted = true;
			for (int i = 0; i < data.length - 1; i++)
				if (data[i] > data[i + 1]) {
					sorted = false;
					tmp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = tmp;
				} // end if
		} // end while
	}// end bubbleSort
    public static void bubbleSortDES(int data[]) {
		int tmp;
		int j = 0;
		boolean sorted = false;
		while ((!sorted) && (j < data.length)) {
			sorted = true;
			for (int i = 0; i < data.length - 1; i++)
				if (data[i] < data[i + 1]) {
					sorted = false;
					tmp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = tmp;
				} // end if
		} // end while
	}// end bubbleSort

	public static void insertionSortASC(int data[]) {
		int tmp;
		int i, j;
		for (j = 0; j < data.length; j++) {
			i = j - 1;
			tmp = data[j];
			while ((i >= 0) && (tmp < data[i])) {
				data[i + 1] = data[i];
				i--;
			}
			data[i + 1] = tmp;
		}
	}
    public static void insertionSortDES(int data[]) {
		int tmp;
		int i, j;
		for (j = 0; j < data.length; j++) {
			i = j - 1;
			tmp = data[j];
			while ((i >= 0) && (tmp > data[i])) {
				data[i + 1] = data[i];
				i--;
			}
			data[i + 1] = tmp;
		}
	}

	public static void selectionSortASC(int[] intArray) {
		for (int i = intArray.length - 1; i > 0; i--) {
			int maxLoc = 0; // Location of largest item seen so far.
			for (int j = 1; j <= i; j++) {
				if (intArray[j] > intArray[maxLoc]) {
					maxLoc = j;
				}
			}
			int temp = intArray[maxLoc]; // Swap largest item with intArray[i].
			intArray[maxLoc] = intArray[i];
			intArray[i] = temp;
		} // end of for loop
	} // end selectSort

    public static void selectionSortDES(int[] intArray) {
		for (int i = intArray.length - 1; i > 0; i--) {
			int maxLoc = 0; // Location of largest item seen so far.
			for (int j = 1; j <= i; j++) {
				if (intArray[j] < intArray[maxLoc]) {
					maxLoc = j;
				}
			}
			int temp = intArray[maxLoc]; // Swap largest item with intArray[i].
			intArray[maxLoc] = intArray[i];
			intArray[i] = temp;
		} // end of for loop
	} // end selectSort

public static long bubbleSortTimeASC(int[] data){
	long beforeSort, afterSort, time = 0;
		beforeSort = getTime();
		bubbleSortASC(data);
		afterSort = getTime();
		time += (afterSort - beforeSort) ;
		System.out.print(time + " ");
		return time;
}

public static long bubbleSortTimeDES(int[] data){
	long beforeSort, afterSort, time = 0;
		beforeSort = getTime();
		bubbleSortDES(data);
		afterSort = getTime();
		time += (afterSort - beforeSort) ;
		System.out.print(time + " ");
		return time;
}

public static long insertionSortTimeASC(int[] data){
	long beforeSort, afterSort, time = 0;
		beforeSort = getTime();
		insertionSortASC(data);
		afterSort = getTime();
		time += (afterSort - beforeSort);
		System.out.print(time + " ");
		return time;
}
public static long insertionSortTimeDES(int[] data){
	long beforeSort, afterSort, time = 0;
		beforeSort = getTime();
		insertionSortDES(data);
		afterSort = getTime();
		time += (afterSort - beforeSort);
		System.out.print(time + " ");
		return time;
}
public static long selectionSortTimeASC(int[] data){
	long beforeSort, afterSort, time = 0;
		beforeSort = getTime();
		selectionSortASC(data);
		afterSort = getTime();
		time += (afterSort - beforeSort) ;
		System.out.print(time + " ");
		return time;
}
public static long selectionSortTimeDES(int[] data){
	long beforeSort, afterSort, time = 0;
		beforeSort = getTime();
		selectionSortDES(data);
		afterSort = getTime();
		time += (afterSort - beforeSort) ;
		System.out.print(time + " ");
		return time;
}

	public static void main(String[] args) {
		int SizeOfArray = 50;// CHANGE To 100000
		int[] A1 = new int[SizeOfArray];// bubble sort 1
		int[] A2 = new int[SizeOfArray];// bubble sort 2
		int[] A3 = new int[SizeOfArray];// bubble sort 3

		int[] B1 = new int[SizeOfArray];// insertion sort 1
		int[] B2 = new int[SizeOfArray];// insertion sort 2
		int[] B3 = new int[SizeOfArray];// insertion sort 3

		int[] C1 = new int[SizeOfArray];// selection sort 1
		int[] C2 = new int[SizeOfArray];// selection sort 2
		int[] C3 = new int[SizeOfArray];// selection sort 3
	
		randomFillArray(A1, 30000);
		randomFillArray(A2, 30000);
		randomFillArray(A3, 30000);

		copyArray(A1, B1);
		copyArray(A2, B2);
		copyArray(A3, B3);

		copyArray(A1, C1);
		copyArray(A2, C2);   
		copyArray(A3, C3);
        
        //Sorting random
        System.out.println("********************RANDOM********************");
		long bubbleTime = bubbleSortTimeASC(A1) + bubbleSortTimeASC(A2) + bubbleSortTimeASC(A3);
		System.out.println("Average (Bubble, random): "+ bubbleTime/3);
		long insertionTime = insertionSortTimeASC(B1) + insertionSortTimeASC(B2) + insertionSortTimeASC(B3);
		System.out.println("Average (Insertion, random): "+ insertionTime/ 3);
		long selectionTime = selectionSortTimeASC(C1) + selectionSortTimeASC(C2) + selectionSortTimeASC(C3);
		System.out.println("Average (Selection, random): "+ selectionTime/3);
        
        //Sorting one out of place
        A1[randomNumber(1,SizeOfArray)] = SizeOfArray+69;
        A2[randomNumber(1,SizeOfArray)] = SizeOfArray+69;
        A3[randomNumber(1,SizeOfArray)] = SizeOfArray+69;
        
        copyArray(A1, B1);
		copyArray(A2, B2);
		copyArray(A3, B3);

		copyArray(A1, C1);
		copyArray(A2, C2);   
		copyArray(A3, C3);
        System.out.println("\n********************ONE OUT OF PLACE********************");
        bubbleTime = bubbleSortTimeASC(A1) + bubbleSortTimeASC(A2) + bubbleSortTimeASC(A3);
		System.out.println("Average (Bubble, one out of place): "+ bubbleTime/3);
		insertionTime = insertionSortTimeASC(B1) + insertionSortTimeASC(B2) + insertionSortTimeASC(B3);
		System.out.println("Average (Insertion, one out of place): "+ insertionTime/ 3);
        selectionTime = selectionSortTimeASC(C1) + selectionSortTimeASC(C2) + selectionSortTimeASC(C3);
		System.out.println("Average (Selection, one out of place): "+ selectionTime/3);
    

        //Reverse
        System.out.println("\n********************REVERSE********************");
        bubbleTime = bubbleSortTimeDES(A1) + bubbleSortTimeDES(A2) + bubbleSortTimeDES(A3);
		System.out.println("Average (Bubble, Reverse): "+ bubbleTime/3);
		insertionTime = insertionSortTimeDES(B1) + insertionSortTimeDES(B2) + insertionSortTimeDES(B3);
		System.out.println("Average (Insertion, Reverse): "+ insertionTime/ 3);
        selectionTime = selectionSortTimeDES(C1) + selectionSortTimeDES(C2) + selectionSortTimeDES(C3);
		System.out.println("Average (Selection, Reverse): "+ selectionTime/3);

        //Report 
        System.out.println("\n********************REPORT********************");
        System.out.println("When sorting, an Insertion sort is usually best, as it becomes more efficient \nin comparison to other sorts as the size of the data set increases. Selection \nsort was the second fastest sort for sorting a completely random data set, \nyet when only one element was out of place, it was extremely inefficient. The \nBubble sort took the longest for sorting a random data set that had yet to be \nsorted but was much more efficient than....");
	}

}
