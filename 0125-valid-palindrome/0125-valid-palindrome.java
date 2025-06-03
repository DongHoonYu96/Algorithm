class Solution {
    public static String removeNonAlphabets(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public boolean isPalindrome(String s) {
        s=s.replaceAll(" ","");
        s=s.toLowerCase();
        s=removeNonAlphabets(s);
        System.out.println(s);
        int st=0;
        int en=s.length()-1;
        while(st<=en){
            if(s.charAt(st)!=s.charAt(en)){
                return false;
            }
            st++;
            en--;
        }
        return true;
    }
}