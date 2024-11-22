import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<String> list = List.of ("dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z=");
        for (String s : list) {
            str = str.replaceAll(s, "1");
        }
        System.out.println(str.length());
    }
}