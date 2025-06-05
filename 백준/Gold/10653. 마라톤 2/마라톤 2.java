import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] x, y;
    // dp[idx][used] = idx 위치에서 지금까지 used개를 건너뛰고
    // 마지막(N-1)까지 갈 때의 최소 거리
    static long[][] dp;
    static boolean[][] visited;
    static final long INF = Long.MAX_VALUE / 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        x = new int[N];
        y = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        // DP 배열과 방문 체크 배열 초기화
        dp = new long[N][K + 1];
        visited = new boolean[N][K + 1];

        // dp 값을 전부 INF로 채워두면 좋지만, visited[]를 통해 확인하므로
        // 생략하고, 필요한 순간에만 값을 갱신하도록 한다.

        long answer = solve(0, 0);
        System.out.println(answer);
    }

    // idx: 현재 체크포인트 인덱스 (0-based)
    // used: 지금까지 건너뛴 체크포인트 개수
    private static long solve(int idx, int used) {
        // 기저 사례: 마지막 체크포인트(N-1)까지 왔다면 더 이동할 거리가 없으므로 0 반환
        if (idx == N - 1) {
            return 0;
        }

        // 이미 계산한 상태가 있으면 그대로 반환
        if (visited[idx][used]) {
            return dp[idx][used];
        }
        visited[idx][used] = true;

        long ret = INF;
        // 다음으로 이동할 후보 t (idx < t < N)
        for (int t = idx + 1; t < N; t++) {
            // idx → t 로 가면 (t - idx - 1) 개를 건너뛰게 된다
            int skipCnt = t - idx - 1;
            if (used + skipCnt > K) {
                // 이미 건너뛴 개수 + 이번에 건너뛸 개수가 K 초과면 불가능
                continue;
            }
            long cost = manhattan(idx, t) + solve(t, used + skipCnt);
            if (cost < ret) {
                ret = cost;
            }
        }

        dp[idx][used] = ret;
        return ret;
    }

    // 두 체크포인트 i, j 사이의 맨해튼 거리 계산
    private static long manhattan(int i, int j) {
        return Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
    }
}
