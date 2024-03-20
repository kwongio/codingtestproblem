import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, "0");
        StringTokenizer s1 = new StringTokenizer(str, "1");
        System.out.println(Math.min(st.countTokens(), s1.countTokens()));


    }
}