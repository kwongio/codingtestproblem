import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int cnt =0;
        
        int max  = Math.max(a , b);
        int min = Math.min(a,b);
        a = max;
        b = min;
        while(a  != b){
            cnt++;
            a = (a + 1)/2;
            b = (b + 1)/2;
        }
        return cnt;
    }
}