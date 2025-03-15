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
                //start at 0,2 of the new array because we are rotating 90 degrees clockwise
                //and add 0,0 of the original array
                newArray[j][row-1-i] = matrix[i][j];        //1 2 3       1 -->      4 1  --> 6 4 1
                                                            //4 5         2 -->      5 2  -->   5 2
                                                            //6           3 -->        3  -->     3
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
        int [][]ragged2 = {
                {1,2,3},
                {4,5},
                {6},
        };
        System.out.println("original ragged array");
        printMatrix(ragged2);

        System.out.println("rotated array");
        int [][]rotatedArray = rotate90Clockwise(ragged);
        printMatrix(rotatedArray);

    }
}
