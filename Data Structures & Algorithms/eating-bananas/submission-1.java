class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxBananaPile = 0;
        for(int i=0;i<piles.length;i++){
            maxBananaPile = Math.max(maxBananaPile,piles[i]);
        }

        int left =1;
        int right = maxBananaPile;
        int minK = maxBananaPile;
        while(left<=right){
            int mid = (left+right)/2;
            int hoursCalculated = getTimeToFinish(piles,mid);
            if(hoursCalculated>h){
                left = mid+1;
            }
            else {
                right = mid -1;
                minK = mid;
            }
        }

        return minK;

    }

    int getTimeToFinish(int[] piles, int k){
        int totalHour = 0;
        for(int i=0;i<piles.length;i++){            
         totalHour =totalHour + (int)Math.ceil((double)piles[i]/k);            
        }
        return totalHour;
    }
}
