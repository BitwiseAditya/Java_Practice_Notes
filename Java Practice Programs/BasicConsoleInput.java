import java.io.*;

public class BasicConsoleInput {
    public static void outputBasic() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Characters , enter q to stop...");
        char c;
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');

    }

    public static void outputString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter strings, enter `stop` to stop");
        String s;
        do {
            s = br.readLine();
            System.out.println(s);
        } while (!s.equals("stop"));
    }

    public static void main(String[] args) {
        try {
            outputBasic();
            outputString();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
