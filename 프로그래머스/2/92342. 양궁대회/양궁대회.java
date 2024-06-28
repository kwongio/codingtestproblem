import java.util.*;

class Solution {

    int[] answer= new int[11];
    int apeach = 0;
    int min = Integer.MAX_VALUE;
    public int[] solution(int n, int[] info) {
        for(int i = 0; i < 11; i++){
            if(info[i] > 0){
                apeach +=  10 - i;
            }
        }
        PriorityQueue<State> q = new PriorityQueue<>();
        q.offer(new State(0, n, apeach, new int[11]));
        while(!q.isEmpty()){
            State now = q.poll();
            if(now.depth == 11 || now.n == 0){
                if(now.apeach >= 0){
                    continue;
                }
                if(min > now.apeach){
                    min = now.apeach;
                    if(now.n > 0){
                        now.temp[now.depth - 1]+= now.n;
                    }
                    answer= Arrays.copyOf(now.temp, 11);
                }else if(min == now.apeach){
                    for(int i = 10; i >= 0; i--){
                        if(now.temp[i] > answer[i]){
                            answer= Arrays.copyOf(now.temp, 11);
                            break;
                        }else if(now.temp[i] < answer[i]){
                            break;
                        }
                    }
                }
            }else{
                if(now.n - (info[now.depth] + 1) >= 0){
                 int[] newTemp = Arrays.copyOf(now.temp, 11);
                    if(info[now.depth] == 0){
                        newTemp[now.depth] = 1;
                        q.offer(new State(now.depth + 1, now.n - 1, now.apeach - (10 - now.depth), newTemp));
                    }else{
                        newTemp[now.depth] = info[now.depth] + 1;
                        q.offer(new State(now.depth + 1, now.n - (info[now.depth] + 1), now.apeach - ((10 - now.depth) * 2), newTemp));
                    }
                }
                q.offer(new State(now.depth + 1, now.n, now.apeach, Arrays.copyOf(now.temp, 11)));
            }
        }
        if(min == Integer.MAX_VALUE){
            return new int[]{-1};
        }
        return answer;
    }

}
class State implements Comparable<State>{
    int depth;
    int n;
    int apeach;
    int[] temp;

    public State(int depth, int n, int apeach, int[] temp){
        this.depth = depth;
        this.n = n;
        this.apeach = apeach;
        this.temp = temp;
    }

    @Override
    public int compareTo(State state){
        return this.apeach - state.apeach;
    }
}