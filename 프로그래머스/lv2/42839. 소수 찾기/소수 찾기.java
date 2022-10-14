import java.util.*;

class Solution {
    static int answer = 0;
    static int[] num;
    static boolean[] visited;
    static int[] result;
    static TreeSet<Integer> ts = new TreeSet<>();
    
    public int solution(String numbers) {
        num = new int[numbers.length()];
        result = new int[numbers.length()];
        visited = new boolean[numbers.length()];
        
        for(int i = 0; i < numbers.length(); i++) 
            num[i] = numbers.charAt(i) - '0';
        
        for(int i = 1; i <= numbers.length(); i++)
            DFS(0, i, num);
        
        return ts.size();
    
    }
    
    public static void DFS(int depth, int max, int[] num) {
        if(depth == max) {
            String s = "";
    
            for(int i = 0; i < depth; i++)
                s += result[i];
            
            if(isPrime(Integer.parseInt(s)))
                ts.add(Integer.parseInt(s));
            
            return;
        }
        
        for(int i = 0; i < num.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = num[i];
                DFS(depth + 1, max, num);
                visited[i] = false;
            }
        }
    }
    
    public static boolean isPrime(int n) {
        if(n == 0 || n == 1)
            return false;
        
        for(int i = 2; i < n; i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}