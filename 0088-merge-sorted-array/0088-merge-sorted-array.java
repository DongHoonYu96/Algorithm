class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ret = new int[nums1.length];
        ArrayList<Integer> v= new ArrayList<>();

        int i=0, j=0;
        while(i<m && j<nums2.length){
            if(nums1[i]<nums2[j]){
                v.add(nums1[i++]);
                // if(v.get(v.size()-1)==0) v.remove(v.get(v.size()-1));
            }
            else{
                v.add(nums2[j++]);
            }
        }

        while(i<m){
            v.add(nums1[i++]);
            // if(v.get(v.size()-1)==0) v.remove(v.get(v.size()-1));
        }

        while(j<nums2.length){
            v.add(nums2[j++]);
        }
        
        System.out.println(v);
        // nums1 = new int[m+n];
        for(int k=0;k<v.size();++k){
            nums1[k]=v.get(k);
        }
    }
}