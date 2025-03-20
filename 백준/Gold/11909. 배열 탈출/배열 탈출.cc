#include <bits/stdc++.h>
using namespace std; 

typedef long long ll;

int n;
int dist[2224][2224], a[2224][2224];
int INF = 987654321;
priority_queue<tuple<int, int, int>, vector<tuple<int, int, int>>, 
   greater<tuple<int, int, int>>> pq;

int main() {
   ios_base::sync_with_stdio(false);
   cin.tie(nullptr); cout.tie(nullptr);

   cin >> n;

   // 전체 dist 배열을 INF로 초기화 (n*n만큼 초기화해도 되지만 배열 크기 그대로 사용)
   fill(&dist[0][0], &dist[0][0] + 2224 * 2224, INF);

   for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
         cin >> a[i][j];
      }
   }

   // 시작점 초기화
   dist[0][0] = 0;
   pq.push({0, 0, 0});

   while (!pq.empty()) {
      auto [w, y, x] = pq.top();
      pq.pop();

      if (dist[y][x] != w) continue; // 느긋한 삭제

      // 동적 이웃 계산: 오른쪽과 아래쪽만 가능
      // 아래쪽 이동
      if (y + 1 < n) {
         int ny = y + 1, nx = x;
         int cost = 0;
         if (a[y][x] > a[ny][nx])
            cost = 0;
         else if (a[y][x] == a[ny][nx])
            cost = 1;
         else 
            cost = abs(a[y][x] - a[ny][nx]) + 1;
         if (dist[ny][nx] > dist[y][x] + cost) {
            dist[ny][nx] = dist[y][x] + cost;
            pq.push({dist[ny][nx], ny, nx});
         }
      }
      
      // 오른쪽 이동
      if (x + 1 < n) {
         int ny = y, nx = x + 1;
         int cost = 0;
         if (a[y][x] > a[ny][nx])
            cost = 0;
         else if (a[y][x] == a[ny][nx])
            cost = 1;
         else 
            cost = abs(a[y][x] - a[ny][nx]) + 1;
         if (dist[ny][nx] > dist[y][x] + cost) {
            dist[ny][nx] = dist[y][x] + cost;
            pq.push({dist[ny][nx], ny, nx});
         }
      }
   }
   
   cout << dist[n-1][n-1];
   return 0;
}
