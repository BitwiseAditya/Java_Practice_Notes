public class StringExample {
    public static void main(String[] args) {

        String s = "I Love Java ! Java is awesome !";
        String s1 = "Java";
        if (s.equals(s1))
            System.out.println("Nope");
        if (s.equalsIgnoreCase(s1))
            System.out.println("Nope");
        if (s.compareTo(s1) > 0)
            System.out.println("Yupp");
        if (s.compareTo(s1) <= 0)
            System.out.println("Nope");
        if (s.compareToIgnoreCase(s1) > 0)
            System.out.println("Yupp");
        int index = s.indexOf(s1);
        System.out.println(s1 + " occurs in " + s + " for the first time at index " + index);
        index = s.lastIndexOf(s1);
        System.out.println(s1 + " occurs in " + s + " for the last time at index " + index);
        index = s.indexOf(s1, 12);
        System.out.println(s1 + " occurs in " + s + " for the first time from index 12 onwards at index " + index);
        String substr = s.substring(3, 10);
        System.out.println("substring of " + s + " from index 3 to 9 including , is " + substr);
        Integer n = 100;
        String temp1 = String.valueOf(n);
        String temp2 = n.toString();
        System.out.println(temp1.equalsIgnoreCase(temp2));
        // .toUpperCase(),.toLowerCase(),.contains(),.isEmpty(),.replaceFirst(),.replaceAll(),.split().
        StringBuffer sb = new StringBuffer("Hello");
        System.out.println("buffer before = " + sb);
        System.out.println("charAt(1) before = " + sb.charAt(1));
        sb.setCharAt(1, 'i');
        sb.setLength(2);
        System.out.println("buffer after = " + sb);
        System.out.println("charAt(1) after = " + sb.charAt(1));
        int a = 42;
        s = sb.append("a = ").append(a).append("!").toString();
        System.out.println(s);
        sb.insert(2, "like ");
        System.out.println(sb);
        sb.reverse();
        sb.delete(4, 7);
        System.out.println("After delete: " + sb);
        sb.deleteCharAt(0);
        System.out.println("After deleteCharAt: " + sb);
        sb.replace(5, 7, "was");
        System.out.println("After replace: " + sb);
        int i;
        i = sb.indexOf("one");
        System.out.println("First index: " + i);
        i = sb.lastIndexOf("one");
        System.out.println("Last index: " + i);
        // .substring(),.trimToSize()

        /*
         * StringBuilder is similar to StringBuffer except for one important difference:
         * it is not synchronized, which means that it is not thread-safe. The advantage
         * of StringBuilder
         * is faster performance. However, in cases in which a mutable string will be
         * accessed by multiple
         * threads, and no external synchronization is employed, you must use
         * StringBuffer rather than StringBuilder
         */

        char c[] = { 'a', 'b', '5', '?', 'A', ' ' };
        for (i = 0; i < c.length; i++) {
            if (Character.isDigit(c[i]))
                System.out.println(c[i] + " is a digit.");
            if (Character.isLetter(c[i]))
                System.out.println(c[i] + " is a letter.");
            if (Character.isWhitespace(c[i]))
                System.out.println(c[i] + " is whitespace.");
            if (Character.isUpperCase(c[i]))
                System.out.println(c[i] + " is uppercase.");
            if (Character.isLowerCase(c[i]))
                System.out.println(c[i] + " is lowercase.");

        }
    }
}
