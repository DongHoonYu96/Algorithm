#include<bits/stdc++.h>
using namespace std;   
void fastIO(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
}    
int n;    // 웅덩이의 개수
int m;    // 널빤지의 길이
int idx;  // 현재까지 덮은 위치
int ret;  // 필요한 널빤지의 총 개수
int b;    // 현재 웅덩이를 덮는데 필요한 널빤지 개수
int main(){
    fastIO(); 
    cin >> n >> m; 
    vector<pair<int,int>> a(n);
    for(int i = 0; i < n; i++) cin >> a[i].first >> a[i].second;
    sort(a.begin(), a.end());
    for(int i = 0; i < n; i++){
        if(idx >= a[i].second) continue;
        if(idx < a[i].first) {
            b = (a[i].second - a[i].first)/m + ((a[i].second - a[i].first)%m ? 1 : 0);
            idx = a[i].first + m*b;
        }
        else {
            b = (a[i].second - idx)/m + ((a[i].second - idx)%m ? 1 : 0);
            idx = idx + m*b;
        }
        ret+=b;
    }
    // cout<<idx<<"\n";
    cout << ret << "\n"; 
    return 0;
} 