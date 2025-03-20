#include <bits/stdc++.h>
using namespace std;

int n;
int dp[1000000+4]; // dp[cur][st] 형태로 변경
vector<int> money;

int dfs(int cur, int st) {
    
    if (cur == n-1 && st == 0) return 0; // 첫 집 선택 시 마지막 집 불가
    if (cur >= n) return 0;
    if (dp[cur] != -1) return dp[cur];

    int& ret = dp[cur];
    ret=-1;
    ret = max(ret, dfs(cur + 2, st) + money[cur]); //현재 집선택
    ret = max(ret, dfs(cur + 1, st)); // 현재 집 안선택
    
    return ret;
}

// int dfs2(int idx, int m){
//     if(idx==n){
//         return 0;
//     }
//     dfs(idx+1,m+money[idx]);
    
// }

int solution(vector<int> _money) {
    money = _money;
    n = money.size();
    // if (n == 1) return money[0];
    
    // Case 1: 첫 번째 집 선택 (마지막 집 불가)
    memset(dp, -1, sizeof(dp));
    int case1 = dfs(0, 0);
    
    // Case 2: 첫 번째 집 미선택 (마지막 집 가능)
    memset(dp, -1, sizeof(dp));
    int case2 = dfs(1, 1);
    
    return max(case1, case2);
}