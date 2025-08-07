class GenExmp<T extends Number> {
    T[] a;

    GenExmp(T[] obj) {
        a = obj;
    }

    double getAvg() {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i].doubleValue();
        }
        return sum / a.length;
    }

    boolean compareAvg(GenExmp<?> obj) {
        if (this.getAvg() == obj.getAvg()) {
            return true;
        } else {
            return false;
        }
    }
}

public class GenericsExample2 {
    public static void main(String[] args) {
        Integer[] temp1 = { 1, 2, 3, 4, 5 };
        GenExmp<Integer> obj1 = new GenExmp<Integer>(temp1);
        Float[] temp2 = { 1.0F, 2.0F, 3.0F, 4.0F, 5.0F };
        GenExmp<Float> obj2 = new GenExmp<Float>(temp2);
        Double[] temp3 = { 1.0, 2.0, 3.0, 4.0, 5.0 };
        GenExmp<Double> obj3 = new GenExmp<Double>(temp3);
        if (obj1.compareAvg(obj2)) {
            System.out.println("Obj1 and Obj2 have same avgs");
        }
        if (obj1.compareAvg(obj3)) {
            System.out.println("Obj1 and Obj3 have same avgs");
        }
    }
}
