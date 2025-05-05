import java.util.*;

public class Solution {
    // 최대 노드 수만큼 여유를 두거나 n으로 초기화해도 좋습니다
    private List<Integer>[] adj;    // 방향 그래프 인접 리스트
    private int[] indegree;         // 각 노드 진입차수

    // 양방향 경로(path)와 순서 제약(order)로부터
    // 단방향 위상정렬용 그래프를 빌드
    private void buildUnidirGraph(int n, int[][] path, int[][] order) {
        adj = new ArrayList[n];
        indegree = new int[n];
        // 1) 인접 리스트 초기화
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // 2) 양방향 트리를 BFS로 방향화
        boolean[] seen = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        // 루트 0부터 시작
        seen[0] = true;
        q.offer(0);
        // 편의를 위해 양방향 인접 리스트를 한 번 만듭니다
        List<Integer>[] undirected = new ArrayList[n];
        for (int i = 0; i < n; i++) undirected[i] = new ArrayList<>();
        for (int[] p : path) {
            undirected[p[0]].add(p[1]);
            undirected[p[1]].add(p[0]);
        }
        // BFS 순회하며 트리 간선만 방향화
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : undirected[u]) {
                if (!seen[v]) {
                    seen[v] = true;
                    adj[u].add(v);      // u → v 방향으로 추가
                    indegree[v]++;      // v 진입차수 증가
                    q.offer(v);
                }
            }
        }

        // 3) 순서 제약(order)을 가상 간선으로 추가
        for (int[] o : order) {
            int a = o[0], b = o[1];
            adj[a].add(b);            // A → B
            indegree[b]++;            // B 진입차수 증가
        }
    }

    // 위상정렬로 전체 탐색 가능 여부 판단
    public boolean solution(int n, int[][] path, int[][] order) {
        buildUnidirGraph(n, path, order);

        // 4) Kahn’s Algorithm: 큐 초기화
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // 5) 큐에서 하나씩 꺼내며 진입차수 감소
        int visitedCount = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            visitedCount++;
            for (int v : adj[u]) {
                if (--indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        // 6) 방문한 노드 수가 전체 n과 같아야 성공
        return visitedCount == n;
    }

}
