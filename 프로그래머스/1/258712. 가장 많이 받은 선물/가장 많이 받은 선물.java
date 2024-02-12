import java.util.*;
class Solution {
    static int[][] arr;
    static int N;
    static int[] nextMonth;
    static int[] present;
    
    public int solution(String[] friends, String[] gifts) {
        N = friends.length;
        nextMonth  = new int[N];
        present = new int[N];
        arr = new int[N][N];
        for(int i = 0; i < gifts.length; i++){
            String[] g = gifts[i].split(" ");
             
            int a = getIndex(g[0],friends);
            int b = getIndex(g[1],friends);
            arr[a][b]++;
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        
        for(int i = 0; i < N; i++){
            int t1 = 0;
            int t2 = 0;
            for(int j = 0; j < N; j++){
                t1+= arr[i][j];
                t2+= arr[j][i];
                present[i] = t1 - t2;
            }
        }
        
        for(int i = 0; i < N; i++){
            System.out.println(present[i]);
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
        for(int i = 0; i < N; i++){
            System.out.println(nextMonth[i]);
        }
        return Arrays.stream(nextMonth).max().getAsInt();
    }
    static int getIndex(String name,String[] friends){
            for(int i = 0; i < N; i++){
                if(name.equals(friends[i])){
                    return i;
                }
            }
        return 0;
    }
}