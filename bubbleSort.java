//package phonebook;

public class bubbleSort {

    public static long bubbleSorting(Integer[] array, String[] arrayString, long time10) {
        int k = 0;
        long t = System.currentTimeMillis();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                /* if a pair of adjacent elements has the wrong order it swaps them */

                    if (array[j] > array[j+1]) {
                    int temp = array[j];
                        String tempString = arrayString[j];
                    array[j] = array[j + 1];
                        arrayString[j] = arrayString[j + 1];
                    array[j + 1] = temp;
                        arrayString[j + 1] = tempString;
                    k++;
                }
            }
            /*if (System.currentTimeMillis() - t > time10 * 10) {
                return System.currentTimeMillis() - t;
            }*/

        }
        t = System.currentTimeMillis() - t;
        return t;
    }
}

