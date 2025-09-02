/*Sum of Mode

Given an array arr[] of positive integers and an integer k. You have to find the sum of the modes of all the subarrays of size k.
Note: The mode of a subarray is the element that occurs with the highest frequency. If multiple elements have the same highest frequency, the smallest such element is considered the mode.

Examples:

Input: arr[] = [1, 2, 3, 2, 5, 2, 4, 4], k = 3
Output: 13
Explanation: The mode of each k size subarray is [1, 2, 2, 2, 2, 4] and sum of all modes is 13.
Input: arr[] = [1, 2, 1, 3, 5], k = 2
Output: 6
Explanation: The mode of each k size subarray is [1, 1, 1, 3] and sum of all modes is 6.
Constraints:
1 ≤ k ≤ arr.size() ≤105
1 ≤ arr[i] ≤ 105 */

import java.util.*;

class Solution {
    static class Pair {
        int value;
        int freq;

        public Pair(int a, int b) {
            this.value = a;
            this.freq = b;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair))
                return false;
            Pair p = (Pair) o;
            if (p.value == this.value && p.freq == this.freq) {
                return true;
            } else
                return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, freq);
        }
    }

    public int sumOfModes(int[] arr, int k) {
        Comparator<Pair> cmp = (a, b) -> {
            if (a.freq == b.freq) {
                return Integer.compare(a.value, b.value);
            }
            return Integer.compare(b.freq, a.freq);
        };
        TreeSet<Pair> st = new TreeSet<Pair>(cmp);
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < k; i++) {
            if (mp.containsKey(arr[i])) {
                st.remove(new Pair(arr[i], mp.get(arr[i])));
            }
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
            st.add(new Pair(arr[i], mp.get(arr[i])));
        }
        int left = 0, right = k - 1;
        while (right < n) {
            Pair p = st.first();
            sum += p.value;
            if (mp.get(arr[left]) == 1) {
                st.remove(new Pair(arr[left], mp.get(arr[left])));
                mp.remove(arr[left]);
            } else {
                st.remove(new Pair(arr[left], mp.get(arr[left])));
                mp.put(arr[left], mp.getOrDefault(arr[left], 0) - 1);
                st.add(new Pair(arr[left], mp.get(arr[left])));
            }
            left++;
            if (right + 1 < n) {
                if (mp.containsKey(arr[right + 1])) {
                    st.remove(new Pair(arr[right + 1], mp.get(arr[right + 1])));
                    mp.put(arr[right + 1], mp.getOrDefault(arr[right + 1], 0) + 1);
                    st.add(new Pair(arr[right + 1], mp.get(arr[right + 1])));
                } else {
                    mp.put(arr[right + 1], mp.getOrDefault(arr[right + 1], 0) + 1);
                    st.add(new Pair(arr[right + 1], mp.get(arr[right + 1])));
                }
            }
            right++;
        }
        return sum;
    }

}
