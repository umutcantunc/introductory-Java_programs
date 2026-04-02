/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package faktorialwithrecursively;

/**
 *
 * @author UMUTCAN TUNÇ
 */
import java.util.Scanner;

public class FaktorialWithRecursively {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner tarayici = new Scanner(System.in);
        System.out.print("Enter the number:");
        int n = tarayici.nextInt();
        if (n<0) {
            System.out.println("WRONG NUMBER. NUMBER CANT BE NEGATIVE!");
        }
        else {
            System.out.printf("%d! = %d\n",n,factorial(n));
        }
        
    }
    
    public static int factorial(int sum) {
        
        if (sum==1 || sum==0) {
            return 1;
        }
        
        return factorial(sum-1) * sum;
        
    }
    
    
    
}
