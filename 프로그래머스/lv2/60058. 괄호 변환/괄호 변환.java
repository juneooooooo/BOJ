import java.util.*;

class Solution {
    public String solution(String p) {
        return DFS(p);
    }
    
    public static String DFS(String s) {
        if(s.length() == 0) // 1. 빈 문자열 반환
            return "";
        
        String u = "";
        String v = "";
        
        int open = 0; // '(' 개수
        int close = 0; // ')' 개수
        
        for(int i = 0; i < s.length(); i++) { // 2. 최소길이 균형잡힌 괄호 문자열 u 구하기
            if(s.charAt(i) == '(')
                open++;
            else
                close++;
            
            if(open == close) {
                u = s.substring(0, i + 1);
                v = s.substring(i + 1, s.length());
                break;
            }
        }
        
        if(isCorrect(u)) { // 3. u가 올바른 괄호 문자열 인지 확인
            return u += DFS(v); // 3-1 v에 대해 1단계부터 수행하고 u에 붙인 후 return
        }
        else { // 4. u가 올바른 괄호 문자열이 아닌 경우
            String answer = "";
            
            answer += "("; // 4-1
            answer += DFS(v); // 4-2
            answer += ")"; // 4-3
            
            u = u.substring(1, u.length() - 1); // 4-4
            for(int i = 0; i < u.length(); i++) {
                char c = u.charAt(i);
                if(c == '(')
                    answer += ')';
                else
                    answer += '(';
            }
            
            return answer; // 4-5
        }
        
    }
    
    public static boolean isCorrect(String s) { // 올바른 괄호 문자열 확인 method
        Stack<Character> stk = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == '(') {
                stk.push(c);
            }
            else {
                if(stk.isEmpty() || stk.peek() == ')') {
                    return false;
                }
                else
                    stk.pop();
            }
        }
        
        return true;
    }
}