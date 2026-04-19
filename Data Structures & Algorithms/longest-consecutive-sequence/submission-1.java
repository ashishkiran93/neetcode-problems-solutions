class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        int longest =1;
        Set<Integer> set = new HashSet<>();
        for(int num :nums){
            set.add(num);
        }

        for(int num:set){
            if(!set.contains(num-1)){
                int count =1;
                while(set.contains(num+1)){
                 count++;
                 num=num+1;
                }
                longest = Math.max(longest,count);
            }
        }

        return longest;
    }
}
