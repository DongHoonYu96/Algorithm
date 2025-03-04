#include<bits/stdc++.h>
using namespace std; 

int n,m,t,ret, a[54][54], vis[54][54];
int x,d,k, found;
vector<int> v[54];
const int dy[] = {-1, 0, 1, 0};  // 상, 우, 하, 좌 (y 방향)
const int dx[] = {0, 1, 0, -1};

void calc() {
   ret = 0;
   for(int i=0;i<n;++i) {
      for(int j=0;j<m;++j) {
         ret += v[i][j];
      }
   }
}

void go(int idx) {
   int mod_k = k % m;
   if (mod_k == 0) return; // 회전할 필요 없음
   if (d == 1) { // 반시계 방향
      rotate(v[idx].begin(), v[idx].begin() + mod_k, v[idx].end());
   } else { // 시계 방향
      rotate(v[idx].begin(), v[idx].begin() + (m - mod_k), v[idx].end());
   }
}

void calcAvg() {
   int sum=0, cnt=0;
   for(int i=0;i<n;++i) {
      for(int j=0;j<m;++j) {
         sum += v[i][j];
         if(v[i][j] != 0) cnt++;
      }
   }
   if (cnt == 0) return; // 모든 수가 0인 경우 처리
   for(int i=0;i<n;++i) {
      for(int j=0;j<m;++j) {
         if(v[i][j] == 0) continue;
         if(v[i][j] * cnt > sum) {
            v[i][j]--;
         } else if(v[i][j] * cnt < sum) {
            v[i][j]++;
         }
      }
   }
}

void dfs(int y, int x) {
   for(int i=0;i<4;++i) {
      int ny = y + dy[i];
      int nx = (x + dx[i] + m) % m;

      if(ny < 0 || ny >= n) continue;
      if(vis[ny][nx]) continue;

      if(v[y][x] == v[ny][nx] && v[y][x] != 0) {
         vis[y][x] = vis[ny][nx] = 1;
         found = 1;
         dfs(ny, nx);
      }
   }
}

void findAdj() {
   memset(vis, 0, sizeof(vis));
   found = 0;

   for(int i=0;i<n;++i) {
      for(int j=0;j<m;++j) {
         if(v[i][j] == 0 || vis[i][j]) continue;
         dfs(i, j);
      }
   }

   for(int i=0;i<n;++i) {
      for(int j=0;j<m;++j) {
         if(vis[i][j]) {
            v[i][j] = 0;
         }
      }
   }
}

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin >> n >> m >> t;
   for(int i=0;i<n;++i) {
      for(int j=0;j<m;++j) {
         int tmp;
         cin >> tmp;
         v[i].push_back(tmp);
      }
   }

   for(int i=0;i<t;++i) {
      cin >> x >> d >> k;
      k %= m; // k를 m으로 나눈 나머지로 조정
      for(int j=0;j<n;++j) {
         if((j+1) % x == 0) {
            go(j);
         }
      }
      findAdj();
      if(!found) {
         calcAvg();
      }
   }
   calc();
   cout << ret;
}