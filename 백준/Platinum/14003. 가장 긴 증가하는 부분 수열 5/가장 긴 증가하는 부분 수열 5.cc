#include <bits/stdc++.h>
#define endl "\n";

using namespace std;
typedef long long ll;


ll n, lis[1000000 + 4], len, num;
ll Index_Arr[1000000 + 4]; //index[3]=1 : 원본3번, lis 1번
ll a[1000000 + 4]; //원본배열

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    //memset(Index_Arr, -1, sizeof(Index_Arr));

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> num;
        a[i] = num;

        int idx = lower_bound(lis, lis + len, num) - lis;
  
        if (idx == len) len++; 
        lis[idx] = num;

        //lis 배열 찾기위한 로직 추가
        Index_Arr[i] = idx;
        
    }
    cout << len<<"\n";

    /*for (int i = 0; i < n; ++i) {
        cout << Index_Arr[i] << " ";
    }cout << endl;*/

    vector<ll> v;
    int find_idx = len - 1;
    for (int i = n-1 ; i >= 0; --i) { //--i 역순탐색 => 3 2 4 에서 2가 자동 pass됨!
        if (Index_Arr[i] == find_idx) {
            find_idx--;
            v.push_back(a[i]);
        }
    }
    reverse(v.begin(), v.end());
    for (auto i : v) {
        cout << i << " ";
    }   
    return 0;
}

