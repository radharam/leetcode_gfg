class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        
        if(s == null || len == 0 || s.charAt(0) == '0') return 0;
        int one = s.charAt(len - 1) != '0' ? 1 : 0;
        int two = -1;
        
        for(int i = len - 2; i >= 0; i--){
            int curr = 0;
            if(s.charAt(i) == '0') curr = 0;
            else{
                curr = one;
                if(Character.getNumericValue(s.charAt(i))*10 + Character.getNumericValue(s.charAt(i + 1)) <= 26){
                    if(i != len - 2) curr += two;
                    else curr += 1;      
                }
            }
            two = one;
            one = curr;
        }
        
        return one;
    }
}