class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> solList = new ArrayList<>();
        int carry =1;
        for(int i=digits.length-1;i>=0;i--){
            int sum = digits[i] + carry;
            if(sum>9){
                solList.add(sum%2);
                carry=1;
            }
            else{
                solList.add(sum);
                carry =0;
            }
        }

        if(carry!=0){
            solList.add(carry);
        }

        int[] sol = new int[solList.size()];
        int i=solList.size()-1;
        for(int num:solList){
            sol[i--] = num;
        }
        return sol;
    }
}
