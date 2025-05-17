import java.util.*;

class Solution {
    
    static int n,ret;
    static int[][] q;
    static int[] ans;
    
    // v : nC5 숫자 5개
    boolean go(ArrayList<Integer> v){
        //todo : 이분탐색
        
        
        

        for(int i=0;i<q.length;++i){
            int cnt=0;
            for(int j=0;j<q[0].length;++j){
                for(int a : v){
                    // System.out.println(a+" "+q[i][j]);
                    if(a==q[i][j]) cnt++;
                }
                
            }
            // System.out.println(cnt+" "+ans[i]);
            if(cnt!=ans[i]){
                return false;
            }
        }
        
        return true;
    }
    
    void comb(int idx, ArrayList<Integer> v){
        if(v.size()==5){
            // System.out.println(v);
            if(go(v)){
                ret++;
            }
            return;
        }
        for(int i=idx+1;i<=n;++i){
            v.add(i);
            comb(i,v);
            v.remove(v.size()-1);
        }
    }
    
    public int solution(int _n, int[][] _q, int[] _ans) {
        n=_n;
        q=_q;
        ans=_ans;
        
        //1. 조합만들기
        ArrayList<Integer> v = new ArrayList<Integer>();
        comb(0,v);
        
        // ArrayList<Integer> tmp = new ArrayList<Integer>();
        // tmp.add(3);tmp.add(4);tmp.add(7);tmp.add(9);tmp.add(10);
        // go(tmp);
        
        //2. for q 갯수검사 -> ret+1
        return ret;
    }
}