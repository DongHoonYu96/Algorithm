import java.util.*;

class Pair {
    int y, x;
    Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    static int n, m;
    static char[][] arr = new char[54][54];
    static int[] dy = {0, 1, -1, 0};
    static int[] dx = {1, 0, 0, -1};

    // 길이가 2 이상인 요청: crane
    void crain(String s) {
        char c = s.charAt(0);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == c) {
                    arr[i][j] = '0';
                }
            }
        }
    }

    // 길이가 1인 요청: BFS로 빈 공간의 외부 접근성 계산 후 제거
    void go(String s) {
        char target = s.charAt(0);
        boolean[][] vis = new boolean[n+2][m+2];
        Queue<Pair> q = new LinkedList<>();

        // 1) 경계에 있는 '0'들(외부와 곧장 연결된 빈 공간) 큐에 넣기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == '0' && (i == 1 || i == n || j == 1 || j == m)) {
                    vis[i][j] = true;
                    q.offer(new Pair(i, j));
                }
            }
        }

        // 2) BFS로 바깥과 연결된 모든 빈 공간(mark visited) 찾기
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int k = 0; k < 4; k++) {
                int ny = p.y + dy[k], nx = p.x + dx[k];
                if (ny >= 1 && ny <= n && nx >= 1 && nx <= m
                    && !vis[ny][nx] && arr[ny][nx] == '0') {
                    vis[ny][nx] = true;
                    q.offer(new Pair(ny, nx));
                }
            }
        }

        // 3) 목표 문자(target)의 각 위치에서 주변에 vis==true(또는 경계 밖)이 있으면 제거
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == target) {
                    boolean removable = false;
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k], nx = j + dx[k];
                        // 경계 밖이면 즉시 제거 가능
                        if (ny <= 0 || nx <= 0 || ny > n || nx > m) {
                            removable = true;
                            break;
                        }
                        // BFS로 방문된 빈 공간과 인접해 있으면 제거 가능
                        if (vis[ny][nx]) {
                            removable = true;
                            break;
                        }
                    }
                    if (removable) {
                        arr[i][j] = '0';
                    }
                }
            }
        }
    }

    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();

        // 입력 문자열을 1-based char 배열로 복사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i+1][j+1] = storage[i].charAt(j);
            }
        }

        // 모든 요청 처리
        for (String req : requests) {
            if (req.length() >= 2) {
                crain(req);
            } else {
                go(req);
            }
        }

        // 남아 있는 물건 개수 세기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] != '0') answer++;
            }
        }
        return answer;
    }
}
