import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map;
        for (int testCase = 0; testCase < T; testCase++) {
            map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String input = st.nextToken();
                int value = Integer.parseInt(st.nextToken());
                if (input.equals("I")) {
                    map.put(value, map.getOrDefault(value, 0) + 1);
                } else if (input.equals("D")) {
                    if (map.isEmpty()) continue;
                    if (value == -1) { //최소값 ㄱ삭제
                        int v = map.get(map.firstKey());
                        if (v == 1) {
                            map.remove(map.firstKey());
                        } else {
                            map.put(map.firstKey(), v - 1);

                        }
                    } else { // 최대값 삭제
                        int v = map.get(map.lastKey());
                        if (v == 1) {
                            map.remove(map.lastKey());
                        } else {
                            map.put(map.lastKey(), v - 1);

                        }
                    }
                }
            }
            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}