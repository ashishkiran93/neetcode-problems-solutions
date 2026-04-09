class Solution {
    public int getSum(int a, int b) {
        // "|" is not the binary addition
        // to solve this question we must perform the binary addition
        // so "|" wont work here
        // Addition rules -> 1 + 1 = 1 0
        // but the "|" operator only gives 1  so we have carry 1 to the next bit which can be 
        // achived through "&" with << 1 and for getting value we must do "^" to get 0 
    
        while(b!=0){
            int carry = ( a & b)<<1;
            a = a ^ b;
            b = carry;
        }

        return a;
    }
}
