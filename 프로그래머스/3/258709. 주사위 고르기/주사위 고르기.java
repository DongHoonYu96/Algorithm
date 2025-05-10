import java.util.*;

class Solution {
    static int n;
    static int[][] dice = new int[11][6];
    
    void dfs(int depth, int sum, ArrayList<Integer> v, ArrayList<Integer> arrA){
        if(depth==v.size()){
            arrA.add(sum);
            return;
        }
        
        for(int i=0;i<6;++i){
            dfs(depth+1,sum+dice[v.get(depth)][i],v,arrA);
        }
    }
    
    int lower_bound(ArrayList<Integer> v, int x){
        int st=0;
        int en=v.size()-1;
        int ret=0;
        while(st<en){
            int mid = (st+en)/2;
            if(v.get(mid) >= x){ //mid가 크다 -> 정렬되있으므로 mid앞쪽에 정답후보
                ret=mid;
                en=mid;
            }
            else{
                // mid가 작다 -> 정렬되있으므로 mid이하는 볼 필요가없음.
                st=mid+1;  
            }
        }
        return ret;
    }
    
    public static int lowerBound(ArrayList<Integer> v, int x) {
        int lo = 0;
        int hi = v.size();                       // hi = n
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);     // 오버플로우 방지 :contentReference[oaicite:3]{index=3}
            if (v.get(mid) < x) {
                lo = mid + 1;                    // mid 이하 영역 제거
            } else {
                hi = mid;                        // mid 포함 왼쪽 영역 유지
            }
        }
        return lo;                               // lo == hi가 lower bound
    }
    
    public int[] solution(int[][] _dice) {
        
        // System.out.println(Math.pow(6,10)); //6천만
        // //10C5 = 18*14 = 252
        // System.out.println(Math.log(Math.pow(6,5)));
        // double a = Math.pow(6,5);
        // double b = Math.log(Math.pow(6,5));
        // System.out.println(252*(a+a+a*b*2+b));
        dice=_dice;
        n=dice.length;
        int[] answer = new int[n/2];
        
        int maxW=0;
        
        for(int subset=0;subset<(1<<n)-1;++subset){
            int cnt=0;

            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();
            for(int i=0;i<n;++i){
                if((subset & (1<<i)) >0){
                    cnt++;
                    A.add(i);
                }
                else{
                    B.add(i);
                }
            }
            if(cnt==n/2){
                // System.out.println(A);
                ArrayList<Integer> arrA = new ArrayList<>();
                ArrayList<Integer> arrB = new ArrayList<>();
                dfs(0,0,A,arrA);
                dfs(0,0,B,arrB);
                // System.out.println(arrA);
                // System.out.println(arrB);
                
                Collections.sort(arrA);
                Collections.sort(arrB);
                int winA=0;
                for(int x : arrA){
                    int idx = lowerBound(arrB,x);
                    winA+=idx;
                    // int idx = Collections.binarySearch(arrB, x);
                    // int lb  = (idx >= 0) ? idx : -idx - 1;
                    // winA+=lb;
                }
                if(winA > maxW){
                    System.out.print(winA);
                    System.out.println(A);
                    maxW=winA;
                    for(int i=0;i<A.size();++i){
                        answer[i]=A.get(i)+1;
                    }
                }
            }
        }
        
        // ArrayList<Integer> arrA = new ArrayList<>();
        // arrA.add(0); arrA.add(2); arrA.add(4); arrA.add(4);
        // int q = lower_bound(arrA,3);
        // System.out.println(q);
        return answer;
    }
}