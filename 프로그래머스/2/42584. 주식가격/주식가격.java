import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new  Stack<>();
        int[] ans = new int[prices.length];
        
        for(int i =0 ; i < prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            ans[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        return ans;
    }
}

