class Solution {
    public String pushDominoes(String dominoes) {
      
        // ex: .L.R...LR..L..
        // create two arrays: one corresponding to left to right momentum and one for right to left momentum
        // left to right: if we are on a '.' and we see a 'R' to the left of us, we need to add 1 to our current momentum
        // right to left: if we are on a '.' and we see a 'L' to the right of us, we need to add 1 to our current momentum
		// note:  array values are initially 0 at each index and the current momentum can be found by looking at the previous index
        // 0, 0, 0, 0, 1, 2, 3, 0, 0, 1, 2, 0, 0, 0 -> left to right (loop the dominoes string from left to right)
        // 1, 0, 0, 0, 3, 2, 1, 0, 0, 2, 1, 0, 0, 0 -> right to left (loop the dominoes string from right to left)
        
        // finally loop over the length of the arrays: 
		// if both arrays contain the same momentum value, keep the original character found in dominoes string
        // if one of the arrays contains a momentum of 0, choose the letter corresponding to the other array
        // both momentums are non zero values, choose the letter corresponding to the array of the smallest value
		// note:  left to right array corresponds to setting the 'R' character, the opposite is true for the right to left array
        
        StringBuilder result = new StringBuilder();
        int[] ltr = new int[dominoes.length()]; // momentum going from left to right
        int[] rtl = new int[dominoes.length()]; // momentum going from right to left
        
        // left to right momentum 
        for (int i = 1; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == '.' 
                && (dominoes.charAt(i - 1) == 'R' || ltr[i - 1] > 0)) {
                
                ltr[i] = ltr[i - 1] + 1;
            }
            
        }
        
        // right to left momentum
        for (int i = dominoes.length() - 2; i >= 0; i--) {
            if (dominoes.charAt(i) == '.' 
                && (dominoes.charAt(i + 1) == 'L' || rtl[i + 1] > 0)) {
                
                rtl[i] = rtl[i + 1] + 1;
            }
        }
        
        
        // compute the result by looking at both arrays and taking the smallest momentum value that is non zero
        // note:  original value from dominoes will remain for equal momentums
        for(int i = 0; i < dominoes.length(); i++) {
            if (ltr[i] == rtl[i]) {
                result.append(dominoes.charAt(i));
            } else if (ltr[i] == 0 || rtl[i] == 0) {
                // take the non zero
                if (ltr[i] == 0) {
                    result.append("L");
                } else {
                    result.append("R");
                }
            } else {
                // take the smallest value
                if (ltr[i] < rtl[i]) {
                    result.append("R");
                } else {
                    result.append("L");
                }
            }
        }
        return result.toString();
    }
}