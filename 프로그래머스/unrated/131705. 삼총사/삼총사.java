class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int sz = number.length;
        
        for(int i = 0; i < sz; i++) {
            for(int j = i + 1; j < sz; j++) {
                for(int k = j + 1; k < sz; k++) {
                    int cnt = number[i] + number[j] + number[k];
                    if(cnt == 0)
                        answer++;
                }
            }
        }
        
        return answer;
    }
}