public class WrapperClasses {
    public static void main(String[] args) {

        // Integer
        Integer intObj = Integer.valueOf(100);
        int intPrimitive = intObj.intValue();
        System.out.println("Integer: valueOf() = " + intObj + ", intValue() = " + intPrimitive);

        // Double
        Double doubleObj = Double.valueOf(3.1415);
        double doublePrimitive = doubleObj.doubleValue();
        System.out.println("Double: valueOf() = " + doubleObj + ", doubleValue() = " + doublePrimitive);

        // Float
        Float floatObj = Float.valueOf(9.8f);
        float floatPrimitive = floatObj.floatValue();
        System.out.println("Float: valueOf() = " + floatObj + ", floatValue() = " + floatPrimitive);

        // Long
        Long longObj = Long.valueOf(10000000000L);
        long longPrimitive = longObj.longValue();
        System.out.println("Long: valueOf() = " + longObj + ", longValue() = " + longPrimitive);

        // Short
        Short shortObj = Short.valueOf((short) 123);
        short shortPrimitive = shortObj.shortValue();
        System.out.println("Short: valueOf() = " + shortObj + ", shortValue() = " + shortPrimitive);

        // Byte
        Byte byteObj = Byte.valueOf((byte) 10);
        byte bytePrimitive = byteObj.byteValue();
        System.out.println("Byte: valueOf() = " + byteObj + ", byteValue() = " + bytePrimitive);

        // Boolean
        Boolean boolObj = Boolean.valueOf(true);
        boolean boolPrimitive = boolObj.booleanValue();
        System.out.println("Boolean: valueOf() = " + boolObj + ", booleanValue() = " + boolPrimitive);

        // Character
        Character charObj = Character.valueOf('A');
        char charPrimitive = charObj.charValue();
        System.out.println("Character: valueOf() = " + charObj + ", charValue() = " + charPrimitive);
    }
}
// .equals(), .hashCode() etc...
