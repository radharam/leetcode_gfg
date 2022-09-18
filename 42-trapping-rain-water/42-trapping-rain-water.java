class Solution {
    public int trap(int[] height) {
        int len = height.length, capacity = 0;
        
        int leftMax = height[0], rightMax = height[len-1];
        int l = 1, r = len-2;
        while(l <= r) {
            int minH = Math.min(leftMax, rightMax);
            if(leftMax <= rightMax) {
                if(height[l] < minH) capacity += minH - height[l];
                leftMax = Math.max(leftMax, height[l]);
                l++;
            } else {
                if(height[r] < minH) capacity += minH - height[r];
                rightMax = Math.max(rightMax, height[r]);
                r--;
            } 
        }
        
        return capacity;
    }
}