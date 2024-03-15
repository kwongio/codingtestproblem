import java.util.*;
class Solution {
    int[][] arr;
    int N;
    int[] nextMonth;
    int[] present;
    Map<String, Integer> map = new HashMap<>();
    
    public int solution(String[] friends, String[] gifts) {
        N = friends.length;
        nextMonth  = new int[N];
        present = new int[N];
        arr = new int[N][N];
        for(int i = 0; i < friends.length; i++){
            map.put(friends[i], i);
        }
        
        for(int i = 0; i < gifts.length; i++){
            String[] g = gifts[i].split(" ");
            int a = map.get(g[0]);
            int b = map.get(g[1]);
            present[map.get(g[0])]++;
            present[map.get(g[1])]--;
            arr[a][b]++;
        }
        
        for(int i = 0; i < N ; i++){
            for(int j =  i + 1; j < N; j++){
                if(arr[i][j] == arr[j][i]){
                    if(present[i] > present[j]){
                        nextMonth[i]++;
                    }else if(present[i] < present[j]){
                        nextMonth[j]++;
                    }
                }
                else if(arr[i][j] > arr[j][i]){
                    nextMonth[i]++;
                }
                else if(arr[i][j] < arr[j][i]){
                    nextMonth[j]++;
                }
            }
           
        }

        return Arrays.stream(nextMonth).max().getAsInt();
    }
}