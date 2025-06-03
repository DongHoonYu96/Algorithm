class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length==1) return nums[0];

        Arrays.sort(nums);
        int cnt=1;
        int prev=nums[0];
        for(int i=1;i<nums.length;++i){
            int cur = nums[i];
            System.out.println(cnt);
            if(prev!=cur){
                if(cnt==2){
                    //새로시작
                    cnt=1;
                    prev=cur;
                }
                else{
                    return prev; 
                }
            }
            else{
                prev=cur;
                cnt++;
            }

        }
        
        return nums[nums.length-1]; //마지막에 정답이잇는경우
    }
}