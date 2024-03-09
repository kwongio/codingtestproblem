import java.util.*;

class Solution {
    static int N;
    static boolean[] visited;
    static List<Integer> scoreA;
    static List<Integer> scoreB;
    static int max = Integer.MIN_VALUE;
    static List<Integer> answer;
    
    public List<Integer> solution(int[][] dice) {
        N = dice.length;
        visited =  new boolean[N];
        DFS(0, dice, 0);
        List<Integer> answer2 = new ArrayList<>();
        for(int a : answer){
            answer2.add(a+1);
        }
        
        return answer2;
    }
    static void DFS(int depth, int[][] dice, int start){
        if(depth == N/2){
            play(dice);
            return;
        }
        for(int i = start ; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                DFS(depth  + 1 , dice , i + 1);    
                visited[i] = false;
            }
        }
    }
    
    static void play(int[][] dice){
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            if(visited[i])A.add(i);
            else B.add(i);    
        }
        scoreA=  new ArrayList<>();
        scoreB=  new ArrayList<>();
        combo(0, A, 0, dice, scoreA);
        combo(0, B, 0, dice, scoreB);
        Collections.sort(scoreA);
        Collections.sort(scoreB);
        
        int totalWinCount = 0;
        for(int a : scoreA){
            int start = 0;
            int end  = scoreA.size() - 1;
            while(start <= end){
                int mid = (start + end)/2;
                if(a > scoreB.get(mid)){
                    start = mid + 1 ;
                }else{
                    end = mid - 1;
                }
            }
            totalWinCount += start;
        }
        if(totalWinCount > max){
            max = totalWinCount;
            answer = A;
        }
    }
    
    static void combo(int depth, List<Integer> list, int sum, int[][] originDices, List<Integer> team){
        if(depth == list.size()){
            team.add(sum);
            return;
        }
        for(int i = 0; i < 6; i++){
            combo(depth + 1, list, originDices[list.get(depth)][i] + sum,originDices, team);
        }
    }
}