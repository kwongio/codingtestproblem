import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[] person;
    static int[] time;
    static int[] coffeee;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        person = new int[N];
        coffeee = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }
        time = new int[person[N - 1] + 1];
        for (int i = 0; i < N; i++) {
            time[person[i]] = -1;
        }
        int pIdx = 0;
        int cnt = 0;
        int serve = 0;
//        System.out.println(Arrays.toString(time));
        for (int i = 0; i < time.length; i++) {
//            System.out.println(pIdx + " " + cnt);
            if (time[i] == -1) {//커피 줘야함
                if (coffeee[serve] == 1) {
                    serve++;
                    if(serve == N){
                        System.out.println("success");
                        return;
                    }
                } else {
                    System.out.println("fail");
                    return;
                }
            } else {
                //토기를 만들거나
                //커피를 담거나해야함
                //커피 줘야하는 시간 현재 시간이 M 안에 있어야함
                if(pIdx == person.length){
                    continue;
                }
                if (person[pIdx] - i <= M) {
                    if (cnt > 0 && coffeee[pIdx] == 0){
                        coffeee[pIdx] = 1;
                        pIdx++;
                        cnt--;
                    }else{
                        cnt++;
                    }
                }else{
                    cnt++;
                }
            }
        }
        System.out.println("success");
    }
}