enum Apple {
    Laal(10), Peela(20), Hara(30), Neela(40);

    public int price;

    Apple(int p) {
        price = p;
    }

    int getPrice() {
        return price;
    }
}

class Enums {
    public static void main(String args[]) {
        Apple ap;
        // Display price of Winesap.
        System.out.println("Peela Apple costs " +
                Apple.Peela.getPrice() +
                " cents.\n");
        System.out.println("All apple prices:");
        for (Apple a : Apple.values())
            System.out.println(a + " costs " + a.getPrice() +
                    " cents.");
    }
}
