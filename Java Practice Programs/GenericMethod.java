class Example {
    // The following is an example of a Generic Method :-
    <T extends Number> double triple(T obj) {
        return 3.0 * obj.doubleValue();
    }
}

public class GenericMethod {
    public static void main(String args[]) {
        Example obj = new Example();
        System.out.println(obj.triple(33F));
    }
}
