# PhoneBook
Work on project. Stage 4/4: Instant search
Project: Phone Book

Description
The search is pretty fast, isn't it? Is it possible to come up with something even faster?

In the previous stage you prepared the data by the algorithm with complexity O(n log n) and found the data by the algorithm with complexity O(log n). At this stage you will implement faster data preparation and faster search. The preparation will have a complexity of O(n) and the search will have a complexity of O(1). A hash table will help you with this. Implement this class by yourself.

You need to add all the elements to the hash table and then find the necessary phone numbers as in the previous stages. Since the hash table is filled in once, you need to measure the hash table creation time separately (this is like sorting in the previous stage).

Example
Output all four approaches one after another and see which one is faster. Output example is shown below. Note that you can get totally different sorting and searching times!

Start searching (linear search)...
Found 500 / 500 entries. Time taken: 1 min. 56 sec. 328 ms.
 
Start searching (bubble sort + jump search)...
Found 500 / 500 entries. Time taken: 9 min. 15 sec. 291 ms.
Sorting time: 8 min. 45 sec. 251 ms.
Searching time: 0 min. 30 sec. 40 ms.
 
Start searching (quick sort + binary search)...
Found 500 / 500 entries. Time taken: 1 min. 21 sec. 996 ms.
Sorting time: 1 min. 17 sec. 381 ms.
Searching time: 0 min. 4 sec. 615 ms.
 
Start searching (hash table)...
Found 500 / 500 entries. Time taken: 0 min. 4 sec. 256 ms.
Creating time: 0 min. 4 sec. 121 ms.
Searching time: 0 min. 0 sec. 135 ms.
