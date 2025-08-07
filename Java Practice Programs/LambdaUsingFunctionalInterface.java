interface funcInterfaceFirst {
    boolean isEven(int n);
}

interface funcInterfaceSecond {
    String reverse(String s);
}

interface genericExample<T> {
    T func(T obj);
}

public class LambdaUsingFunctionalInterface {
    public static void main(String args[]) {
        funcInterfaceFirst refObjFirst;
        funcInterfaceSecond refObjSecond;
        refObjFirst = (n) -> {
            if ((n & 1) == 0)
                return true;
            else
                return false;
        };
        refObjSecond = (s) -> {
            String temp = "";
            int n = s.length();
            for (int i = n - 1; i >= 0; i--) {
                temp += s.charAt(i);
            }
            return temp;
        };
        // Using the block lambdas created above:-
        if (refObjFirst.isEven(24)) {
            System.out.println("24 is even");
        }
        if (!refObjFirst.isEven(25)) {
            System.out.println("25 is not even");
        }
        System.out.println("Reverse of the word Expression is : " + refObjSecond.reverse("Expression"));
        System.out.println("Reverse of the word Parv is : " + refObjSecond.reverse("Parv"));

        genericExample<Integer> obj = (n) -> {
            // func checks wether given Integer is a multiple of 13 :-
            if ((n % 13) == 0)
                return 1;
            else
                return 0;
        };
        if (obj.func(133) == 1)
            System.out.println("133 is a multiple of 13");
        if (obj.func(117) == 1)
            System.out.println("117 is a multiple of 13");
    }
}
