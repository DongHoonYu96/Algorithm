class Solution {
    public int removeElement(int[] nums, int val) {
        int cnt=0;
        for(int i=0;i<nums.length;++i){
            if(nums[i]==val){
                cnt++;
                nums[i]=Integer.MAX_VALUE;
            }
        }
        Arrays.sort(nums);
        return nums.length-cnt;
    }
}