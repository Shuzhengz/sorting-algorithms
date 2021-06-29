public class Insertion {

	// Sorts the array passed in as an argument, modifies it
	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int value = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > value) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}

			arr[j + 1] = value;
		}
	}

	// Prints every value in the array
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println("");
	}

	public static void main(String[] args) {
		int[] example = { 9, 7, 3, 7, 1, 3, 0, 8 };
		sort(example);
		printArray(example);
	}

}