class Solution {
    static int answer = 0;
    static boolean[] visited;
    
    public int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];        
        
        DFS(0, 0, target, numbers);
        
        return answer;
    }
    
    public static void DFS(int depth, int sum, int target, int[] numbers) {
        if(depth == numbers.length) {
            if(target == sum) {
                answer++;
            }
            return;
        }
        
        DFS(depth + 1, sum + numbers[depth], target, numbers);
        DFS(depth + 1, sum - numbers[depth], target, numbers);
    }
}