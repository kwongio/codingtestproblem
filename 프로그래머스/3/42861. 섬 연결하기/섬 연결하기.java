import java.util.*;

class Solution {
    List<int[]> list = new ArrayList<>();
    int[] parent;
    public int solution(int n, int[][] costs) {
        parent = new int[n ];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int[] c : costs){
            int a = c[0];
            int b = c[1];
            int cc = c[2];
            list.add(new int[]{a,b,cc});
        }
        list.sort((o1, o2) -> Integer.compare(o1[2] , o2[2]));
        int ans =0 ;
        for(int[] v : list){
            int a = v[0];
            int b = v[1];
            int c = v[2];
            if(find(a) != find(b)){
                union(a, b);
                ans+=c;
            }
        }
        
        return ans;
    }
    
    public void union(int a, int b){
        a =find(a);
        b = find(b);
        if(a != b){
            parent[b] =a;
        }
    }
    public int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}