import java.util.*;

class Solution {
    boolean[] visit;
    int min = Integer.MAX_VALUE;
    int n ;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        n = words.length;
        visit = new boolean[n];
        
        DFS(0, begin, target, words);
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    public void DFS(int depth , String begin, String target, String[] words){
        
        if(begin.equals(target)){
            min = Math.min(min, depth);
            return;
        }
        
        if(depth == n) return;
        
        for(int i = 0; i < n; i++){
            if(!visit[i] && check(begin, words[i])){
                visit[i] = true;
                DFS(depth + 1, words[i], target, words);
                visit[i] = false;
            }
        }
    }
    public boolean check(String begin, String word){
        int count =0 ;
        int len = begin.length();
        for(int i =0 ; i < begin.length(); i++){
            if(begin.charAt(i) == word.charAt(i)){
                count++;
            }
        }
        return len- 1== count;
        
    }
}