import java.util.*;

public class MapWork {
    public static int maximumFrequency(int[] arr, int n) {
        // Map: number -> (firstIndex, frequency)
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new int[] { i, 1 }); // first index, frequency
            } else {
                map.get(arr[i])[1]++; // increase frequency
            }
        }

        int num = -1;
        int freq = Integer.MIN_VALUE;
        int ind = Integer.MAX_VALUE;

        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int number = entry.getKey();
            int firstIndex = entry.getValue()[0];
            int frequency = entry.getValue()[1];

            if (frequency > freq) {
                freq = frequency;
                num = number;
                ind = firstIndex;
            } else if (frequency == freq) {
                if (firstIndex < ind) { // smaller index wins
                    ind = firstIndex;
                    num = number;
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 2, 4, 5, 3, 2 };
        int n = arr.length;
        System.out.println(maximumFrequency(arr, n)); // Output: 2
    }
}

/*
 * With custom pair class :-
 * import java.util.*;
 * import java.util.Objects;
 * 
 * class Pair {
 * int firstIndex;
 * int frequency;
 * 
 * Pair(int firstIndex, int frequency) {
 * this.firstIndex = firstIndex;
 * this.frequency = frequency;
 * }
 * 
 * @Override
 * public boolean equals(Object o) {
 * if (this == o) return true; // same object
 * if (o == null || getClass() != o.getClass()) return false;
 * Pair pair = (Pair) o;
 * return firstIndex == pair.firstIndex && frequency == pair.frequency;
 * }
 * 
 * @Override
 * public int hashCode() {
 * return Objects.hash(firstIndex, frequency);
 * }
 * 
 * @Override
 * public String toString() {
 * return "(" + firstIndex + ", " + frequency + ")";
 * }
 * }
 * 
 * 
 * public class Solution {
 * public static int maximumFrequency(int[] arr, int n) {
 * // Map: number -> Pair(firstIndex, frequency)
 * Map<Integer, Pair> map = new HashMap<>();
 * 
 * for (int i = 0; i < n; i++) {
 * if (!map.containsKey(arr[i])) {
 * map.put(arr[i], new Pair(i, 1)); // first index, frequency = 1
 * } else {
 * map.get(arr[i]).frequency++; // increase frequency
 * }
 * }
 * 
 * int num = -1;
 * int freq = Integer.MIN_VALUE;
 * int ind = Integer.MAX_VALUE;
 * 
 * for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
 * int number = entry.getKey();
 * int firstIndex = entry.getValue().firstIndex;
 * int frequency = entry.getValue().frequency;
 * 
 * if (frequency > freq) {
 * freq = frequency;
 * num = number;
 * ind = firstIndex;
 * } else if (frequency == freq) {
 * if (firstIndex < ind) { // smaller index wins
 * ind = firstIndex;
 * num = number;
 * }
 * }
 * }
 * 
 * return num;
 * }
 * 
 * public static void main(String[] args) {
 * int[] arr = {2, 3, 2, 4, 5, 3, 2};
 * int n = arr.length;
 * System.out.println(maximumFrequency(arr, n)); // Output: 2
 * }
 * }
 * 
 */
