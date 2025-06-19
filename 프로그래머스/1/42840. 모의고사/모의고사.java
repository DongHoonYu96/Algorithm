import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> ret = new ArrayList<>();
        
        ArrayList<Integer> v1 = new ArrayList<>();
        ArrayList<Integer> v2 = new ArrayList<>();
        ArrayList<Integer> v3 = new ArrayList<>();
        
        ArrayList<Integer> arr2 = new ArrayList<>(List.of(2,1,2,3,2,4,2,5));
        ArrayList<Integer> arr3 = new ArrayList<>(List.of(3,3,1,1,2,2,4,4,5,5));
        
        for(int i=0;i<10000;++i){
            v1.add((i%5)+1);
        }
        for(int i=0;i<10000;++i){
            v2.add(arr2.get(i%arr2.size()));
        }
        for(int i=0;i<10000;++i){
            v3.add(arr3.get(i%arr3.size()));
        }
        
        int cnt1=0;
        int cnt2=0;
        int cnt3=0;
        
        int n = answers.length;
        
        for(int i=0;i<n;++i){
            if(answers[i]==v1.get(i)) cnt1++;
            if(answers[i]==v2.get(i)) cnt2++;
            if(answers[i]==v3.get(i)) cnt3++;
        }
        
        int mx = Math.max(cnt1,cnt2);
        mx = Math.max(mx,cnt3);
        
        if(mx==cnt1) ret.add(1);
        if(mx==cnt2) ret.add(2);
        if(mx==cnt3) ret.add(3);
        
        return ret.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}