import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static Map<String, String> girl = new HashMap<>();
    static Map<String, String[]> team = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String group = br.readLine();
            int people = Integer.parseInt(br.readLine());
            String[] arr = new String[people];
            for (int j = 0; j < people; j++) {
                String name = br.readLine();
                arr[j] = name;
                girl.put(name, group);
            }
            team.put(group, arr);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                String[] people = team.get(name);
                Arrays.sort(people);
                for (String person : people) {
                    System.out.println(person);
                }
            } else {
                System.out.println(girl.get(name));

            }
        }


    }
}