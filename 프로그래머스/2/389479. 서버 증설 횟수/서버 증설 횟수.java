class Solution {
    
    static int[] need = new int[25];
    static int[] server = new int[25];
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int n = players.length;
        
        for(int i=0;i<players.length;++i){
            need[i] = players[i]/m;
        }
        
        // for(int i=0;i<n;++i){
        //     System.out.print(need[i]+" ");
        // }
        
        for(int i=0;i<n;++i){
            if(need[i]>server[i]){
                int gab = Math.abs(need[i]-server[i]);
                for(int j=0;j<k;++j){
                    if(i+j>=n) break;
                    server[i+j]+=gab;
                }
                answer+=gab;
            }
        }
        
        
        return answer;
    }
}