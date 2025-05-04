import java.util.*;

class Solution {
    // 상수 정의
    private static final int STRAIGHT_COST = 100; // 직선 도로 비용
    private static final int CORNER_COST = 500; // 코너 추가 비용
    
    // 방향 정의 (상, 우, 하, 좌)
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    
    // DFS로 푸는 방법
    public int solution(int[][] board) {
        int n = board.length;
        
        // 방문 비용 배열: [y][x][이전 방향]에 도달하는 최소 비용
        // 이전 방향: 0(상), 1(우), 2(하), 3(좌), 4(처음 시작)
        int[][][] costs = new int[n][n][5];
        
        // 비용 배열 초기화 (최댓값으로)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(costs[i][j], Integer.MAX_VALUE);
            }
        }
        
        // 시작점 초기화
        costs[0][0][4] = 0; // 시작점은 비용 0, 이전 방향은 없음(4)
        
        // DFS 호출
        dfs(board, costs, 0, 0, 4, 0, n);
        
        // 도착점에 도달하는 최소 비용 찾기
        int minCost = Integer.MAX_VALUE;
        for (int dir = 0; dir < 5; dir++) {
            if (costs[n-1][n-1][dir] < minCost) {
                minCost = costs[n-1][n-1][dir];
            }
        }
        
        return minCost;
    }
    
    private void dfs(int[][] board, int[][][] costs, int y, int x, int prevDir, int cost, int n) {
        // 기저 사례: 현재 위치가 도착점인 경우
        if (y == n-1 && x == n-1) {
            return;
        }
        
        // 네 방향 탐색
        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            
            // 범위 체크 및 벽 체크
            if (ny < 0 || ny >= n || nx < 0 || nx >= n || board[ny][nx] == 1) continue;
            
            // 비용 계산 (직선 도로 비용 + 필요시 코너 비용)
            int newCost = cost + STRAIGHT_COST;
            
            // 방향이 바뀌었고, 처음이 아니면 코너 비용 추가
            if (prevDir != 4 && prevDir != dir) {
                newCost += CORNER_COST;
            }
            
            // 더 적은 비용으로 도달할 수 있으면 업데이트하고 DFS 계속 진행
            if (newCost < costs[ny][nx][dir]) {
                costs[ny][nx][dir] = newCost;
                dfs(board, costs, ny, nx, dir, newCost, n);
            }
        }
    
        
        // 도착점에 도달하는 최소 비용 찾기
        int minCost = Integer.MAX_VALUE;
        for (int dir = 0; dir < 5; dir++) {
            if (costs[n-1][n-1][dir] < minCost) {
                minCost = costs[n-1][n-1][dir];
            }
        }
        
        return;
    }
}
