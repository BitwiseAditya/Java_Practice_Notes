import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorBasedSorting {
    public static void main(String[] args) {
        Comparator<Integer> com = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (a % 10 > b % 10)
                    return 1;
                else
                    return -1;
            }
        };

        List<Integer> arr = new ArrayList<>();
        arr.add(34);
        arr.add(46);
        arr.add(58);
        arr.add(67);
        arr.add(22);

        Collections.sort(arr, com); // custom sorting logic implement using Comparator object

        System.out.println(arr);

    }
}
