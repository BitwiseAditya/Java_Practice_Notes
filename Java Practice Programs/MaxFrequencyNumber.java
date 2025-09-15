import java.util.*;

public class MaxFrequencyNumber {
    static class Pair<T> {
        public int value;
        public int key;

        public Pair(T key, T value) {
            this.key = (int) key;
            this.value = (int) value;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair p = (Pair) o;
            if (p.key == this.key && p.value == this.value) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        @Override
        public String toString() {
            return "(" + String.valueOf(key) + "," + String.valueOf(value) + ")";
        }
    }

    public static int maxFrequencyNumber(int n, int[] arr) {
        // Write your code here
        Map<Integer, Pair<Integer>> mp = new HashMap<Integer, Pair<Integer>>();
        for (int i = 0; i < n; i++) {
            if (mp.containsKey(arr[i])) {
                mp.put(arr[i], new Pair<Integer>(mp.get(arr[i]).key, mp.get(arr[i]).value + 1));
            } else {
                mp.put(arr[i], new Pair<Integer>(i, 1));
            }
        }
        int freq = Integer.MIN_VALUE;
        int index = -1;
        int val = -1;
        for (Map.Entry<Integer, Pair<Integer>> e : mp.entrySet()) {
            if (freq < e.getValue().value) {
                freq = e.getValue().value;
                index = e.getValue().key;
                val = e.getKey();
            } else if (freq == e.getValue().value) {
                if (index > e.getValue().key) {
                    freq = e.getValue().value;
                    index = e.getValue().key;
                    val = e.getKey();
                }
            }
        }
        return val;
    }
}
