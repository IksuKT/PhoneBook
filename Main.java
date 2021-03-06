import java.util.*;
import  java.io.*;
public class Main {
    public static void main(String[] args) {

        Hashtable<Integer, String> hashFind = new Hashtable(500);
        Hashtable<Integer, String> hashDirectory = new Hashtable(1014130);
        int [] find = new int[500];
        String[] findString = new String[500];
        String[] numbers = new String[500];
        Integer[] directory = new Integer[1014130];
        String[] directoryString = new String[1014130];
        int[] directory2 = new int[1014130];
        int[] directory3 = new int[1014130];
        long startTime = System.currentTimeMillis();

        File fileFind = new File("C:/Users/Bek/Downloads/find.txt");
        File fileDirectory = new File("C:/Users/Bek/Downloads/directory.txt");

//read from files to arrays
        try (Scanner scanner = new Scanner(fileFind)) {
            int i=0;
            while (scanner.hasNext()) {
                String str = scanner.nextLine();
                find[i] = str.hashCode();
                findString[i] = str;
                // hashFind.put(str.hashCode(), str);
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + "C:/Users/Bek/Downloads/find.txt");
        }

        try (Scanner scanner = new Scanner(fileDirectory))
        {
            int i=0;
            while (scanner.hasNext()) {
                String str = scanner.nextLine();
                String[] nameFromDirectory = str.split(" ");
                String currentTemp = nameFromDirectory[1];
                if (nameFromDirectory.length > 2) {
                    currentTemp = currentTemp + " " + nameFromDirectory[2];
                }
                directory[i] = currentTemp.hashCode();
                directoryString[i] = str;
                // hashDirectory.put(currentTemp.hashCode(), str);
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + "C:/Users/Bek/Downloads/find.txt");
        }

        startTime = System.currentTimeMillis() - startTime;


        //create hash
        long startTimeHash = System.currentTimeMillis();


        try (Scanner scanner = new Scanner(fileFind)) {
            int i=0;
            while (scanner.hasNext()) {
                String str = scanner.nextLine();
                // find[i] = str.hashCode();
                hashFind.put(str.hashCode(), str);
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + "C:/Users/Bek/Downloads/find.txt");
        }

        try (Scanner scanner = new Scanner(fileDirectory))
        {
            int i=0;
            while (scanner.hasNext()) {
                String str = scanner.nextLine();
                String[] nameFromDirectory = str.split(" ");
                String currentTemp = nameFromDirectory[1];
                if (nameFromDirectory.length > 2) {
                    currentTemp = currentTemp + " " + nameFromDirectory[2];
                }
                //   directory[i] = currentTemp.hashCode();
                hashDirectory.put(currentTemp.hashCode(), str);
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + "C:/Users/Bek/Downloads/find.txt");
        }

        startTimeHash = System.currentTimeMillis() - startTimeHash;

        System.out.println(startTime);

        System.out.println("Start searching (linear search)...");
        Search linearSearch = new Search();
        long t = System.currentTimeMillis();
        int e = linearSearch.searchLinear(find, directory);
        t = System.currentTimeMillis() - t;// + startTime;
        String s = msToData(t);
        System.out.println("Found " + find.length + " / " + e + " entries. Time taken: " + s);
        System.out.println();

        System.out.println("Start searching (bubble sort + jump search)...");

        //QuickSort
        QuickSort quickSorting = new QuickSort();
        int eBinary = 0;
        long quickSortTime = System.currentTimeMillis();
        quickSorting.quickSort(directory, directoryString,0, directory.length - 1);
        quickSortTime = System.currentTimeMillis() - quickSortTime;// + startTime;
        writeFile wr = new writeFile();
        wr.writeToFile(directoryString, "C:/Users/Bek/Downloads/directoryQuick.txt");
        wr.writeToFile(directory, "C:/Users/Bek/Downloads/directoryQuickHashcode.txt");

        bubbleSort dir = new bubbleSort();
        long sortTime = System.currentTimeMillis();
        long bubbleTime = bubbleSort.bubbleSorting(directory, directoryString, t);
        sortTime = System.currentTimeMillis() - sortTime;// + startTime;

        Search jump = new Search();
        int eJump = 0;
        long js = System.currentTimeMillis();

        for (int str : find) {
            if (Search.jumpSearch(directory, str) >= 0) {
                eJump++;
                //System.out.println(directory[jump.jumpSearch(directory, str)]);
            }
        }

        js = System.currentTimeMillis() - js;
        System.out.println("Found " + find.length + " / " + eJump + " entries. Time taken: " + msToData(sortTime + js));
        System.out.println("Sorting time: " + msToData(sortTime));
        System.out.println("Searching time: " + msToData(js));
        System.out.println("");

        System.out.println("Start searching (quick sort + binary search)...");

        long binarySearchTime = System.currentTimeMillis();
        for (int el: find) {
            if (Search.binarySearch(directory, el, 0, directory.length - 1) >= 0) {
                eBinary++;
            }
        }

        binarySearchTime = System.currentTimeMillis() - binarySearchTime + startTime;

        System.out.println("Found "+ find.length+" / " +eBinary +" entries. Time taken: " + msToData(quickSortTime + binarySearchTime));
        System.out.println("Sorting time: " + msToData(quickSortTime));
        System.out.println("Searching time: " + msToData(binarySearchTime));
        System.out.println();


        System.out.println("Start searching (hash table)...");
        Enumeration<Integer> enumeration = hashFind.keys();
        long hashTime = System.currentTimeMillis();

        // iterate using enumeration object
        int countFind = 0;

        while(enumeration.hasMoreElements()) {
            int keyField = enumeration.nextElement();
            String keyDirectory = hashDirectory.get(keyField);
            if (keyDirectory != null) {
                countFind++;
            }
        }

        hashTime = System.currentTimeMillis() - hashTime;

        System.out.println("Found "+ find.length+" / " +countFind +" entries. Time taken: " + msToData(hashTime + startTimeHash));
        System.out.println("Creating time: " + msToData(startTimeHash));
        System.out.println("Searching time: " + msToData(hashTime));

    }


    //func

    public static String msToData(long t) {
        int min = (int) t/60000;
        int sec = (int) (t-min * 60000) / 1000;
        int ms = (int) t % 1000;
        String s = min+" min. "+ sec+ " sec. "+ ms+ " ms.";
        return  s;
    }
}