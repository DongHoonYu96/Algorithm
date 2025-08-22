import java.util.*;

class Solution {
    
    static int N, len, ret = Integer.MAX_VALUE;
    static int[] Weak;
    static Integer[] Dist;
    
    void go(int cnt, int pos, int vis) {
        // 모든 구멍을 메운 경우
        if(vis == (1 << len) - 1) {
            ret = Math.min(ret, cnt);
            return;
        }
        
        // 사람을 다 써버린 경우
        if(cnt >= Dist.length) {
            return;
        }
        
        // 현재 사람이 커버할 수 있는 범위 계산
        int coverage = Dist[cnt];
        int newVis = vis;
        
        // pos부터 시계방향으로 coverage만큼 이동하며 구멍들을 메움
        for(int i = 0; i < len; ++i) {
            int currentPos = (pos + i) % len;
            
            // 거리 계산 (원형이므로 조심)
            int distance;
            if(pos + i < len) {
                distance = Weak[pos + i] - Weak[pos];
            } else {
                distance = Weak[pos + i] - Weak[pos];
            }
            
            if(distance > coverage) {
                break;
            }
            
            newVis |= (1 << currentPos);
        }
        
        // 모든 구멍을 메운 경우
        if(newVis == (1 << len) - 1) {
            ret = Math.min(ret, cnt + 1);
            return;
        }
        
        // 아직 메우지 못한 구멍에서 다음 사람 투입
        for(int i = 0; i < len; ++i) {
            if((newVis & (1 << i)) == 0) { // 아직 메우지 못한 구멍
                go(cnt + 1, i, newVis);
            }
        }
    }
    
    public int solution(int n, int[] weak, int[] dist) {
        N = n;
        len = weak.length;
        ret = Integer.MAX_VALUE;
        
        // 원형을 직선으로 변환 (배열 2배로 확장)
        Weak = new int[len * 2];
        for(int i = 0; i < len; ++i) {
            Weak[i] = weak[i];
            Weak[i + len] = weak[i] + n; // 한 바퀴 돈 것으로 처리
        }
        
        // 이동거리가 큰 순으로 정렬 (그리디)
        Dist = Arrays.stream(dist).boxed().toArray(Integer[]::new);
        Arrays.sort(Dist, (a, b) -> b - a);
        
        // 각 취약점에서 시작해보기
        for(int i = 0; i < len; ++i) {
            go(0, i, 0);
        }
        
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}