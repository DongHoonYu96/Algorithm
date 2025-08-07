import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        
        var m1 = new HashMap<String, Integer>(); // <조합, 등장횟수>
        
        for(var order : orders) {
            // 각 주문을 정렬하여 일관성 보장
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            String sortedOrder = new String(chars);
            
            int n = sortedOrder.length();
            
            // 모든 부분집합 생성 (공집합 제외)
            for(int subset = 1; subset < (1 << n); subset++) {
                var sb = new StringBuilder();
                
                for(int i = 0; i < n; i++) {
                    if((subset & (1 << i)) > 0) {
                        sb.append(sortedOrder.charAt(i));
                    }
                }
                
                String combination = sb.toString();
                
                m1.put(combination, m1.getOrDefault(combination, 0) + 1);
                // course 배열에 포함된 길이만 고려 (없어도 통과하긴함)
                // if(Arrays.stream(course).anyMatch(c -> c == combination.length())) {
                //     m1.put(combination, m1.getOrDefault(combination, 0) + 1);
                // }
            }
        }
        
        var answer = new ArrayList<String>();
        
        // 각 코스 길이별로 처리
        for(int courseLength : course) {
            // 해당 길이의 조합들 중 최대 빈도 찾기
            int maxCount = m1.entrySet().stream()
            .filter(e -> e.getKey().length() == courseLength)  // "AB":3, "BC":2, "AC":3
            .filter(e -> e.getValue() >= 2)         // "AB":3, "BC":2, "AC":3 (모두 2 이상)
            .mapToInt(Map.Entry::getValue)          // [3, 2, 3]
            .max()                                  // OptionalInt[3]
            .orElse(0);                            // 3
            
            // 최대 빈도를 가진 모든 조합 추가
            if(maxCount >= 2) {
                m1.entrySet().stream()
                    .filter(e -> e.getKey().length() == courseLength) // "AB":3, "BC":2, "AC":3
                    .filter(e -> e.getValue() == maxCount)           // "AB":3,"AC":3 (maxCount=3)
                    .map(Map.Entry::getKey)                          // ["AB", "AC"]
                    .forEach(answer::add);
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
}