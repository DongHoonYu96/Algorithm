class Solution {
    public int maxProfit(int[] prices) {
        int ret=0;
        int n = prices.length;
        int min = Integer.MAX_VALUE; // 지금까지 본것중 최소값 (가장싸게 사는 가격)

        for(int i=0;i<n;++i){
            min = Math.min(min,prices[i]);
            ret = Math.max(ret,prices[i]-min);
        }
        System.out.println(min);
        return ret;
    }
}