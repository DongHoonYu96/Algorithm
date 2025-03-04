#include<bits/stdc++.h>
using namespace std; 

int n,m,t,ret, a[54][54], vis[54][54];
int x,d,k, found;
vector<int> v[54];
const int dy[] = {-1, 0, 1, 0};  // 상, 우, 하, 좌 (y 방향)
const int dx[] = {0, 1, 0, -1};

void calc() {
   for(int i=0;i<n;++i) {
      for(int j=0;j<m;++j) {
         ret+=v[i][j];
      }
   }
}
void print() {
   for(int i=0;i<n;++i) {
      for(int j=0;j<m;++j) {
         cout<<v[i][j]<<" ";
      }cout<<"\n";
   }
}
// idx먼째 벡터를 회전시키는 함수
void go(int idx) {
   if (d == 1) {
      rotate(v[idx].begin(), v[idx].begin() + k, v[idx].end());
   } else {
      rotate(v[idx].begin(), v[idx].begin() + v[idx].size() - k, v[idx].end());
   }
   // print();
   
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

// void calcAvg() {
//    //평균계산
//    int sum=0; int cnt=0;
//    for(int i=0;i<n;++i) {
//       for(int j=0;j<m;++j) {
//          sum+=v[i][j];
//          if(v[i][j]!=0) cnt++;
//       }
//    }
//    double avg = (double)sum/(double)cnt;
//
//    // 더하기
//    for(int i=0;i<n;++i) {
//       for(int j=0;j<m;++j) {
//          if(v[i][j]==0) continue;
//          if((double)v[i][j]>avg) {
//             v[i][j]--;
//          }
//          if((double)v[i][j] < avg) {
//             v[i][j]++;
//          }
//       }
//    }
// }

void dfs(int y, int x) {
   for(int i=0;i<4;++i) {
      int ny=y+dy[i];
      int nx=(x+dx[i]+m)%m; // ???

      if(ny<0 || ny>=n) continue;
      if(vis[ny][nx]) continue;

      if(v[y][x]==v[ny][nx]) {
         vis[y][x]=vis[ny][nx]=1;
         found=1;
         dfs(ny,nx);
      }
   }
}

void findAdj() {
   found=0;
   memset(vis,0,sizeof(vis));

   for(int i=0;i<n;++i) {
      for(int j=0;j<m;++j) {
         if(v[i][j]==0) continue;
         if(vis[i][j]) continue;
         dfs(i,j);
      }
   }

   for(int i=0;i<n;++i) {
      for(int j=0;j<m;++j) {
         if(vis[i][j]) {
            v[i][j]=0;
         }
      }
   }
}

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>n>>m>>t;
   for(int i=0;i<n;++i) {
      for(int j=0;j<m;++j) {
         int tmp;
         cin>>tmp;
         v[i].push_back(tmp);
      }
   }

   for(int i=0;i<t;++i) {
      cin>>x>>d>>k;
      for(int j=0;j<n;++j) {
         if((j+1)%x==0) {
            // cout<<"rotate "<<j<<"\n";
            go(j);
         }
      }
      findAdj();
      // searchUpDown();
      // searchLeftRight();
      if(!found) {
         calcAvg();
      }
   }
   calc();
   // print();
   cout<<ret;
}