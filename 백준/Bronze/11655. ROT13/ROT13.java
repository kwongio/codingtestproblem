import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (Character.isAlphabetic(arr[i])) {
                int c = arr[i] + 13;
                if (Character.toLowerCase(arr[i]) + 13 > 'z') {
                    c -= 26;
                }
                System.out.print((char) (c));
            } else {
                System.out.print(arr[i]);
            }
        }
    }
}