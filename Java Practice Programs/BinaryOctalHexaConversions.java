public class BinaryOctalHexaConversions {
    public static void main(String[] args) {
        int num = 1994;
        System.out.println("Conversion of" + num + " to hexadecimal string " + Integer.toHexString(num));
        System.out.println("Conversion of" + num + " to octal string " + Integer.toOctalString(num));
        System.out.println("Conversion of" + num + " to binary string " + Integer.toBinaryString(num));
    }
}
