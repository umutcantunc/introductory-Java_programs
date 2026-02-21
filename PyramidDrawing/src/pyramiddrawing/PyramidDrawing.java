/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pyramiddrawing;

/**
 *
 * @author UMUTCAN TUNÇ
 */
import java.util.Scanner;

public class PyramidDrawing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        while (true) {
            System.out.print("""
                             (Enter 0 to exit)
                             Enter the pyramid height: """);
            int height = scan.nextInt();
            if (height==0) {
                System.out.println("Exiting...");
                break;
            }
            
            System.out.print("Enter the pyramid type(just 1,2,3,4):");
            int type = scan.nextInt();
            
            switch (type) {
                case 1 -> drawPyramid1(height);
                case 2 -> drawPyramid2(height);
                case 3 -> drawPyramid3(height);
                case 4 -> drawPyramid4(height);
                default -> System.out.println("YOU ENTERED THE WRONG TYPE!");
            }
        }
    }
    
    public static void drawPyramid1(int height) {
        for (int i=1;i<=height;i++) {
            for (int j=1;j<=i;j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
    
    public static void drawPyramid2(int height) {
        for (int i=height;i>=1;i--) { 
            for (int j=1;j<=i;j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
    
    public static void drawPyramid3(int height) {
        for (int i=height;i>=1;i--) { 
            for (int k=height;k>i;k--) {
                System.out.print(" ");
            }
            for (int j=1;j<=i;j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
    
    public static void drawPyramid4(int height) {
        for (int i=1;i<=height;i++) { 
            for (int k=i;k<height;k++) {
                System.out.print(" ");
            }
            for (int j=1;j<=i;j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
    
}
