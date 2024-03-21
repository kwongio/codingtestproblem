import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String s = br.readLine();
        int length = str.length();
        String replace = str.replace(s, "");
        int length1 = replace.length();
        int length2 = s.length();
        System.out.println((length - length1)/length2);



    }
}