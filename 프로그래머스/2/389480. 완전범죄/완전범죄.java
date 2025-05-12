import java.util.*;

class Solution {
    static int n, m;
    static Integer[][][] dp;
    
    int dfs(int idx, int a, int b, int[][] info) {
        // 기저 사례: 모든 요소를 처리한 경우
        if (idx == info.length) {
            return (a <= 0 || b <= 0) ? Integer.MAX_VALUE : Math.abs(n - a);
        }
        
        // 유효하지 않은 상태
        if (a <= 0 || b <= 0) {
            return Integer.MAX_VALUE;
        }
        
        // 이미 계산된 값이 있으면 반환
        if (dp[idx][a][b] != null) {
            return dp[idx][a][b];
        }
        
        // 현재 요소를 처리하는 두 가지 방법 시도
        int result = Math.min(
            dfs(idx + 1, a - info[idx][0], b, info),
            dfs(idx + 1, a, b - info[idx][1], info)
        );
        
        // 결과 저장 및 반환
        return dp[idx][a][b] = result;
    }
    
    public int solution(int[][] info, int _n, int _m) {
        n = _n;
        m = _m;
        
        // 필요한 크기만큼만 DP 배열 초기화 (null로 초기화됨)
        dp = new Integer[info.length + 1][n + 1][m + 1];
        
        int result = dfs(0, n, m, info);
        
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }
}