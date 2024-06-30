import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String[] split = pattern.split("\\*");
        String pre = split[0];
        String post = split[1];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (pre.length() + post.length() > s.length()
            ) {

                System.out.println("NE");
                continue;
            }
            if(s.startsWith(pre) && s.endsWith(post)){
                System.out.println("DA");
            }else{
                System.out.println("NE");
            }



        }
    }
}