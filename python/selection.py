# Sorts the array passed in as an argument, modifies it
def sort(arr):
	print("Sort")

	for i in range(len(arr)):
		minimumIndex = i;

		for j in range(i + 1, len(arr)):
			if (arr[j] < arr[minimumIndex]):
				minimumIndex = j

		temp = arr[minimumIndex];
		arr[minimumIndex] = arr[i];
		arr[i] = temp;

# Declares an example array and sorts it
example = [ 9, 7, 3, 7, 1, 3, 0, 8 ]

print("Before - " + str(example))
sort(example)
print("After - " + str(example))