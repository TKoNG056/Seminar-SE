public class matrixOparater {
    
    
    
    public static int[][] transpose (int [][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] n = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; col < 3; j++) {
                n[j][i] = matrix[i][j];
            }
        }

        return n;
    }

    public static  int[][] multiply (int [][] matrix1,int [][] matrix2){
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2.length;
        if (col1 != row2) {
            throw new IllegalArgumentException("Matrices cannot be multiplied due to incompatible dimensions.");
        }
        int [][] n = new int [row2][col1];

        for(int i=0;i<row1;i++){    
            for(int j=0;j<col2;j++){          
                for(int k=0;k<row2;k++)      {      
                n[i][j]+=matrix1[i][k]*matrix2[k][j];      
                }//end of k loop  
            }//end of j loop  
        }  
        return n;
    }

}

