//package phonebook;

public class QuickSort {

    public static void quickSort(Integer[] array, String[] arrayString, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, arrayString, left, right); // the pivot is already on its place
            quickSort(array, arrayString, left, pivotIndex - 1);  // sort the left subarray
            quickSort(array, arrayString,pivotIndex + 1, right); // sort the right subarray
        }
    }


    private static int partition(Integer[] array, String[] arrayString, int left, int right) {

        int pivot = array[right];
        int partitionIndex = left; // the first element greater than the pivot

        /* move large values into the right side of the array */
        for (int i = left; i < right; i++) {

            if (pivot >= array[i]) { // may be used '<' as well
                swap(array, arrayString, i, partitionIndex);
                partitionIndex++;
            }
        }

        swap(array, arrayString, partitionIndex, right); // put the pivot on a suitable position

        return partitionIndex;
    }

    private static void swap(Integer [] array, String[] arrayString, int i, int j) {
        int temp = array[i];
            String tempString = arrayString[i];
        array[i] = array[j];
            arrayString[i] = arrayString[j];
        array[j] = temp;
            arrayString[j] = tempString;
    }

}
