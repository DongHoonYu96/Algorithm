class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        int w=0;
        int q=0;
        for(int i=0;i<arr1.length;++i){
            for(int j=0;j<arr2[0].length;++j){
                for(int k=0;k<arr1[0].length;++k){
                    answer[i][j] += arr1[i][k]*arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}