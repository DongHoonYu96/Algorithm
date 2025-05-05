import java.util.*;

class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        // 그래프 구성
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] p : path) {
            graph[p[0]].add(p[1]);
            graph[p[1]].add(p[0]);
        }
        
        // 선행 조건: prev[b] = a는 a를 방문한 후에 b를 방문해야 함
        int[] prev = new int[n];
        // 후행 노드: next[a] = b는 a를 방문한 후에 방문할 수 있는 b
        int[] next = new int[n];
        
        Arrays.fill(prev, -1);
        Arrays.fill(next, -1);
        
        for (int[] o : order) {
            prev[o[1]] = o[0];
            next[o[0]] = o[1];
            
            // 0번 방에 선행 조건이 있으면 불가능
            if (o[1] == 0) return false;
        }
        
        // 방문 여부
        boolean[] visited = new boolean[n];
        // 방문했지만 선행 조건을 만족하지 못한 노드
        boolean[] waiting = new boolean[n];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            // 현재 노드 방문으로 해제되는 후행 노드 확인
            if (next[cur] != -1 && waiting[next[cur]]) {
                queue.offer(next[cur]);
                waiting[next[cur]] = false;
            }
            
            // 인접 노드 탐색
            for (int nxt : graph[cur]) {
                if (visited[nxt]) continue;
                
                if (prev[nxt] != -1 && !visited[prev[nxt]]) {
                    // 선행 조건이 아직 만족되지 않음
                    visited[nxt] = true;
                    waiting[nxt] = true;
                } else {
                    // 방문 가능
                    visited[nxt] = true;
                    queue.offer(nxt);
                }
            }
        }
        
        // 모든 노드 방문 가능 여부 확인
        for (int i = 0; i < n; i++) {
            if (!visited[i] || waiting[i]) return false;
        }
        
        return true;
    }
}