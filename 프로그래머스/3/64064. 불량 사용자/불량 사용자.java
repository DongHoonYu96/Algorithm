import java.util.*;
class Solution {
    static int answer;
    static int n,m;
    static String[] uid,bid;
    static boolean[] vis = new boolean[9];
    static Set<String> resultSet = new HashSet<>(); // 중복 제거를 위한 Set 추가
    
    //a와 b가 매칭되는지
    static boolean go2(String a, String b){
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
    
    static void perm(ArrayList<Integer> v, boolean[] visited) {
        // 기저 조건: m개를 모두 뽑았으면 결과 사용
        if (v.size() == n) {
            // 예: 결과 출력 또는 go(v) 호출
            // System.out.println(v);
            dfs(v);
            return;
        }

        // 0부터 n-1까지 모든 후보 인덱스 시도
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {             // 아직 사용되지 않은 인덱스만
                visited[i] = true;         // i 선택
                v.add(i);

                perm(v, visited);       // 다음 자리 재귀

                v.remove(v.size() - 1);    // 백트래킹
                visited[i] = false;        // i 선택 해제
            }
        }
    }
    
    //v : nPn 순열 인덱스
    static void dfs(ArrayList<Integer> v){
        ArrayList<String> tmp = new ArrayList<>();
        for(int i=0;i<m;++i){
            String u = uid[v.get(i)];
            if(go2(u,bid[i])){
                tmp.add(u);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        if(tmp.size()==bid.length){
            Collections.sort(tmp);
            for(String s : tmp){
                sb.append(s);
            }
            resultSet.add(sb.toString());
        }
    }
    
    static void combi(int idx, ArrayList<Integer> v){
        if(v.size()==m){
            // for(int i : v){
            //     System.out.print(i+" ");
            // }
            // System.out.println();
            dfs(v);
            return;
        }
        
        for(int i=idx+1;i<n;++i){
            v.add(i);
            combi(i,v);
            v.remove(v.size()-1);
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        n=user_id.length;
        m=banned_id.length;
        uid=user_id;
        bid=banned_id;
        
        // ArrayList<Integer> v = new ArrayList<>();
        // combi(-1,v);
        
        perm(new ArrayList<Integer>(), new boolean[9]);
        answer=resultSet.size();
        return answer;
    }
}