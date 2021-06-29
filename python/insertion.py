# Sorts the array passed in as an argument, modifies it
def sort(arr):
	for i in range(1, len(arr)):
		value = arr[i]
		j = i - 1

		while (j >= 0 and arr[j] > value):
			arr[j + 1] = arr[j];
			j = j - 1;

		arr[j + 1] = value


# Declares an example array and sorts it
example = [ 9, 7, 3, 7, 1, 3, 0, 8 ]

print("Before - " + str(example))
sort(example)
print("After - " + str(example))