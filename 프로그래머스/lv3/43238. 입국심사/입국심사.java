import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) times[times.length - 1] * n; // 최악 시간
        
        while(left <= right) {
            long sum = 0;
            long mid = (left + right) / 2; // 최소 시간 찾기
            
            for(int time : times) {
                sum += (mid / time);    
            }
            
            if(sum >= n) { // 더 많이 처리하므로 시간을 줄임
                right = mid - 1;
                answer = mid;
            }
            else { // 더 적게 처리하므로 시간을 늘림
                left = mid + 1;
            }
        } 
        
        return answer;
    }
}