import java.util.*;

class Solution {
    // static 제거! → 각 테스트케이스마다 새롭게 생성됨
    private ArrayList<Integer> ret;
    private HashMap<String,String> parent;
    private HashMap<String,Integer> money;
    
    public void go(String name, int fee){
        if(name.equals("center")){
            return;
        }
        
        int susuryo = (int) (fee * 0.1);
        
        // 최적화: 수수료가 0원이면 더 이상 올려보낼 필요 없음
        if(susuryo == 0) {
            money.put(name, money.getOrDefault(name, 0) + fee);
            return;
        }
        
        int mine = fee - susuryo;
        money.put(name, money.getOrDefault(name, 0) + mine);
        
        String pname = parent.get(name);
        go(pname, susuryo);
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 매번 새로 초기화 (static이었다면 이것만으로는 부족했을 것)
        ret = new ArrayList<Integer>();
        parent = new HashMap<String,String>();
        money = new HashMap<String,Integer>();
        
        // 부모-자식 관계 설정
        int n = enroll.length;
        for(int i = 0; i < n; i++){
            String person = enroll[i];
            String referrer = referral[i];
            
            if(referrer.equals("-")){
                parent.put(person, "center");  // 최상위
            } else {
                parent.put(person, referrer);
            }
        }
        
        // 판매 정보 처리
        int m = seller.length;
        for(int i = 0; i < m; i++){
            int totalEarning = 100 * amount[i];  // 100원 단위
            String sellerName = seller[i];
            go(sellerName, totalEarning);
        }
        
        // 결과 배열 생성 (enroll 순서대로)
        for(int i = 0; i < n; i++){
            String name = enroll[i];
            int earning = money.getOrDefault(name, 0);
            ret.add(earning);
        }
        
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}