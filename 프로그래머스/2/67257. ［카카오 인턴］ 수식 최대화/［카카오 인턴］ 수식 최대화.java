import java.util.*;
class Solution {
    static HashMap<Integer,Character> m = new HashMap<>();
    static ArrayList<Long> v = new ArrayList<>();    // int에서 long으로 변경
    static ArrayList<Character> v2 = new ArrayList<>();
    static boolean[] vis = new boolean [104];
    static long ret;    // int에서 long으로 변경
    
    void go(char c){
        // 수정된 go 메서드
        for(int i=0; i<v2.size(); i++){
            if(v2.get(i)==c && !vis[i]){   // vis 체크 추가
                vis[i]=true;
                long a = v.get(i);
                long b = v.get(i+1);
                
                if(c=='+'){
                    v.set(i, a+b);
                } else if(c=='-'){
                    v.set(i, a-b);
                } else if(c=='*'){
                    v.set(i, a*b);
                }
                
                // i+1부터 끝까지 값 한 칸씩 당기기
                for(int j=i+1; j<v.size()-1; j++){
                    v.set(j, v.get(j+1));
                }
                if(v.size() > 1) v.remove(v.size()-1);  // 마지막 요소 제거
                
                // i부터 끝까지 연산자 한 칸씩 당기기
                for(int j=i; j<v2.size()-1; j++){
                    v2.set(j, v2.get(j+1));
                    vis[j] = vis[j+1];
                }
                if(v2.size() > 0) v2.remove(v2.size()-1);  // 마지막 연산자 제거
                
                // 인덱스 조정 (연산자를 하나 처리했으므로)
                i--;
            }
        }
    }
    
    public long solution(String expression) {
        long answer = 0;
        ret = 0;  // ret 초기화 추가
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<expression.length();++i){
            if(expression.charAt(i)=='-' || expression.charAt(i)=='*' || expression.charAt(i)=='+'){
                v.add(Long.parseLong(sb.toString()));  // Integer에서 Long으로 변경
                sb.setLength(0);
                v2.add(expression.charAt(i));
                continue;
            }
            sb.append(expression.charAt(i));
        }
        v.add(Long.parseLong(sb.toString())); //남은숫자
        
        ArrayList<Long> origin = new ArrayList<>(v);  // Integer에서 Long으로 변경
        ArrayList<Character> origin2 = new ArrayList<>(v2);  // 연산자 원본 저장 추가
        
        // 첫 번째 경우: * + -
        v = new ArrayList<>(origin);
        v2 = new ArrayList<>(origin2);
        Arrays.fill(vis, false);
        go('*');
        go('+');
        go('-');
        ret = Math.max(ret, Math.abs(v.get(0)));  // v의 마지막이 아닌 첫 번째 요소 사용
        
        // 두 번째 경우: * - +
        v = new ArrayList<>(origin);
        v2 = new ArrayList<>(origin2);
        Arrays.fill(vis, false);
        go('*');
        go('-');
        go('+');
        ret = Math.max(ret, Math.abs(v.get(0)));
        
        // 세 번째 경우: + * -
        v = new ArrayList<>(origin);
        v2 = new ArrayList<>(origin2);
        Arrays.fill(vis, false);
        go('+');
        go('*');
        go('-');
        ret = Math.max(ret, Math.abs(v.get(0)));
        
        // 네 번째 경우: + - *
        v = new ArrayList<>(origin);
        v2 = new ArrayList<>(origin2);
        Arrays.fill(vis, false);
        go('+');
        go('-');
        go('*');
        ret = Math.max(ret, Math.abs(v.get(0)));
        
        // 다섯 번째 경우: - + *
        v = new ArrayList<>(origin);
        v2 = new ArrayList<>(origin2);
        Arrays.fill(vis, false);
        go('-');
        go('+');
        go('*');
        ret = Math.max(ret, Math.abs(v.get(0)));
        
        // 여섯 번째 경우: - * +
        v = new ArrayList<>(origin);
        v2 = new ArrayList<>(origin2);
        Arrays.fill(vis, false);
        go('-');
        go('*');
        go('+');
        ret = Math.max(ret, Math.abs(v.get(0)));
        
        return ret;
    }
}