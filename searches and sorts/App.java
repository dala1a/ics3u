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
	 * 
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
	 * 
	 * @Parameters: list
	 * 
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

	public static long bubbleSortTimeASC(int[] data) {
		long beforeSort, afterSort, time = 0;
		beforeSort = getTime();
		bubbleSortASC(data);
		afterSort = getTime();
		time += (afterSort - beforeSort);
		return time;
	}

	public static long bubbleSortTimeDES(int[] data) {
		long beforeSort, afterSort, time = 0;
		beforeSort = getTime();
		bubbleSortDES(data);
		afterSort = getTime();
		time += (afterSort - beforeSort);
		return time;
	}

	public static long insertionSortTimeASC(int[] data) {
		long beforeSort, afterSort, time = 0;
		beforeSort = getTime();
		insertionSortASC(data);
		afterSort = getTime();
		time += (afterSort - beforeSort);
		return time;
	}

	public static long insertionSortTimeDES(int[] data) {
		long beforeSort, afterSort, time = 0;
		beforeSort = getTime();
		insertionSortDES(data);
		afterSort = getTime();
		time += (afterSort - beforeSort);
		return time;
	}

	public static long selectionSortTimeASC(int[] data) {
		long beforeSort, afterSort, time = 0;
		beforeSort = getTime();
		selectionSortASC(data);
		afterSort = getTime();
		time += (afterSort - beforeSort);
		return time;
	}

	public static long selectionSortTimeDES(int[] data) {
		long beforeSort, afterSort, time = 0;
		beforeSort = getTime();
		selectionSortDES(data);
		afterSort = getTime();
		time += (afterSort - beforeSort);
		return time;
	}

	public static int sequentialSearch(int[] array, int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return i; /* the position where the element was found */
			}
		}
		return -1; /* return -1 if key not found in the array */
	}

	public static int binarySearch(int[] bigarray, int key) {
		int bottomindex = 0; // lowest index in array
		int topindex = bigarray.length - 1; // highest index in array
		int middleindex; // middle of bottom and top indexes
		boolean found = false; // true if key was found
		while ((bottomindex <= topindex) && (found == false)) {
			middleindex = (int) (bottomindex + topindex) / 2;
			if (bigarray[middleindex] == key) {
				found = true;
				return middleindex;
			} // end if
			else {
				if (bigarray[middleindex] < key) {
					bottomindex = middleindex + 1;
				} // end if
				else {
					topindex = middleindex - 1;
				} // end else
			} // end else
		} // end while
		return -1;
	} // end binarySearch

	public static long sequentialSearchTime(int[] data, int num) {
		long beforeSearch, afterSearch, time = 0;
		beforeSearch = getTime();
		sequentialSearch(data, num);
		afterSearch = getTime();
		time += (afterSearch - beforeSearch);
		return time;
	}

	public static long binarySearchTime(int[] data, int num) {
		long beforeSearch, afterSearch, time = 0;
		beforeSearch = getTime();
		binarySearch(data, num);
		afterSearch = getTime();
		time += (afterSearch - beforeSearch);
		return time;
	}

	public static void main(String[] args) {
		int SizeOfArray = 100000;// CHANGE To 100000
		int[] A1 = new int[SizeOfArray];// bubble sort 1
		int[] A2 = new int[SizeOfArray];// bubble sort 2
		int[] A3 = new int[SizeOfArray];// bubble sort 3

		int[] B1 = new int[SizeOfArray];// insertion sort 1
		int[] B2 = new int[SizeOfArray];// insertion sort 2
		int[] B3 = new int[SizeOfArray];// insertion sort 3

		int[] C1 = new int[SizeOfArray];// selection sort 1
		int[] C2 = new int[SizeOfArray];// selection sort 2
		int[] C3 = new int[SizeOfArray];// selection sort 3

		int[] searchArray = new int[SizeOfArray];
		int key = 0;

		randomFillArray(A1, SizeOfArray);
		randomFillArray(A2, SizeOfArray);
		randomFillArray(A3, SizeOfArray);

		copyArray(A1, B1);
		copyArray(A2, B2);
		copyArray(A3, B3);

		copyArray(A1, C1);
		copyArray(A2, C2);
		copyArray(A3, C3);

		// Sorting random
		System.out.println("********************RANDOM********************");
		long bubbleTime = bubbleSortTimeASC(A1) + bubbleSortTimeASC(A2) +
		bubbleSortTimeASC(A3);
		System.out.println("Average (Bubble, random): " + bubbleTime / 3);
		long insertionTime = insertionSortTimeASC(B1) + insertionSortTimeASC(B2) +
		insertionSortTimeASC(B3);
		System.out.println("Average (Insertion, random): " + insertionTime / 3);
		long selectionTime = selectionSortTimeASC(C1) + selectionSortTimeASC(C2) +
		selectionSortTimeASC(C3);
		System.out.println("Average (Selection, random): " + selectionTime / 3);

		// Sorting one out of place
		A1[randomNumber(1, SizeOfArray)] = SizeOfArray + 69;
		A2[randomNumber(1, SizeOfArray)] = SizeOfArray + 69;
		A3[randomNumber(1, SizeOfArray)] = SizeOfArray + 69;

		copyArray(A1, B1);
		copyArray(A2, B2);
		copyArray(A3, B3);

		copyArray(A1, C1);
		copyArray(A2, C2);
		copyArray(A3, C3);
		System.out.println("\n********************ONE OUT OF PLACE********************");
		bubbleTime = bubbleSortTimeASC(A1) + bubbleSortTimeASC(A2) +
		bubbleSortTimeASC(A3);
		System.out.println("Average (Bubble, one out of place): " + bubbleTime / 3);
		insertionTime = insertionSortTimeASC(B1) + insertionSortTimeASC(B2) +
		insertionSortTimeASC(B3);
		System.out.println("Average (Insertion, one out of place): " + insertionTime
		/ 3);
		selectionTime = selectionSortTimeASC(C1) + selectionSortTimeASC(C2) +
		selectionSortTimeASC(C3);
		System.out.println("Average (Selection, one out of place): " + selectionTime
		/ 3);

		// Reverse
		System.out.println("\n********************REVERSE********************");
		bubbleTime = bubbleSortTimeDES(A1) + bubbleSortTimeDES(A2) +
		bubbleSortTimeDES(A3);
		System.out.println("Average (Bubble, Reverse): " + bubbleTime / 3);
		insertionTime = insertionSortTimeDES(B1) + insertionSortTimeDES(B2) +
		insertionSortTimeDES(B3);
		System.out.println("Average (Insertion, Reverse): " + insertionTime / 3);
		selectionTime = selectionSortTimeDES(C1) + selectionSortTimeDES(C2) +
		selectionSortTimeDES(C3);
		System.out.println("Average (Selection, Reverse): " + selectionTime / 3);

		// Report
		System.out.println("\n********************REPORT********************");
		System.out.println("When the data is randomly filled, Insertion Sort has the fastest sorting time, outperforming both Selection Sort and Bubble Sort. When only one element is out of place, Bubble Sort demonstrates superior efficiency, making it the fastest in this scenario. For data in reverse order, Insertion Sort again proves to be the most efficient, surpassing the performance of both Bubble Sort and Selection Sort. These results highlight Insertion Sort's general efficiency across various conditions, while Bubble Sort excels when minimal sorting is required.");

		// Initializing Sequential Sort
		randomFillArray(searchArray, SizeOfArray);
		insertionSortASC(searchArray);

		// Best case Sequential
		key = searchArray[0];
		System.out.println("\n********************BEST CASE********************");
		System.out.println("Sequential: " + sequentialSearchTime(searchArray, key));

		// Best case Binary
		key = searchArray[(searchArray.length - 1) / 2];
		System.out.println("Binary: " + binarySearchTime(searchArray, key));

		// Worst case Sequential
		key = searchArray[searchArray.length - 1] + 1;
		System.out.println("\n********************WORST CASE********************");
		System.out.println("Sequential: " + sequentialSearchTime(searchArray, key));

		// Worst case Binary
		System.out.println("Binary: " + binarySearchTime(searchArray, key));

		// Worst case Sequential
		key = searchArray[randomNumber(0, searchArray.length-1)];
		System.out.println("\n********************AVERAGE CASE********************");
		System.out.println("Sequential: " + sequentialSearchTime(searchArray, key));

		// Worst case Binary
		System.out.println("Binary: " + binarySearchTime(searchArray, key));

		//Report
		System.out.println("The data compares the performance of Sequential Search and Binary Search under different conditions. In the best case scenario, Sequential Search is slightly faster compared to Binary Search. However, in the worst case scenario, Binary Search significantly outperforms Sequential Search. For the average case, Binary Search is again much more efficient, while Sequential Search takes longer. These findings highlight Binary Search's superior efficiency, especially in the worst and average cases, while Sequential Search only has a slight advantage in the best case scenario. Since sequential search goes through all elements, which means it does a lot more comparisons than binary search. It takes more time, therefore being the worse search.");
	}
}
