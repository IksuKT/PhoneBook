//package phonebook;

public class Search {
    int e = 0;

    public int searchLinear(int[] find, Integer[] directory) {
        for (int indFind = 0; indFind < find.length; indFind++) {
            for (int indDir = 0; indDir < directory.length; indDir++) {
                if (directory[indDir] == find[indFind]) {
                    e++;
                    break;
                }
                //System.currentTimeMillis();
            }
        }
        return e;
    }

    public static int jumpSearch(Integer[] array, int target) {
        int currentRight = 0; // right border of the current block
        int prevRight = 0; // right border of the previous block

        /* If array is empty, the element is not found */
        if (array.length == 0) {
            return -1;
        }

        /* Check the first element */
        if (array[currentRight] == target) {
            return 0;
        }

        /* Calculating the jump length over array elements */
        int jumpLength = (int) Math.sqrt(array.length);

        /* Finding a block where the element may be present */
        while (currentRight < array.length - 1) {

            /* Calculating the right border of the following block */
            currentRight = Math.min(array.length - 1, currentRight + jumpLength);

            if (array[currentRight] >= target) {
                break; // Found a block that may contain the target element
            }

            prevRight = currentRight; // update the previous right block border
        }

        /* If the last block is reached and it cannot contain the target value => not found */
        if ((currentRight == array.length - 1) && target > array[currentRight]) {
            return -1;
        }

        /* Doing linear search in the found block */
        return backwardSearch(array, target, prevRight, currentRight);
    }

    public static int backwardSearch(Integer[] array, int target, int leftExcl, int rightIncl) {
        for (int i = rightIncl; i > leftExcl; i--) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Integer[] array, int elem, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2; // the index of the middle element

            if (elem == array[mid]) {
                return mid; // the element is found, return its index
            } else if (elem < array[mid]) {
                right = mid - 1; // go to the left subarray
            } else {
                left = mid + 1;  // go the the right subarray
            }
        }
        return -1; // the element is not found
    }
}

