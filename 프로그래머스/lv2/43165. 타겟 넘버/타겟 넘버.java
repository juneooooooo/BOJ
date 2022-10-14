class Solution { 
    public int solution(int[] numbers, int target) { 
        return DFS(0, 0, target, numbers);
    }
    
    public static int DFS(int depth, int sum, int target, int[] numbers) {
        if(depth == numbers.length) {
            if(target == sum) 
                return 1;
            
            return 0;
        }
        
        return DFS(depth + 1, sum + numbers[depth], target, numbers) + DFS(depth + 1, sum - numbers[depth], target, numbers);
    }
}