#include <bits/stdc++.h>

using namespace std;

int graph[104][104];
int ret;

int solution(int n, vector<vector<int>> results) {
    for( auto result : results){
        int a= result[0];
        int b= result[1];
        graph[a][b]=1; // a는 b를 이김
        graph[b][a]=-1; //b는 a에게 짐
    }
    
    //플로이드는 케이 아이 제이~
    for(int k=1;k<=n;++k){
        for(int i=1;i<=n;++i){
            for(int j=1;j<=n;++j){
                if(graph[i][k]==1 && graph[k][j]==1){
                    graph[i][j]=1;
                    graph[j][i]=-1;
                }
            }
        }
    }
    
    for(int i=1;i<=n;++i){
        int cnt=0;
        // 가로줄검사 a[i][0] ~ a[i][1] ...
        for(int j=1;j<=n;++j){
            if(graph[i][j]==1 || graph[i][j]==-1){
                cnt++;
            }
        }
        
        // 세로줄검사 a[0][i] ~ a[1][i] ...
        // for(int j=1;j<=n;++j){
        //     if(a[j][i]==1 || a[j][i]==-1){
        //         cnt++;
        //     }
        // }
        
        if(cnt==n-1) ret++;
    }
    
    
    return ret;
}