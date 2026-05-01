import java.util.ArrayList;
import java.util.Collections;

public class InitializingAnArrayList {
    public static void main(String[] args) {
        // Creates a mutable ArrayList of size n, filled with -1
        int n = args.length;
        ArrayList<Integer> v = new ArrayList<>(Collections.nCopies(n, -1));
    }
}
