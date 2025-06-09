class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==1) return 0;

        int ret=0;
        int a=prices[0];//현재까지 본값중 가장싼값
        for(int i=1;i<prices.length;++i){
            if(a<prices[i]){ //팔면이득
                ret+=Math.abs(a-prices[i]);
                a=prices[i]; //바로 구매
                continue;
            }

            a=Math.min(a,prices[i]);

        }


        return Math.max(ret,0);
    }
}