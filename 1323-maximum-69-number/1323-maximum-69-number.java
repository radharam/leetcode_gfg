class Solution {
    public int maximum69NumberStringApproach (int num) {
        return Integer.parseInt(("" + num).replaceFirst("6", "9"));
    }
    
    public int maximum69Number (int num) {
       int temp = num;
        
        for(int i = 1000; i > 0; i /= 10){            
            if(temp / i == 6) return num + (3 * i);
            
            if(temp > i) temp -= (9 * i);
        }
        
        return num;
    }
    
}