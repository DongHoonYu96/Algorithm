#include<bits/stdc++.h>
using namespace std;
typedef long long int ll;
int n, m,t1,t2,ret,  a[1004][1004], v[1004];
int dx[] = {0,1,-1,0};
int dy[] = {1,0,0,-1};

void dfs(int here)
{
    v[here] = 1;
    //cout << here << " ";

    for (int there = 0; there < 1004; ++there)
    {
        if (a[here][there] == 1 && v[there] == 0)
            dfs(there);
    }
    return;

}

void bfs(int start)
{
    queue<int> q;
    q.push(start);

    int here;

    while (q.size())
    {
        here = q.front(); q.pop();
        v[here] = 1;
        //cout << here << " ";
        for (int there = 0; there < 1004; ++there)
        {
            if (a[here][there] == 1 && v[there] == 0)
            {
                q.push(there);
                v[there] = 1;
                ret++;
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0); cin.tie(NULL);
    cin >> n>>m;
    
    for (int i = 0; i < m; ++i)
    {
        cin >> t1 >> t2;
        a[t1][t2] = 1;
        a[t2][t1] = 1;
    }

    //dfs(v);
    //for (int i = 0; i < 1004; ++i) visited[i] = 0;
    //cout << "\n";
    for (int i = 1; i <= n; ++i)
    {
        if (v[i] == 0)
        {
            dfs(i);
            ret++;
        }
    }
    cout << ret;

    return 0;
}