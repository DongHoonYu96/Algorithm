import java.util.*;

public class A {
    int node;
    int weight;
    int state; // 트랩 상태를 저장

    A(int node, int weight, int state) {
        this.node = node;
        this.weight = weight;
        this.state = state;
    }
    
    @Override
    public String toString() {
        return "노드: " + this.node + ", 가중치: " + this.weight + ", 상태: " + this.state;
    }
}

class Solution {
    
    // 트랩인지 확인하는 메소드
    boolean isTrap(int node, int[] traps) {
        for (int trap : traps) {
            if (node == trap) return true;
        }
        return false;
    }
    
    // 트랩의 인덱스를 찾는 메소드
    int getTrapIndex(int node, int[] traps) {
        for (int i = 0; i < traps.length; i++) {
            if (node == traps[i]) return i;
        }
        return -1;
    }
    
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        // 트랩의 최대 개수 (최대 10개로 가정)
        int maxTraps = traps.length;
        int maxStates = 1 << maxTraps; // 모든 트랩 상태의 조합 (2^maxTraps)
        
        // 거리 배열: [노드][상태]
        int[][] dist = new int[n + 1][maxStates];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        // 그래프 초기화
        int[][] normalGraph = new int[n + 1][n + 1]; // 정방향 간선
        int[][] reverseGraph = new int[n + 1][n + 1]; // 역방향 간선
        
        for (int i = 0; i <= n; i++) {
            Arrays.fill(normalGraph[i], Integer.MAX_VALUE);
            Arrays.fill(reverseGraph[i], Integer.MAX_VALUE);
        }
        
        // 간선 정보 추가
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            
            // 더 작은 가중치 선택
            normalGraph[u][v] = Math.min(normalGraph[u][v] == Integer.MAX_VALUE ? w : normalGraph[u][v], w);
            reverseGraph[v][u] = Math.min(reverseGraph[v][u] == Integer.MAX_VALUE ? w : reverseGraph[v][u], w);
        }
        
        // 다익스트라 알고리즘
        dist[start][0] = 0;
        PriorityQueue<A> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new A(start, 0, 0));
        
        while (!pq.isEmpty()) {
            A current = pq.poll();
            int curNode = current.node;
            int curWeight = current.weight;
            int curState = current.state;
            
            // 현재 상태에서의 최단 거리가 아니면 스킵
            if (dist[curNode][curState] < curWeight) continue;
            
            // 목적지에 도달했으면 종료
            if (curNode == end) return curWeight;
            
            // 현재 노드와 연결된 모든 노드 확인
            for (int nextNode = 1; nextNode <= n; nextNode++) {
                if (curNode == nextNode) continue; // 자기 자신으로 가는 경우 제외
                
                // 현재 노드와 다음 노드의 트랩 상태 확인
                boolean curNodeTrapped = isTrap(curNode, traps) && 
                    ((curState & (1 << getTrapIndex(curNode, traps))) != 0);
                boolean nextNodeTrapped = isTrap(nextNode, traps) && 
                    ((curState & (1 << getTrapIndex(nextNode, traps))) != 0);
                
                // 간선 방향 결정
                boolean isReversed = curNodeTrapped ^ nextNodeTrapped;
                int weight = isReversed ? reverseGraph[curNode][nextNode] : normalGraph[curNode][nextNode];
                
                if (weight == Integer.MAX_VALUE) continue; // 해당 방향으로 간선이 없음
                
                // 다음 상태 계산 (트랩 방문 시 상태 토글)
                int nextState = curState;
                if (isTrap(nextNode, traps)) {
                    nextState ^= (1 << getTrapIndex(nextNode, traps)); // 해당 트랩 비트 토글
                }
                
                // 더 짧은 경로 발견 시 갱신
                if (dist[nextNode][nextState] > dist[curNode][curState] + weight) {
                    dist[nextNode][nextState] = dist[curNode][curState] + weight;
                    pq.offer(new A(nextNode, dist[nextNode][nextState], nextState));
                }
            }
        }
        
        // 목적지에 도달할 수 없는 경우
        return -1;
    }
}