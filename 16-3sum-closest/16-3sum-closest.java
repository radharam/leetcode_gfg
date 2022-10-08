class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);  
        int actual_diff = Integer.MAX_VALUE; // stores actual diff
        int diff = Integer.MAX_VALUE; // stores abs diff
        for(int l = 0;l<nums.length-2;l++){
           int current_target = target-nums[l];
           int m =l+1;
           int r = nums.length-1;
           while(m<r){
               int current_sum = nums[m] + nums[r];
               int current_diff = current_sum-current_target;
               if(current_sum == current_target){
                   return target;
               }
               else if(current_sum<current_target){
                   m++;
               }
               else{
                   r--;
               }
               if(Math.abs(current_diff)<diff){
                   diff = Math.abs(current_diff);
                   actual_diff = current_diff;
               }   
           }

        }
        return target+actual_diff;
    }
}