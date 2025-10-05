class Solution {
    public boolean containsDuplicate(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int a = 0; a < nums.length; a++) {
                do {
                    if(nums[i] == nums[a]){
                    count++;
                    }
                } while (count);
                
            }            
        }
    }
}