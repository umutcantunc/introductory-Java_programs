/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package palindrome;

/**
 *
 * @author UMUTCAN TUNÇ
 */

import java.util.Scanner;

public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        System.out.print("Enter your number:");
        int number = scan.nextInt();
        int temp_number = number;
        
        if (number == 0) {
            System.out.println(number+" is palindrome");
            return;
        }
        if (number < 0) {
            System.out.println("Negative numbers is ERROR!");
            return;
        }
        int number_digit = (int)Math.log10(number)+1;
        
        int[]figures = new int[number_digit];
        
        for (int i=number_digit-1;i>=0;i--) { //last number to first number
        
            figures[i] = temp_number % 10; //get last number
            temp_number = temp_number / 10; // delete last, we gotta new
        }
        
        boolean isPalindrome = true;
        
        for (int i = 0;i<number_digit/2;i++) {
            
            if (figures[i] != figures[number_digit - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }
        
        if (isPalindrome) {
            System.out.println(number+" is palindrome");
        }
        
        else {
            System.out.println(number+" is NOT palindrome");
        }
        
    }
    
}
