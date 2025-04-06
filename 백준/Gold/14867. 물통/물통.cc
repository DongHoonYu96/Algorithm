#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

int a,b,c,d,ret=-1;
map<pair<int,int>,int> vis;

struct A {
    int q,w,cnt;
};

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin>>a>>b>>c>>d;

    // dfs(0,0,0);
    queue<A> qe;
    qe.push({0,0,0});

    while(qe.size()) {
        auto cur = qe.front(); qe.pop();
        int q = cur.q;
        int w = cur.w;
        int cnt = cur.cnt;

        if(vis[{q,w}]) continue;
        
        if(q==c && w==d) {
            ret=cnt;
            break;
        }
        
        vis[{q,w}]=1;
        qe.push({a,w,cnt+1});
        qe.push({q,b,cnt+1});
        qe.push({0,w,cnt+1});
        qe.push({q,0,cnt+1});
        int _q=q; //원본
        int _w=w; 
        // q->w
        int gab = b-w;
        //w에 빈공간이있으면
        if(gab) {
            if(q >= gab) {
                w=b;
                q -=gab;
            }
            else {
                w+=q;
                q=0;
            }
        }
        qe.push({q,w,cnt+1});

        //원복
        q=_q;
        w=_w;
        // w->q
        int gab2 = a-q;
        //w에 빈공간이있으면
        if(gab2) {
            if(w >= gab2) {
                q=a;
                w -=gab2;
            }
            else {
                q+=w;
                w=0;
            }
        }
        qe.push({q,w,cnt+1});
    }
    
    
    cout<<ret;
   
    return 0;
}