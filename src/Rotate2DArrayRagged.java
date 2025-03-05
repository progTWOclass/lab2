public class Rotate2DArrayRagged {

    public static int [][] rotate90Clockwise(int[][]matrix){

        int row = matrix.length;

        // Find the widest row. that row will become our column
        int widestRow = 0;
        for (int[] rows : matrix) {
            //compare 2 number and takes the biggest
            widestRow = Math.max(widestRow, rows.length);
        }

        //create a new array to store value of the new array
        int [][] newArray = new int[widestRow][row];

        for(int i=0; i<row; i++){
            for(int j = 0; j<matrix[i].length; j++){
                newArray[j][row-1-i] = matrix[i][j];
            }
        }
        return newArray;
    }

    public static void printMatrix(int[][]matrix){
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int [][]ragged = {
                {1,2,3},
                {4,5},
                {6},
        };
        int [][]rotatedArray = rotate90Clockwise(ragged);
        printMatrix(rotatedArray);


//        System.out.println(ragged[0].length);//at row 0, how many columns are there --> 1
//        System.out.println(ragged[1].length);
//        System.out.println(ragged[3].length);//at row 3, column = 5
    }
}
