class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea =0;
        st.push(0);
        for(int i=1;i<heights.length;i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                int nse =i;
                int eleInd = st.peek();
                st.pop();
                int pse = !st.isEmpty()?st.peek():-1;
                maxArea = Math.max(maxArea,heights[eleInd] * (nse-pse-1));
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int nse = heights.length;
            int eleInd = st.peek();
            st.pop();
            int pse = !st.isEmpty()?st.peek():-1;
            maxArea = Math.max(maxArea,heights[eleInd] * (nse-pse-1));
        }
        return maxArea;
    }
}
