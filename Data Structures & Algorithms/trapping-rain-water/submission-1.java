class Solution {
    public int trap(int[] height) {
       int l=0,r=height.length-1,lmax=0,rmax=0,count=0;

       while(l<r){
        if(height[l]<=height[r]){
            if(height[l]>lmax){
                lmax=height[l];
            }
            else{
                count = count + lmax - height[l];
            }
            l++;
        }
        else{
            if(height[r]>rmax){
                rmax=height[r];
            }
            else count = count + rmax - height[r];
            r--;
        }
       } 
       return count;
    }
}
