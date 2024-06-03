public class App {

	/*
	 * Method Name: randomNumber 
	 * Author: K. McKay 
	 * Creation Date; April 10, 2024
	 * Description: generate random number between two values
	 * @Parameters: high number and low number
	 * @Return Value: integer 
	 * Data Type: integer
	 * Throws/Exceptions: n/a
	 */
	public static int randomNumber(int lower, int upper) {
		int answer = (int) ((Math.random() * (upper - lower)) + lower);
		return answer;
	}

	/*
	 * Method Name: randomFillArray 
	 * Author: Yunseo Jeon Creation Date; April 23,
	 * 2024 Description: fills array with random values
	 * @Parameters: list and upper number 
	 * @Return Value: array 
	 * Data Type: array 
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	 */
	public static int[] randomFillArray(int[] list, int upper) {
		for (int i = 0; i < list.length; i++) {
			list[i] = randomNumber(1, upper);
		}
		return list;
	}

	/*
	 * Method Name: getTIme 
	 * Author: Yunseo Jeon 
	 * Creation Date: April 23, 2024 
	 * Description: returns the time in nanoseconds
	 * @Parameters: n/a 
	 * @Return Value: long 
	 * Data Type: long 
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	 */
	public static long getTime() {
		long tick = System.nanoTime();
		return tick;
	}

	/*
	 * Method Name: printArray
	 * Author: Yunseo Jeon
	 * Creation Date: April 23, 2024
	 * Description: prints values of array
	 * @Parameters: list, columns
	 * @Return Value: n/a
	 * Data Type: n/a 
	 * Dependencies: n/a
	 * Throws/Exceptions: n/a
	 */
	public static void printArray(int[] list, int columns) {
		for (int i = 0; i < list.length; i += columns) {
			for (int j = 0; j < columns; j++) {
				System.out.print(list[i + j] + "\t");
			}
			System.out.print("\n");
		}
	}

	/*
	 * Method Name: copyArray 
	 * Author: Yunseo Jeon 
	 * Creation Date: May 25, 2024
	 * Description: copies the elements in one array into another. 
	 * @Parameters: A - The Array being copied, B - The array being rewritten
	 * @Return Value: int array 
	 * Data Type: int[] 
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
	public static int[] copyArray(int[] A, int[] B) {
		for (int i = 0; i < A.length; i++) {
			B[i] = A[i];
		}
		return B;
	}

	/*
	 * Method Name: bubbleSortASC 
	 * Author: K. McKay
	 * Creation Date: April 10, 2024
	 * Description: Sorts an int array in ascending order using bubble sort.  
	 * @Parameters: data - The int array getting sorted
	 * @Return Value: n/a 
	 * Data Type: void
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
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

	/*
	 * Method Name: bubbleSortASC 
	 * Author: K. McKay
	 * Creation Date: April 10, 2024
	 * Description: Sorts an int array in descending order using bubble sort.  
	 * @Parameters: data - The int array getting sorted
	 * @Return Value: n/a 
	 * Data Type: void
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
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

	/*
	 * Method Name: insertionSortASC 
	 * Author: K. McKay
	 * Creation Date: April 10, 2024
	 * Description: Sorts an int array in ascending order using insertion sort.  
	 * @Parameters: data - The int array getting sorted
	 * @Return Value: n/a 
	 * Data Type: void
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
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

	/*
	 * Method Name: insertionSortDES 
	 * Author: K. McKay
	 * Creation Date: April 10, 2024
	 * Description: Sorts an int array in descending order using insertion sort.  
	 * @Parameters: data - The int array getting sorted
	 * @Return Value: n/a 
	 * Data Type: void
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
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

	/*
	 * Method Name: selectionSortASC 
	 * Author: K. McKay
	 * Creation Date: April 10, 2024
	 * Description: Sorts an int array in ascending order using selection sort.  
	 * @Parameters: data - The int array getting sorted
	 * @Return Value: n/a 
	 * Data Type: void
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
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

	/*
	 * Method Name: selectionSortDES 
	 * Author: K. McKay
	 * Creation Date: April 10, 2024
	 * Description: Sorts an int array in descending order using selection sort.  
	 * @Parameters: data - The int array getting sorted
	 * @Return Value: n/a 
	 * Data Type: void
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
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

	/*
	 * Method Name: bubbleSortTimeASC 
	 * Author: Yunseo Jeon
	 * Creation Date: April 10, 2024
	 * Description: Times an array being sorted in ascneding order using bubble sort before and after and then returns the final time in nanoseconds.  
	 * @Parameters: data - The int array getting sorted
	 * @Return Value: long - The final time after the array has been sorted
	 * Data Type: long
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
	public static long bubbleSortTimeASC(int[] data) {
		long beforeSort, afterSort, time = 0;
		beforeSort = getTime();
		bubbleSortASC(data);
		afterSort = getTime();
		time += (afterSort - beforeSort);
		return time;
	}

	/*
	 * Method Name: bubbleSortTimeDES 
	 * Author: Yunseo Jeon
	 * Creation Date: April 10, 2024
	 * Description: Times an array being sorted in descending order using bubble sort before and after and then returns the final time in nanoseconds.  
	 * @Parameters: data - The int array getting sorted
	 * @Return Value: long - The final time after the array has been sorted
	 * Data Type: long
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
	public static long bubbleSortTimeDES(int[] data) {
		long beforeSort, afterSort, time = 0;
		beforeSort = getTime();
		bubbleSortDES(data);
		afterSort = getTime();
		time += (afterSort - beforeSort);
		return time;
	}
	
	/*
	 * Method Name: insertionSortTimeASC 
	 * Author: Yunseo Jeon
	 * Creation Date: April 10, 2024
	 * Description: Times an array being sorted in ascending order using insertion sort before and after and then returns the final time in nanoseconds.  
	 * @Parameters: data - The int array getting sorted
	 * @Return Value: long - The final time after the array has been sorted
	 * Data Type: long
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
	public static long insertionSortTimeASC(int[] data) {
		long beforeSort, afterSort, time = 0;
		beforeSort = getTime();
		insertionSortASC(data);
		afterSort = getTime();
		time += (afterSort - beforeSort);
		return time;
	}

	/*
	 * Method Name: insertionSortTimeDES 
	 * Author: Yunseo Jeon
	 * Creation Date: April 10, 2024
	 * Description: Times an array being sorted in descending order using insertion sort before and after and then returns the final time in nanoseconds.  
	 * @Parameters: data - The int array getting sorted
	 * @Return Value: long - The final time after the array has been sorted
	 * Data Type: long
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
	public static long insertionSortTimeDES(int[] data) {
		long beforeSort, afterSort, time = 0;
		beforeSort = getTime();
		insertionSortDES(data);
		afterSort = getTime();
		time += (afterSort - beforeSort);
		return time;
	}

	/*
	 * Method Name: selectionSortTimeASC 
	 * Author: Yunseo Jeon
	 * Creation Date: April 10, 2024
	 * Description: Times an array being sorted in ascending order using selection sort before and after and then returns the final time in nanoseconds.  
	 * @Parameters: data - The int array getting sorted
	 * @Return Value: long - The final time after the array has been sorted
	 * Data Type: long
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
	public static long selectionSortTimeASC(int[] data) {
		long beforeSort, afterSort, time = 0;
		beforeSort = getTime();
		selectionSortASC(data);
		afterSort = getTime();
		time += (afterSort - beforeSort);
		return time;
	}

	/*
	 * Method Name: selectionSortTimeDES 
	 * Author: Yunseo Jeon
	 * Creation Date: April 10, 2024
	 * Description: Times an array being sorted in descending order using selection sort before and after and then returns the final time in nanoseconds.  
	 * @Parameters: data - The int array getting sorted
	 * @Return Value: long - The final time after the array has been sorted
	 * Data Type: long
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
	public static long selectionSortTimeDES(int[] data) {
		long beforeSort, afterSort, time = 0;
		beforeSort = getTime();
		selectionSortDES(data);
		afterSort = getTime();
		time += (afterSort - beforeSort);
		return time;
	}

	/*
	 * Method Name: sequentialSearch 
	 * Author: Yunseo Jeon
	 * Creation Date: May 25, 2024
	 * Description: Searches through an array using sequention search method.  
	 * @Parameters: data - The int array getting sorted, key - The int thats being searched for
	 * @Return Value: int - returns the index of the number if found otherwise returns -1
	 * Data Type: int
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
	public static int sequentialSearch(int[] array, int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return i; /* the position where the element was found */
			}
		}
		return -1; /* return -1 if key not found in the array */
	}

	/*
	 * Method Name: binarySearch 
	 * Author: Yunseo Jeon
	 * Creation Date: May 25, 2024
	 * Description: Searches through an array using binary search method.  
	 * @Parameters: bigarray - The int array getting sorted, key - The int thats being searched for
	 * @Return Value: int - returns the index of the number if found otherwise returns -1
	 * Data Type: int
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
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

	/*
	 * Method Name: sequentialSearchTime 
	 * Author: Yunseo Jeon
	 * Creation Date: May 10, 2024
	 * Description: Times an array being searched for an int using sequential search before and after and then returns the final time in nanoseconds.  
	 * @Parameters: data - The int array getting sorted, num - The int thats being searched for 
	 * @Return Value: long - The final time after the array has been searched
	 * Data Type: long
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
	public static long sequentialSearchTime(int[] data, int num) {
		long beforeSearch, afterSearch, time = 0;
		beforeSearch = getTime();
		sequentialSearch(data, num);
		afterSearch = getTime();
		time += (afterSearch - beforeSearch);
		return time;
	}

	/*
	 * Method Name: binarySearchTime 
	 * Author: Yunseo Jeon
	 * Creation Date: May 10, 2024
	 * Description: Times an array being searched for an int using Binary search before and after and then returns the final time in nanoseconds.  
	 * @Parameters: data - The int array getting sorted, num - The int thats being searched for 
	 * @Return Value: long - The final time after the array has been searched
	 * Data Type: long
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
	public static long binarySearchTime(int[] data, int num) {
		long beforeSearch, afterSearch, time = 0;
		beforeSearch = getTime();
		binarySearch(data, num);
		afterSearch = getTime();
		time += (afterSearch - beforeSearch);
		return time;
	}

	public static void main(String[] args) {
		int SizeOfArray = 100000;	// CHANGE To 100000
		int[] A1 = new int[SizeOfArray];	// bubble sort 1
		int[] A2 = new int[SizeOfArray];	// bubble sort 2
		int[] A3 = new int[SizeOfArray];	// bubble sort 3

		int[] B1 = new int[SizeOfArray];	// insertion sort 1
		int[] B2 = new int[SizeOfArray];	// insertion sort 2
		int[] B3 = new int[SizeOfArray];	// insertion sort 3

		int[] C1 = new int[SizeOfArray];	// selection sort 1
		int[] C2 = new int[SizeOfArray];	// selection sort 2
		int[] C3 = new int[SizeOfArray];	// selection sort 3

		int[] searchArray = new int[SizeOfArray];	// Making an array for searches
		int key = 0;	// The Element being searched for in the array

		// Fill all the arrays with random values
		randomFillArray(A1, SizeOfArray);
		randomFillArray(A2, SizeOfArray);
		randomFillArray(A3, SizeOfArray);

		// Copy the array for insertion
		copyArray(A1, B1);
		copyArray(A2, B2);
		copyArray(A3, B3);

		// Copy the array for selection
		copyArray(A1, C1);
		copyArray(A2, C2);
		copyArray(A3, C3);

		// Sorting random
		System.out.println("********************RANDOM********************");
		long bubbleTime = bubbleSortTimeASC(A1) + bubbleSortTimeASC(A2) +
		bubbleSortTimeASC(A3);
		System.out.println("Average (Bubble): " + bubbleTime / 3 + " nanoseconds");
		long insertionTime = insertionSortTimeASC(B1) + insertionSortTimeASC(B2) +
		insertionSortTimeASC(B3);
		System.out.println("Average (Insertion): " + insertionTime / 3 + " nanoseconds");
		long selectionTime = selectionSortTimeASC(C1) + selectionSortTimeASC(C2) +
		selectionSortTimeASC(C3);
		System.out.println("Average (Selection): " + selectionTime / 3 + " nanoseconds");

		// Sorting one out of place
		A1[randomNumber(1, SizeOfArray)] = SizeOfArray + 69;
		A2[randomNumber(1, SizeOfArray)] = SizeOfArray + 69;
		A3[randomNumber(1, SizeOfArray)] = SizeOfArray + 69;

		// Copy the array for insertion
		copyArray(A1, B1);
		copyArray(A2, B2);
		copyArray(A3, B3);

		// Copy the array for selection
		copyArray(A1, C1);
		copyArray(A2, C2);
		copyArray(A3, C3);

		System.out.println("\n********************ONE OUT OF PLACE********************");
		bubbleTime = bubbleSortTimeASC(A1) + bubbleSortTimeASC(A2) +
		bubbleSortTimeASC(A3);
		System.out.println("Average (Bubble): " + bubbleTime / 3 + " nanoseconds");
		insertionTime = insertionSortTimeASC(B1) + insertionSortTimeASC(B2) +
		insertionSortTimeASC(B3);
		System.out.println("Average (Insertion): " + insertionTime
		/ 3 + " nanoseconds");
		selectionTime = selectionSortTimeASC(C1) + selectionSortTimeASC(C2) +
		selectionSortTimeASC(C3);
		System.out.println("Average (Selection): " + selectionTime
		/ 3 + " nanoseconds");

		// Reverse
		System.out.println("\n********************REVERSE********************");
		bubbleTime = bubbleSortTimeDES(A1) + bubbleSortTimeDES(A2) +
		bubbleSortTimeDES(A3);
		System.out.println("Average (Bubble): " + bubbleTime / 3 + " nanoseconds");
		insertionTime = insertionSortTimeDES(B1) + insertionSortTimeDES(B2) +
		insertionSortTimeDES(B3);
		System.out.println("Average (Insertion): " + insertionTime / 3 + " nanoseconds");
		selectionTime = selectionSortTimeDES(C1) + selectionSortTimeDES(C2) +
		selectionSortTimeDES(C3);
		System.out.println("Average (Selection): " + selectionTime / 3 + " nanoseconds");

		// Report
		System.out.println("\n********************REPORT********************");
		System.out.println("When the data is randomly filled, Insertion Sort has the fastest sorting time, outperforming both Selection Sort and Bubble Sort. When only one element is out of place, Bubble Sort demonstrates superior efficiency, making it the fastest in this scenario. For data in reverse order, Insertion Sort again proves to be the most efficient, surpassing the performance of both Bubble Sort and Selection Sort. These results highlight Insertion Sort's general efficiency across various conditions, while Bubble Sort excels when minimal sorting is required.");

		// Filling Array and sorting it to be used for sequential Search.  
		randomFillArray(searchArray, SizeOfArray);
		insertionSortASC(searchArray);

		// ************************************* BEST CASE SCENARIO *****************************************************
		// Best case Sequential
		key = searchArray[0];
		System.out.println("\n********************BEST CASE********************");
		System.out.println("Sequential: " + sequentialSearchTime(searchArray, key) + " nanoseconds");

		// Best case Binary
		key = searchArray[(searchArray.length - 1) / 2];
		System.out.println("Binary: " + binarySearchTime(searchArray, key) + " nanoseconds");


		// ************************************* WORST CASE SCENARIO *****************************************************
		// Worst case Sequential
		key = searchArray[searchArray.length - 1] + 1;
		System.out.println("\n********************WORST CASE********************");
		System.out.println("Sequential: " + sequentialSearchTime(searchArray, key) + " nanoseconds");

		// Worst case Binary
		System.out.println("Binary: " + binarySearchTime(searchArray, key) + " nanoseconds");


		// ************************************* AVERAGE CASE SCENARIO *****************************************************
		// Average case Sequential
		key = searchArray[randomNumber(0, searchArray.length-1)];
		System.out.println("\n********************AVERAGE CASE********************");
		System.out.println("Sequential: " + sequentialSearchTime(searchArray, key) + " nanoseconds");

		// Average case Binary
		System.out.println("Binary: " + binarySearchTime(searchArray, key) + " nanoseconds");

		//Report
		System.out.println("\n********************REPORT********************");
		System.out.println("The data compares the performance of Sequential Search and Binary Search under different conditions. In the best case scenario, Sequential Search is slightly faster compared to Binary Search. However, in the worst case scenario, Binary Search significantly outperforms Sequential Search. For the average case, Binary Search is again much more efficient, while Sequential Search takes longer. These findings highlight Binary Search's superior efficiency, especially in the worst and average cases, while Sequential Search only has a slight advantage in the best case scenario. Since sequential search goes through all elements, which means it does a lot more comparisons than binary search. It takes more time, therefore being the worse search.");
	} // end main
} // end Class
