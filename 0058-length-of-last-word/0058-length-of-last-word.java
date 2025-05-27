class Solution {
    public int lengthOfLastWord(String s) {
        String[] args=s.split(" ");
        for(String arg : args){
            System.out.println(arg);
        }
        
        return args[args.length-1].length();
    }
}