import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int M;
    static Set<Integer>[] set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        set = new Set[N + 1];
        for (int i = 1; i < N + 1; i++) {
            set[i] = new HashSet<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < s; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            if (list.contains(1)) {
                for (Integer integer : list) {
                    set[integer].add(i);
                }
            } else {
                for (int j = 0; j < list.size(); j++) {
                    for (int k = 0; k < list.size(); k++) {
                        set[list.get(j)].addAll(set[list.get(k)]);
                    }
                }
            }

        }
        int size = set[1].size();
        List<Integer> ans = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (size == set[i].size()) {
                ans.add(i);
            }
        }
        Collections.sort(ans);
        System.out.println(1);
        for (Integer an : ans) {
            System.out.println(an);
        }
    }
}
