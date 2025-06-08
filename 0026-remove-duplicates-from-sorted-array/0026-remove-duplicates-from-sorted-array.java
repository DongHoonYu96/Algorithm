class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> s = new LinkedHashSet<>();
        for(int num : nums){
            s.add(num);
        }
        int idx=0;
        for(int num : s){
            nums[idx]=num;
            idx++;
        }
        return s.size();
    }
}