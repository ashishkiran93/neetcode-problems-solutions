class Solution {
    public int reverseBits(int n) {
        int sol =0;
        for(int i=0;i<32;i++){
            int bit = ( n >> i ) & 1;
            sol = sol | bit << (31-i);
        }
        return sol;
    }
}
