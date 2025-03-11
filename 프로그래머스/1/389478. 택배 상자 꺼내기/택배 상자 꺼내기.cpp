#include <bits/stdc++.h>

using namespace std;

int a[104][104];
int dy[] = {0,0}; //우, 좌
int dx[] = {1,-1};
int ret,n,w,num;

void dfs(int y, int x, int cnt){
    
    if( y < 0 || a[y][x]==0 ){
        ret = cnt;
        return;
    }
    // cout<<1;
    // cout<<y<<" "<<x<<"\n";
    dfs(y-1,x,cnt+1);
}

void go(){
    //find 좌표
    int y,x;
    for(int i=0;i<104;++i){
        for(int j=0;j<11;++j){
            if(a[i][j]==num){
                y=i;
                x=j;
                break;
            }
        }
    }
    dfs(y,x,0);
}

int solution(int _n, int _w, int _num) {
    n=_n; w=_w; num=_num;
    
    int y=100; int x=0;
    int dir=0;
    for(int i=1;i<=n;++i){
        
        a[y][x]=i;
        if(i%w==0){
            y--;
            dir^=1;
            continue;
        }
        // y=y+dy[dir];
        x=x+dx[dir];
    }
    // for(int i=0;i<101;++i){
    //     for(int j=0;j<11;++j){
    //         cout<<a[i][j]<<" ";
    //     }cout<<"\n";
    // }
    
    go();
    return ret;
}