class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer,Integer> m = new HashMap<>(); //<숫자, 등장횟수>
        for(int num : nums){
            if(m.containsKey(num)){
                m.put(num,2);
            }
            else{
                m.put(num,1);
            }
        }
        int idx=0;
        for(int key : m.keySet()){
            int a = m.get(key);
            for(int i=0;i<a;++i){
                nums[idx++]=key;
            }
        }
        return idx;

    }
}