import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String s1 = new StringBuilder(s).reverse().toString();
        if (s.equals(s1)) {
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}