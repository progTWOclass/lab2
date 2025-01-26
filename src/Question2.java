public class Question2 {

    //method for adding the number in an array diagonally
    public static int sumDiagonal(int[][] num){

        //initialize the sum of the diagonal numbers
        int sumDiagonal1 = 0;
        int sumDiagonal2 = 0;
        for(int i = 0; i < num.length; i++){
            //we want the element at i, ex: num[0][0] = 1, num[1][1] = 7, num[2][2] = 13, etc
            sumDiagonal1 += num[i][i];
            //we want the element starting from the end of row 0
            //num[0][5-0-1] = 5, num[1][5-1-1] = 9, num[2][5-2-1] = 13, num[3][5-3-1] = 17, etc
            sumDiagonal2 += num[i][num.length - i -1];
        }

        //check if length is odd, if it is odd then the middle element will come up twice
        if(num.length % 2 == 1){
            int middleElement = num.length/2;//find the element in the middle
            sumDiagonal2 -= num[middleElement][middleElement];//subtract the element from sumDiagonal1 or sumDiagonal2
        }
        return sumDiagonal1 + sumDiagonal2;
    }

    public static void main(String[] args) {
        int[][] num = new int[5][5];
        int number = 1;
        for(int i = 0; i < num.length; i++){
            for(int j = 0; j < num[i].length; j++){
                num[i][j] = number++;
                if(num[i][j] < 10){
                    System.out.print("0");
                }
                System.out.print(num[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The sum of the diagonals are " + sumDiagonal(num));
    }
}
