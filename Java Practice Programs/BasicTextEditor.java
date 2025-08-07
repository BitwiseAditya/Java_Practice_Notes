import java.io.*;

public class BasicTextEditor {
    public static void main(String args[]) throws IOException {
        System.out.println("Enter 10 strings : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = new String[10];
        for (int i = 0; i < 10; i++) {
            try {
                s[i] = br.readLine();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        System.out.println("Input Strings are : ");
        for (int i = 0; i < 10; i++) {
            System.out.println(s[i]);
        }
    }
}
