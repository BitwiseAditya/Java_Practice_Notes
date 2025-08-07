import java.io.*;

public class FileInputOutput {
    public static void main(String args[]) throws IOException {
        if (args.length != 2) {
            System.out.print("Command Line Arguments should only have");
            System.out.print(" two strings : inputfilename.txt and ");
            System.out.print("outputfilename.txt");
            return;
        }
        FileInputStream fin = null;
        FileOutputStream fout = null;
        try {
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1]);
            int i;
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.println((char) i);
                    fout.write((char) i);
                }
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("I/O Exception : " + e);
        } finally {
            try {
                fin.close();
            } catch (IOException e) {
                System.out.println(e);
            }
            try {
                fout.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
