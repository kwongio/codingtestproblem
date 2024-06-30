import java.util.*;
import java.io.*;

public class Main {
    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int value = map.getOrDefault(s.charAt(0), 0) + 1;
            if (value == 5) {
                list.add(s.charAt(0));
            }
            map.put(s.charAt(0), value);
        }

        if (list.isEmpty()) {
        System.out.println("PREDAJA");

        }else{
            Collections.sort(list);
            for (Character c : list) {
                System.out.print(c);
            }
        }
    }
}