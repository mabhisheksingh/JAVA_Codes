package design;

import java.util.*;

/*
* Design a number container system that can do the following:

Insert or Replace a number at the given index in the system.
Return the smallest index for the given number in the system.
Implement the NumberContainers class:

NumberContainers() Initializes the number container system.
void change(int index, int number) Fills the container at index with the number.
* If there is already a number at that index, replace it.
int find(int number) Returns the smallest index for the given number, or -1
* if there is no index that is filled by number in the system.
* */
public class NumberContainers {
    private Map<Integer, SortedSet<Integer>> numberIndex = new HashMap<>();
    private Map<Integer, Integer> indexNumber = new HashMap<>();
    public NumberContainers() {}

    public void change(int index, int number) {
        if (indexNumber.containsKey(index)) {
            int prevNumber = indexNumber.get(index);
            Set<Integer> integerSet = numberIndex.get(prevNumber);
            integerSet.remove(index);
            if(integerSet.isEmpty()) numberIndex.remove(prevNumber);
        }
        indexNumber.put(index, number);
        numberIndex.computeIfAbsent(number, key -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        if (!numberIndex.containsKey(number) || numberIndex.get(number).isEmpty()) return -1;
        int no = numberIndex.get(number).first();
        return no;

    }

}
