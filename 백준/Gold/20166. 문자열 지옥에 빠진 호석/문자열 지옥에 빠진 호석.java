import java.io.*;
import java.util.*;

public class Main {

    static int ret, n, m, k;
    static char[][] arr = new char[14][14];
    static int[] dx = {0, 1, 0, -1, -1, 1, -1, 1};
    static int[] dy = {1, 0, -1, 0, -1, 1, 1, -1};
    static Map<String, Integer> cache = new HashMap<>();
    static char[] path = new char[14]; // 최대 문자열 길이를 고려한 버퍼

    static void dfs(int y, int x, int depth, String target) {
        // 현재 문자를 path에 저장
        path[depth] = arr[y][x];
        
        // 목표 길이에 도달했는지 확인
        if (depth + 1 == target.length()) {
            // 문자열 비교
            boolean match = true;
            for (int i = 0; i < target.length(); i++) {
                if (path[i] != target.charAt(i)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                ret++;
            }
            return;
        }

        for (int i = 0; i < 8; ++i) {
            int ny = (y + dy[i] + n) % n; // 좌표 계산 최적화
            int nx = (x + dx[i] + m) % m;
            dfs(ny, nx, depth + 1, target);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < n; ++i) {
            String tmp = br.readLine();
            for (int j = 0; j < m; ++j) {
                arr[i][j] = tmp.charAt(j);
            }
        }

        for (int q = 0; q < k; ++q) {
            String target = br.readLine();
            
            // 캐시에서 결과 확인
            if (cache.containsKey(target)) {
                bw.write(cache.get(target) + "\n");
                continue;
            }
            
            // 캐시에 없는 경우 계산
            ret = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    dfs(i, j, 0, target);
                }
            }
            
            // 결과를 캐시에 저장
            cache.put(target, ret);
            bw.write(ret + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}