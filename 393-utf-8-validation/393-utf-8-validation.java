class Solution {
    
    public boolean validUtf8(int[] data) {
        int count = 0;
        for(int i = 0; i <data.length; i++){
            
            int x = data[i];
            
            if(count == 0){
                if((x >> 5) == 0b110) count = 1;
                
                else if((x >> 4) == 0b1110) count = 2;
                
                else if((x >> 3) == 0b11110) count = 3;
                
                else if((x >> 7) != 0) return false;
            } 
            else {
                if((x >> 6) != 0b10) return false;
                count--;
            }
        }
        return (count == 0);
    }
    
    
    // Bit Manipulation
    public boolean validUtf82(int[] data) {
        int rbytes = 0;
        for(int i: data) {
            if(rbytes == 0) {
                if((i >> 7) == 0b0) {
                    continue;
                } else if((i >> 5) == 0b110) {
                    rbytes = 1;
                } else if((i >> 4) == 0b1110) {
                    rbytes = 2;
                } else if((i >> 3) == 0b11110) {
                    rbytes = 3;
                } else return false;
            }
            else {
                if((i >> 6) == 0b10) {
                    rbytes--;
                } else {
                    return false;
                }
            }
        }
        return rbytes == 0;
    }
}


/*
    Complexity: 
    * TC: O(N)
    * SC: O(1)
*/