class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> sol = new ArrayList<>();
        char[][] matrix = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(matrix[i],'.');
        }

        solve(matrix,0,sol);
        
        return sol;
    }

    void solve(char[][] matrix,int col, List<List<String>> sol){
        if(col==matrix.length){
            List<String> currMat = new ArrayList<>();
            for(int i=0;i<matrix.length;i++){
               //String s=  Stream.of(matrix[i]).map(ch->String.valueOf(ch)).collect(Collectors.joining());
               currMat.add(new String(matrix[i]));
            }
            sol.add(currMat);
            return;
        }

        for(int row =0;row<matrix.length;row++){
            if(isValid(matrix,row,col)){
                matrix[row][col]='Q';
                solve(matrix,col+1,sol);
                matrix[row][col]='.';
            }
        }
    }

    boolean isValid(char[][] matrix,int row,int col){
        for(int i=0;i<col;i++){
            if(matrix[row][i]=='Q')return false;
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
             if(matrix[i][j]=='Q')return false;
        }
        for(int i=row,j=col;i<matrix.length && j>=0;i++,j--){
            if(matrix[i][j]=='Q') return false;
        }
        return true;
    }
}
