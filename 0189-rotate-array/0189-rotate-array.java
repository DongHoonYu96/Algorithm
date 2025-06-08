class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] rotated = new int[n];
        
        // 0 1 2 3 4 5 6 (i)
        // 1 2 3 4 5 6 7 (arr)
        // 6 7 1 2 3 4 5 (k=2, rotated)
        // 

        for(int i=0;i<n;++i){
            rotated[(i+k)%n] = nums[i];
        }

        for(int i=0;i<n;++i){
            nums[i]=rotated[i];
        }
    }
}