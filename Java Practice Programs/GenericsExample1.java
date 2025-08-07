class GenExmp<T1, T2> {
    T1 a;
    T2 b;

    GenExmp(T1 ob1, T2 ob2) {
        a = ob1;
        b = ob2;
    }

    String getClassNames() {
        return a.getClass().getName() + " " + b.getClass().getName();
    }

    String getValues() {
        return a.toString() + " " + b.toString();
    }
}

public class GenericsExample1 {
    public static void main(String[] args) {
        GenExmp<Integer, Character> obj = new GenExmp<Integer, Character>(36, 'A');
        System.out.println(obj.getClassNames());
        System.out.println(obj.getValues());
    }
}
