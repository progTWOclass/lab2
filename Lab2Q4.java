/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author niloufas
 */
public class Lab2Q4 {
    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        
        System.out.println("Enter an odd integer:");
        int n=kb.nextInt();
        
        if(n%2== 0) //even integer
        {
            System.out.println("Size should be odd.");
            System.exit(0);
        }
        
        int[][] magic=new int[n][n];
        
        //add the first integer at the bottom middle cell
        int row=n-1;
        int col=n/2;
        magic[row][col]=1;
                
        //add all integers from 2 to n*n
        for(int i=2; i<=n*n; i++)
        {
            //if cell has not been assigned yet:
            //go down one row(wrap around if needed)
            //go right one column(wrap around if needed)
            if(magic[(row+1)%n][(col+1)%n]==0 )
            { 
                row=(row+1)%n;//go down one row(wrap around if needed)
                col=(col+1)%n;//go right one column(wrap around if needed)
            } 
            else
            //if cell has already been assigned,go up 1 row
            //do not change the col
                row=row-1;
            
            magic[row][col]=i; 
        }
        
        //print magic square
         for(int i=0; i<n; i++)   
         {
              for(int j=0; j<n; j++)
              {
                  if(magic[i][j]<10) //for alignment
                      System.out.print(" ");
                  System.out.print(magic[i][j]+" ");
              }
              System.out.println();
         }
        
    }
       
}
