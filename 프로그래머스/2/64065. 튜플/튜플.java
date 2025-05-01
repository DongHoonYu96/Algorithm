import java.util.*;

class Solution {
    static ArrayList<Integer> v = new ArrayList<>();
    public int[] solution(String s) {
        // 1) 외부 중괄호 제거
        String trimmed = s.substring(2, s.length() - 2);
        // System.out.println(trimmed);
        
        // 2) "},{"로 분리하여 각 집합 문자열 획득
        String[] parts = trimmed.split("\\},\\{");
        // for(String part : parts){
        //     System.out.println(part);
        // }
        
        // 3) 원소 개수 기준으로 정렬
        Arrays.sort(parts, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });
        
        // 4) 순서대로 숫자 추출
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (String part : parts) {
            String[] nums = part.split(",");
            for (String num : nums) {
                set.add(Integer.parseInt(num));
            }
        }
        
        // 5) LinkedHashSet을 int[]로 변환
        int[] answer = new int[set.size()];
        int idx = 0;
        for (int num : set) {
            answer[idx++] = num;
        }
        
        return answer;
    }
}