import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (String s : br.readLine().split("[a-zA-z]+")) {
                if (!s.equals("")) {
                    if (s.startsWith("0")) {
                        int idx = 0;
                        for (int j = 0; j < s.length(); j++) {
                            if (s.charAt(j) != '0') {
                                idx = j;
                                break;
                            }
                        }
                        if (idx == 0) {
                            s = "0";
                        } else {
                            s = s.substring(idx);
                        }
                    }
                    list.add(s);
                }
            }
        }
        Collections.sort(list, (o1, o2) -> o1.length() != o2.length() ? Integer.compare(o1.length(), o2.length()) : o1.compareTo(o2));
        for (String s : list) {
            System.out.println(s);
        }

    }
}
