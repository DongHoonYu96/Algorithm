#include <bits/stdc++.h> 
using namespace std;

const int MAXN = 100004;

int n, m1, m2, c;
int items[MAXN], prices[MAXN];
int memo[MAXN];

int dp(int budget) {
    if (budget < 0) return INT_MIN; 
    if (budget == 0) return 0; 
    if (memo[budget] != -1) return memo[budget];  

    int best = 0;
    for (int i = 0; i < n; i++) {
        if (budget - prices[i] >= 0) {
            best = max(best, items[i] + dp(budget - prices[i]));
        }
    }

    memo[budget] = best;
    return best;
}

int main() {
    while (1) { 
        scanf("%d %d.%d", &n, &m1, &m2);
        if (n == 0) break;
        int cost = m1 * 100 + m2; 

        for (int i = 0; i < n; i++) { 
            scanf("%d %d.%d", &c, &m1, &m2);
            items[i] = c;
            prices[i] = m1 * 100 + m2;
        }

        memset(memo, -1, sizeof(memo));
        printf("%d\n", dp(cost));
    }
    return 0;
}