#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

int n,m,k,ret=-1;
int vis[204][204][34], arr[204][204];
int dy[]={0,1,-1,0};
int dx[]={1,0,0,-1};
int dy2[]={-2,-2,-1,-1,1,1,2,2};
int dx2[]={-1,1,-2,2,-2,2,-1,1};

struct A {
  int y,x,cnt,dist; 
};

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin>>k>>m>>n;
    
    for(int i=0;i<n;++i) {
        for(int j=0;j<m;++j) {
            cin>>arr[i][j];
        }
    }

    queue<A> q;
    q.push({0,0,k,0});
    while(q.size()) {
        auto cur = q.front(); q.pop();
        int y = cur.y;
        int x = cur.x;
        int cnt=cur.cnt;
        int dist = cur.dist;
        
        if(y<0 || x<0 || y>=n || x>=m) continue;
        if(arr[y][x]==1) continue;
        if(vis[y][x][cnt]) continue;

        // cout<<y<<" "<<x<<" "<<dist<<"\n";

        if(y==n-1 && x==m-1) {
            ret=dist;
            break;
        }
        
        vis[y][x][cnt]=1;
        for(int i=0;i<4;++i) {
            int ny=y+dy[i];
            int nx=x+dx[i];
            q.push({ny,nx,cnt,dist+1});
        }
        if(cnt) {
            for(int i=0;i<8;++i) {
                int ny=y+dy2[i];
                int nx=x+dx2[i];
                q.push({ny,nx,cnt-1,dist+1});
            }
        }
    }

    cout<<ret;
   
    return 0;
}