public class RotateMatrix {

    //using another method instead of transpose
//    public static void rotate90(int[][]array){
//
//        int n = array.length;
//
//        //takes care of the outer layer of the matrix
//        for(int i=0; i<(n+1)/2; i++){
//            //keep track of the elements in the current layer of the matrix
//            for(int j=0; j<n/2; j++){
//
//                //temporary space to hold one value of the array
//                int temp = array[i][j];
//
//                //start with the top left. gets the value from the bottom left
//                array[i][j] = array[n-1-j][i];
//
//                //bottom left gets the value from the bottom right
//                array[n-1-j][i] = array[n-1-i][n-1-j];
//
//                //top right gets the value from the top left
//                array[n-1-i][n-1-j] = array[j][n-1-i];
//
//                //top left gets the value from the temp
//                array[j][n-1-i] = temp;
//            }
//        }
//    }
//
//    public static void rotate90CounterClockwise(int[][] array) {
//        int n = array.length;
//
//        for (int i = 0; i < (n + 1) / 2; i++) {
//            for (int j = 0; j < n / 2; j++) {
//                // Step 1: Save top-left
//                int temp = array[i][j];
//
//                // Step 2: Move top-right to top-left
//                array[i][j] = array[j][n-1-i];
//
//                // Step 3: Move bottom-right to top-right
//                array[j][n-1-i] = array[n-1-i][n-1-j];
//
//                // Step 4: Move top-right to bottom-right
//                array[n-1-i][n-1-j] = array[n-1-j][i];
//
//                // Step 5: Move temp (original top-left) to top-right
//                array[n-1-j][i] = temp;
//            }
//        }
//    }

    //using transpose
    public static void rotate90(int[][]array){

        int n = array.length;

        //first for loop for transposing the array, swapping the element diagonally
        //row becomes column
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                //transpose the 2d array, at 0,0 nothing happens
                //example        0,1 = (2)
                int temp = array[i][j];
                //    0,1 = (2)      1,0 = (4)
                array[i][j] = array[j][i];
                //    1,0 = (4)    0,1 = (2)
                array[j][i] = temp; //therefore row 1 = 1,4,7
            }
        }

        //second loop for swapping the left and right element
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n/2; j++){
                //                0,0 = (1)
                int temp =  array[i][j];
                //   0,0 = (1)     0,2 = (7)
                array[i][j] = array[i][n-1-j];
                //0,2 = (7)       0,0 = (1)
                array[i][n-1-j] = temp; //therefore, row 1 = 7,4,1
            }
        }
    }

    public static void rotate90CounterClockwise(int[][] array) {
        int n = array.length;

        //transpose the 2d array same as the method for 90 degree above
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = array[i][j];

                array[i][j] = array[j][i];

                array[j][i] = temp;
            }
        }
        //swap the top and bottom
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                //               0,0 = (1)
                int temp = array[j][i];
                // 0,0 = (1)      2,0 = (3)
                array[j][i] = array[n-1-j][i];
                //2,0 = (3)        0,0 = (1)
                array[n-1-j][i] = temp;
                //therefore column 1 =
                //3
                //2
                //1
            }
        }
    }

    public static void main(String[] args) {
        int [][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int [][] matrix2 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        System.out.println("original matrix ");
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        rotate90(matrix);
        System.out.println("rotated matrix ");
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        rotate90CounterClockwise(matrix2);
        System.out.println("rotate matrix counterclockwise");
        for(int i = 0; i < matrix2.length; i++){
            for(int j = 0; j < matrix2.length; j++){
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
