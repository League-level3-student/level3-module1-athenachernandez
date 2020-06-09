package _00_Dynamic_Integer_Array;

public class DynamicIntegerArray {
	// 1. Create a private int array. Don't initialize it.
	private int[] integers;

	public DynamicIntegerArray() {
		// 2. Initialize the int array to have 0 elements.
		// This will prevent a null pointer exception
		integers = new int[0];

	}

	// 3. Complete the steps in the add method
	public void add(int v) {
		// A. create and initialize a new int array to be one
		// element longer than the member array
		int[] longerIntegers = new int[integers.length + 1];
		// B. set the last element of your new array to
		// the value passed into the method
		longerIntegers[longerIntegers.length - 1] = v;
		// C. iterate through the member array and
		// copy every element from the member array
		// to the new array
		for (int i = 0; i < integers.length; i++) {
			longerIntegers[i] = integers[i];
		}
		// D. set the member array equal to the new array.
		integers = longerIntegers;

	}

	// 4. Complete the steps in the get method
	public int get(int location) {
		// A. Return the value of the member array at the location passed in
		return integers[location];
	}

	// 5. Run the DynamicArrayTest to see if you are correct so far.

	// 6. Complete the steps in the set method
	public void set(int v, int location) {
		// A. set the variable at the location passed in to the method
		// to the new value v
		integers[location] = v;
	}

	// 7. Complete the steps in the insert method
	public void insert(int v, int location) {
		// A. create and initialize a new int array to be one
		// element longer than the member array
		int[] arrayTwo = new int[integers.length + 1];

		// B. Make a for loop that iterates through the new array
		for (int i = 0; i < arrayTwo.length; i++) {
			// C. if i is less than location:
			if (i < location) {
				// set the element at i of the new array to the element at i of the member array
				arrayTwo[i] = integers[i];
				// D. else if i is greater than location:
			} else if (i > location) {
				// set the element at i of the new array to the i - 1 element of the member
				// array
				arrayTwo[i] = integers[i - 1];
				// E. else, set the element at i of the new array to the value v
			} else {
				arrayTwo[i] = v;
			}

		}
		// F. set the member array equal to the new array
		integers = arrayTwo;
	}

	// 8. Run the tests again and check your progress

	// 9. Complete the steps in the remove method
	public void remove(int location) {
		// A. create a new array that is one element smaller than the member array
		int[] arrayThree = new int[integers.length - 1];
		// B. make a for loop to iterate through the member array
		for (int i = 0; i < integers.length; i++) {
			// C. if i is less than location
			if (i < location) {
				// set the element at i of the new array to the element at i of the member array
				arrayThree[i] = integers[i];
				// D. else if i is greater than location
			} else if (i > location) {
				// set the element at i - 1 of the new array to the element at i of the member
				// array
				arrayThree[i - 1] = integers[i];
			} else {}
			// E. else, continue;
				
		}
		// F. set the member array equal to the new array
		integers = arrayThree;
	}

	// 10. Run the tests again the see if you are correct so far

	// 11. Complete the size method so that it returns the length of the member
	// array.
	public int size() {
		return integers.length;
	}

	// 12. Complete the clear array so that it sets the member array
	// equal to a new integer array of size 0
	public void clear() {
		integers = new int[0];
	}

	// 13. Run the test again to see if you are finished.
}
