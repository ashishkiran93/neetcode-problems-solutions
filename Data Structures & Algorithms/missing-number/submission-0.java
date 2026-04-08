class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int counter=0;

        for(int i=0;i<nums.length;i++){
            if(counter == nums[i]){
                counter++;
            }
            else return counter;
        }

        return nums.length;
        
    }
}
