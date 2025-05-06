import java.util.*;

class Solution {
    static HashMap<String,String> m = new HashMap<>();
    
    public int solution(String s) {
        
        m.put("zero","0");
        m.put("one","1");
        m.put("two","2");
        m.put("three","3");
        m.put("four","4");
        m.put("five","5");
        m.put("six","6");
        m.put("seven","7");
        m.put("eight","8");
        m.put("nine","9");
        
        System.out.println(m.containsKey("one"));
        
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder buffer = new StringBuilder();
        for(int i=0;i<s.length();++i){
            
            if(s.charAt(i)=='0' || s.charAt(i)=='1' || s.charAt(i)=='2' || 
               s.charAt(i) =='3' || s.charAt(i)=='4' || s.charAt(i)=='5' || 
               s.charAt(i)=='6' || s.charAt(i)=='7' || s.charAt(i)=='8' || s.charAt(i)=='9'){
                sb.append(s.charAt(i));
                continue;
            }
            
            buffer.append(s.charAt(i));
            // System.out.println(buffer);
            // System.out.println(m.containsKey(buffer));
            if(m.containsKey(buffer.toString())){
                sb.append(m.get(buffer.toString()));
                buffer.setLength(0);
                continue;
            }
            
        }
        return Integer.parseInt(sb.toString());
    }
}