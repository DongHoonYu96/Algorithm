class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> m = new HashMap<>();
        m.put('I',1);
        m.put('V',5);
        m.put('X',10);
        m.put('L',50);
        m.put('C',100);
        m.put('D',500);
        m.put('M',1000);

        int ret=0;

        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            if(c=='I' && i+1<s.length()){
                if(s.charAt(i+1)=='V'){
                    ret+=4;
                    ++i;
                    continue;
                }
                else if(s.charAt(i+1)=='X'){
                    ret+=9;
                    ++i;
                    continue;
                }
                
            }
            if(c=='X' && i+1<s.length()){
                if(s.charAt(i+1)=='L'){
                    ret+=40;
                    ++i;
                    continue;
                }
                else if(s.charAt(i+1)=='C'){
                    ret+=90;
                    ++i;
                    continue;
                }
            }
            if(c=='C' && i+1<s.length()){
                if(s.charAt(i+1)=='D'){
                    ret+=400;
                    ++i;
                    continue;
                }
                else if(s.charAt(i+1)=='M'){
                    ret+=900;
                    ++i;
                    continue;
                }

            }
            ret+=m.get(c);
        }
        return ret;
    }
}