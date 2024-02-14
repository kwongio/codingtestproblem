import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    public int solution(int[] nums) {
        for(int n : nums){
            set.add(n);
        }
        int N = nums.length/2;
        return Math.min(N, set.size());
    }
}