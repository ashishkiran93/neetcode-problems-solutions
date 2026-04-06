class Solution {
    public void setZeroes(int[][] matrix) {
        boolean leftCol = false;
        boolean topRow = false;

        //Detecting if there is any 0 in Left Column
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                leftCol=true;
                break;
            }
        }
        
        //Detecting if there is any 0 in topRow
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                topRow=true;
                break;
            }
        }
        
        //Traversing through rest of matrix from index-1
        // if there is any 0 then mark topRow ( matrix[0][j]=0) and leftCol (matrix[i][0]=0)
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        //If there is any 0 in topRow the mark entire col = 0
        for(int j=1;j<matrix[0].length;j++){
            if(matrix[0][j]==0){
                for(int i=0;i<matrix.length;i++){
                    matrix[i][j]=0;
                }
            }
        }

        //If there is any 0 in leftCol then mark entire row =0
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                for(int j=0;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }       
        }

        //if leftCol is true then mark entire leftCol=0
        if(leftCol == true){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }

        //if topRow is true then mar entire topRow =0
        if(topRow == true){
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i]=0;
            }
        }
    }
}
