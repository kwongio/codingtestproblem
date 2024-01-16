import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> {
            {
                if (Integer.compare(map.get(o1), map.get(o2)) != 0) {
                    return Integer.compare(map.get(o2), map.get(o1));
                }
                if ((o1.length() != o2.length())) {
                    return o2.length() - o1.length();
                }
                return o1.compareTo(o2);

            }
        });

        for (String s : list) {
            bw.write(s + "\n");
        }
        bw.flush();

    }

    static class Word {
        int count;
        String word;

        public Word(int count, String word) {
            this.count = count;
            this.word = word;
        }
    }

}