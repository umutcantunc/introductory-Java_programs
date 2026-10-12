/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package veriyapilariodev1stack;

/**
 *
 * @author UMUTCAN TUNÇ
 */
public class VeriYapilariOdev1Stack {

    public static void main(String[] args) throws Exception {
        Stack s1 = new Stack(4);
        s1.push(2);
        s1.push(9);
        s1.push(8);
        s1.push(3);
        System.out.println("Stack 1: ");
        s1.display();
        Stack s2 = new Stack(3);
        s2.push(-4);
        s2.push(5);
        s2.push(1);
        System.out.println("Stack 2: ");
        s2.display();
        Stack s3 = stackleriSiraliOlarakBirlestir(s1, s2);
        System.out.println("Stack 3: ");
        s3.display();

    }

    public static Stack stackleriSiraliOlarakBirlestir(Stack stack1, Stack stack2) throws Exception { //en üstte en büyük , en altta en kucuk
        Stack siraliStack = new Stack(stack1.count() + stack2.count()); //stacklerin icinde ne kadar sayi varsa o buyuklukte yeni bir stack olustur
        Stack yardimciStack = new Stack(stack1.count() + stack2.count()); // iki stack'i tek bir yardimci stack icine atacagiz(karisik sekilde)

        while (!stack1.isEmpty()) {
            yardimciStack.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            yardimciStack.push(stack2.pop());
        }

        while (!yardimciStack.isEmpty()) { //yardimci stack bosalana kadar devam et.
            int siradakiEleman = yardimciStack.pop(); //karisik olan yardimci stackten bir eleman al

            while (!siraliStack.isEmpty() && siraliStack.peek() > siradakiEleman) { //sirali stackin en ustundeki eleman, siradaki elemandan büyükse onu oradan tasımalıyız
                yardimciStack.push(siraliStack.pop()); //sirali stack'den geri yardimci stack'e tasi.
            }
            siraliStack.push(siradakiEleman); //istenilen durumdaysa sirali stack icine at.
        }

        return siraliStack;
    } // bu metot icine giren iki stack'i de bozar. Bozulmamasi icin kopyalama islemi yapilabilir...

}
