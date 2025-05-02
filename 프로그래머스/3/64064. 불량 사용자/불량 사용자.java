import java.util.*;
class Solution {
    static int answer;
    static int n,m;
    static String[] uid,bid;
    static Set<Integer> resultSet = new HashSet<>(); // 중복 제거를 위한 Set 추가
    
    //a와 b가 매칭되는지
    static boolean check(String a, String b){
        if(a.length()!=b.length()) return false;
        
        for(int i=0;i<a.length();++i){
            if(b.charAt(i)=='*'){
                continue;
            }
            if(a.charAt(i)!=b.charAt(i)){
                return false;
            }
        }
        return true;
    }
    
    void dfs(int i, int bit){
        if(i==m){
            resultSet.add(bit);
            return;
        }
        
        for(int j=0;j<n;++j){
            if((bit & (1<<j)) > 0) continue;
            if(!check(uid[j],bid[i])) continue;
            dfs(i+1, bit | (1<<j));
        }
    }
    

    
    public int solution(String[] user_id, String[] banned_id) {
        n=user_id.length;
        m=banned_id.length;
        uid=user_id;
        bid=banned_id;
        
        // ArrayList<Integer> v = new ArrayList<>();
        // combi(-1,v);
        
        dfs(0,0);
        answer=resultSet.size();
        return answer;
    }
}