class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> sol = new ArrayList<>();
        int U = 0;
        int D = matrix.length-1;
        int L = 0;
        int R = matrix[0].length-1;

        while( U<=D && L<=R){
            for(int i=L;i<=R;i++){
               sol.add(matrix[U][i]);
            }
            U++;
            for(int i=U;i<=D;i++){
                sol.add(matrix[i][R]);
            }
            R--;
            if(U<=D){
                for(int i=R;i>=L;i--){
                    sol.add(matrix[D][i]);
                }
                D--;
            }

            if(L<=R){
                for(int i = D;i>=U;i--){
                    sol.add(matrix[i][L]);
                }
                L++;
            }
        }

        return sol;
    }
}
