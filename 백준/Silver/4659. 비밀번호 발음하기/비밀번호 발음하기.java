import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
       Loop: while (!Objects.equals(input = br.readLine(), "end")) {
            if (input.contains("a") || input.contains("e") || input.contains("i") || input.contains("o") || input.contains("u")) {

            }else{
                System.out.println("<"+input+"> is not acceptable.");
                continue;
            }
            int a = 0;
            int m = 0;
            String pre = "";
            for (String s : input.split("")) {
                if (pre.equals(s) && !pre.equals("e") &&  !pre.equals("o") ) {
                    System.out.println("<"+input+"> is not acceptable.");
                    continue Loop;

                }
                if (s.contains("a") || s.contains("e") || s.contains("i") || s.contains("o") || s.contains("u")) {
                    m = 0;
                    a++;
                } else {
                    m++;
                    a = 0;
                }
                if(m== 3 || a == 3){
                    System.out.println("<"+input+"> is not acceptable.");
                    continue Loop;
                }
                pre = s;
            }
           System.out.println("<"+input+"> is acceptable.");
        }


    }
}
