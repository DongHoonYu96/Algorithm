import java.util.*;

class Solution {
    String rotate(String s){
        return s.substring(1) + s.charAt(0);
    }
    boolean check(String s){
        int leftCnt=0;
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();++i){
            char cur = s.charAt(i);
            if(s.charAt(i)=='[' || s.charAt(i)=='(' || s.charAt(i)=='{'){
                leftCnt++;
                stk.push(s.charAt(i));
            }
            else if(stk.size()>0 && cur==']' && stk.peek()=='['){
                stk.pop();
            }
            else if(stk.size()>0 && cur==')' && stk.peek()=='('){
                stk.pop();
            }
            else if(stk.size()>0 && cur=='}' && stk.peek()=='{'){
                stk.pop();
            }
        }
        return stk.isEmpty() && leftCnt!=0;
    }
    public int solution(String s) {
        int answer = 0;
        int n=s.length();
        for(int i=0;i<n;++i){
            // System.out.println(s);
            if(check(s)) answer++;
            s=rotate(s);
        }
        return answer;
    }
}