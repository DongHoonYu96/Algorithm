import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long k;
    static long[] satisfaction;
    static long[] dp;
    static boolean[] eating;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());
        
        satisfaction = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            satisfaction[i] = Long.parseLong(st.nextToken());
        }
        
        // dp[i]: i번째 인덱스부터 시작했을 때 최대 탈피 에너지
        dp = new long[n + 1];
        Arrays.fill(dp, -1);
        
        System.out.println(getMaxEnergy(0));
    }
    
    // idx 위치부터 시작해서 얻을 수 있는 최대 탈피 에너지
    static long getMaxEnergy(int idx) {
        // 기저 조건: 모든 먹이를 고려한 경우
        if (idx >= n) {
            return 0;
        }
        
        // 이미 계산된 결과가 있으면 재사용
        if (dp[idx] != -1) {
            return dp[idx];
        }
        
        // 1. 현재 위치에서 먹기 시작하는 경우
        long maxEnergy = tryEatingFrom(idx);
        
        // 2. 현재 위치의 먹이를 건너뛰는 경우
        maxEnergy = Math.max(maxEnergy, getMaxEnergy(idx + 1));
        
        // 결과 저장 및 반환
        return dp[idx] = maxEnergy;
    }
    
    // startIdx 위치에서 먹기 시작할 때 얻을 수 있는 최대 탈피 에너지
    static long tryEatingFrom(int startIdx) {
        long totalEnergy = 0;
        long accSatisfaction = 0;
        int endIdx = startIdx;
        
        // 연속적으로 먹으면서 만족도 누적
        while (endIdx < n) {
            accSatisfaction += satisfaction[endIdx];
            
            // 최소 만족도를 달성한 경우
            if (accSatisfaction >= k) {
                // 탈피 에너지 계산
                long energy = accSatisfaction - k;
                totalEnergy += energy;
                
                // 다음 위치부터 최대 탈피 에너지 계산해서 더함
                totalEnergy += getMaxEnergy(endIdx + 1);
                break;
            }
            
            endIdx++;
        }
        
        return totalEnergy;
    }
}