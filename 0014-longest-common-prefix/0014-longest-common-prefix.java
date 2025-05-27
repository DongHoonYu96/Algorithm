class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 길이순정렬
        Arrays.sort(strs, (a,b)->a.length()-b.length());
        // for(String str : strs){
        //     System.out.println(str);
        // }

        StringBuilder sb = new StringBuilder();

        String first = strs[0];
        for(int i=0;i<first.length();++i){
            char c = first.charAt(i);
            for(String str:strs){
                if(c!= str.charAt(i)){
                    return sb.toString();
                }

            }
            sb.append(c);
        }

        return sb.toString();
    }
}