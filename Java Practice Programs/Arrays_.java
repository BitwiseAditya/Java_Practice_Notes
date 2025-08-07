import java.util.*;

public class Arrays_ {
    public static void main(String[] args) {
        // 1. Sorting
        int[] nums = { 5, 2, 9, 1 };
        Arrays.sort(nums);
        System.out.println("Sorted: " + Arrays.toString(nums));

        // 2. Binary Search
        int index = Arrays.binarySearch(nums, 5);
        System.out.println("Index of 5: " + index);

        // 3. Equals
        int[] a = { 1, 2, 3 };
        int[] b = { 1, 2, 3 };
        int[] c = { 3, 2, 1 };
        System.out.println("a equals b? " + Arrays.equals(a, b)); // true
        System.out.println("a equals c? " + Arrays.equals(a, c)); // false

        // 4. deepEquals
        int[][] mat1 = { { 1, 2 }, { 3, 4 } };
        int[][] mat2 = { { 1, 2 }, { 3, 4 } };
        System.out.println("deepEquals? " + Arrays.deepEquals(mat1, mat2)); // true

        // 5. Fill
        int[] fillArray = new int[5];
        Arrays.fill(fillArray, 7);
        System.out.println("Filled with 7: " + Arrays.toString(fillArray));

        Arrays.fill(fillArray, 1, 4, 9);
        System.out.println("Partial fill with 9: " + Arrays.toString(fillArray));

        // 6. Copy
        int[] copied = Arrays.copyOf(a, 5);
        System.out.println("Copied (length 5): " + Arrays.toString(copied));

        int[] range = Arrays.copyOfRange(nums, 1, 3);
        System.out.println("Copied range: " + Arrays.toString(range));

        // 7. toString & deepToString
        System.out.println("1D array: " + Arrays.toString(a));
        System.out.println("2D array: " + Arrays.deepToString(mat1));

        // 8. asList
        String[] strArr = { "A", "B", "C" };
        List<String> strList = Arrays.asList(strArr);
        System.out.println("List from array: " + strList);
        // strList.add("D"); // UnsupportedOperationException

        // 9. hashCode
        System.out.println("hashCode of a: " + Arrays.hashCode(a));
        System.out.println("deepHashCode of mat1: " + Arrays.deepHashCode(mat1));

        // 10. parallelSort
        int[] pArr = { 9, 7, 5, 3, 1 };
        Arrays.parallelSort(pArr);
        System.out.println("Parallel sorted: " + Arrays.toString(pArr));

        // 11. setAll
        int[] squareArr = new int[6];
        Arrays.setAll(squareArr, i -> i * i);
        System.out.println("Squares: " + Arrays.toString(squareArr));

        // 12. parallelPrefix
        int[] prefixSum = { 1, 2, 3, 4 };
        Arrays.parallelPrefix(prefixSum, (a1, a2) -> a1 + a2);
        System.out.println("Prefix sum: " + Arrays.toString(prefixSum));
    }
}
