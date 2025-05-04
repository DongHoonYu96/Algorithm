import java.util.*;

class Pair {
    int first;
    int second;
    
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
    
    public String toString() {
        // System.out.println(this.first +" "+this.second);
        return this.first +" "+this.second;
    }
}

class Solution {
    static HashMap<String,Integer> m = new HashMap<>();
    static ArrayList<Integer> v = new ArrayList<>();
    static HashSet<String> s = new HashSet<>();
    
    static ArrayList<Pair> ret = new ArrayList<>();
    
    public int[] solution(String[] gems) {
        int[] answer = {};
        
        for(String gem : gems){
            // if(m.containsKey(gem)){
            //     m.put(gem,m.get(gem)+1);
            // }
            // else{
            //     m.put(gem,1);
            // }
            s.add(gem);
        }
        
        int n=gems.length;
        
        int kk = s.size(); //보석의 종류
        
        int st=0;
        int en=0; //포함
        
        m.put(gems[0],1);
        
        while(true){
            if(st>=n || en>=n){
                break;
            }
            
            // System.out.println(m.size() + " " + kk+ " " + st+ " " + en);
            // System.out.println(m);
            // System.out.println("==========================");
            
            //만족한다면, 정답후보에 추가, 시작을 증가시켜보기
            if(m.size()==kk){
                ret.add(new Pair(st,en));
                
                //2개이상이면, 갯수만 뺴주기
                if(m.get(gems[st]) >=2){
                    m.put(gems[st],m.get(gems[st])-1);
                }
                else{ //1개이하면 제거해주기
                    m.remove(gems[st]);
                }
                
                st++;
            }
            
            //만족하지않으면, en을 증가시켜야함
            else{
                en++;
                if(en==n) break;
                
                if(m.containsKey(gems[en])){
                    m.put(gems[en],m.get(gems[en])+1);
                }
                else{
                    m.put(gems[en],1);
                }
                // en++;
            }
            
        }
        
        // System.out.println(m);
        Collections.sort(ret, (a, b) -> {
            int dist1 = a.second - a.first;
            int dist2 = b.second - b.first;
            if(dist1 == dist2){
                return a.first==b.first? a.second - b.second : a.first - b.first;
            }
            return dist1 - dist2;
            
        });
        // System.out.println(ret);
        answer = new int[2];
        answer[0] = ret.get(0).first+1; //1-idx임
        answer[1] = ret.get(0).second+1;
        return answer;
    }
}