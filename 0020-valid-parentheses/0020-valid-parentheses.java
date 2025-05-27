class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
                if(s.charAt(i)=='(' || s.charAt(i)=='{' ||s.charAt(i)=='['){
                    stk.push(c);
                    continue;
                }

                if(stk.size()>0 && c==')' && stk.peek()=='('){
                    stk.pop();
                    continue;
                }

                if(stk.size()>0 && c=='}' && stk.peek()=='{'){
                    stk.pop();
                    continue;
                }

                if(stk.size()>0 && c==']' && stk.peek()=='['){
                    stk.pop();
                    continue;
                }
                
                stk.push(c);
                
            }
            return stk.size()==0;
        }
        
}