class Solution {
    public String reverseWords(String words) {
        int len = words.length(), s = -1, e = -1;
        char[] chArr = words.toCharArray();
        
        for(int i = 0, j = 0; i <= len; i++) {
            if(i == len || chArr[i] == ' ') {
                s = j;
                e = i-1;
                
                while(s < e) {
                    swap(chArr, s++, e--);
                }
                
                j = i+1;
            }
        }
        
        return String.valueOf(chArr);
    }
    
    public void swap(char[] ch, int i, int j) {
        char tchar = ch[i];
        ch[i] = ch[j];
        ch[j] = tchar;
    }
}