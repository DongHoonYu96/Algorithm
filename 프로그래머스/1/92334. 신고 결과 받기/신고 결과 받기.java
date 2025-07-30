import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];
        
        HashMap<String,Integer> m1 = new HashMap<>();
        HashMap<String,HashSet<String>> m2 = new HashMap<>();
        HashMap<String,Integer> idxMap = new HashMap<>();
        
        for(int i=0;i<n;++i){
            idxMap.put(id_list[i],i);    
        }
        
        for(var id : id_list){
            m1.put(id,0);    
            m2.put(id, new HashSet<String>());
        }
        for(var r : report){
            var arr = r.split(" ");
            var a = arr[0];
            var b = arr[1];
            //a가 b를 신고함
            
            // 중복신고
            if(m2.get(a).contains(b)){
                continue;
            }
            
            m2.get(a).add(b);
            m1.put(b,m1.get(b)+1);
        }
        
        // System.out.println(m1);
        // System.out.println(m2);
        
        m1.entrySet().stream()
          .filter(e -> e.getValue() >= k)   // m1에서 값이 !k! 이상인 엔트리
          .map(Map.Entry::getKey)           // 키만 꺼내서
          .forEach(key -> {
              // key를 사용해 m2 처리, key : 2회이상 신고당한 id
              for(var m2key : m2.keySet()){
                  if(m2.get(m2key).contains(key)){
                      answer[idxMap.get(m2key)]++;
                  }
              }
          });
        
        return answer;
    }
}