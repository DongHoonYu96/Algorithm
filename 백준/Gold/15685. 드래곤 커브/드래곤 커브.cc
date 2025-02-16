#include<bits/stdc++.h>
using namespace std; 

int ret;
int n,x,y,d,g;
vector<int> v[4][11]; //v[방향][세대] : { ... } 방향정보들
int dy[] = {0,-1,0,1}; // 오위좌아
int dx[] = {1,0,-1,0};
int vis[104][104];

void go(int x, int y, int d, int g) {
   int _x = x;
   int _y = y;
   vis[y][x]=1; //시작점 체크

   // 주의 : 0세대부터 g세대까지 다해야함
   for(int i=0;i<=g;++i) {
      for(auto dir : v[d][i]) {
         _x = _x + dx[dir];
         _y = _y + dy[dir];
         vis[_y][_x]=1;
      }
   }
   
}

void make() {
   //각 방향에대해
   for(int i=0;i<4;++i) {
      v[i][0].push_back(i);
      v[i][1].push_back((i+1)%4);
      //각 세대 채우기
      for(int j=2;j<=10;++j) {
         int back = v[i][j-1].size()-1;
         for(int k=back; k>=0;--k) { //이전값의 뒤부터 +1해서 붙이기
            v[i][j].push_back((v[i][j-1][k]+1)%4);
         }
         for(int k=0;k<v[i][j-1].size();++k) {
            v[i][j].push_back(v[i][j-1][k]); // 이전값을 그대로 이어붙이기
         }
      }   
   }
}

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);
   cin>>n;
   make();
   for(int i=0;i<n;++i) {
      cin>>x>>y>>d>>g;
      go(x,y,d,g);
   }

   for(int i=0;i<=103;++i) {
      for(int j=0;j<=103;++j) {
         if(vis[i][j] && vis[i][j+1] && vis[i+1][j] && vis[i+1][j+1]) ret++;
      }
   }

   cout<<ret;
}