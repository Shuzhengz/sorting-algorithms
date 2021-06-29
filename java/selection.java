public class Selection {

	// Sorts the array passed in as an argument, modifies it
	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minimumIndex = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minimumIndex]) {
					minimumIndex = j;
				}
			}

			int temp = arr[minimumIndex];
			arr[minimumIndex] = arr[i];
			arr[i] = temp;
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