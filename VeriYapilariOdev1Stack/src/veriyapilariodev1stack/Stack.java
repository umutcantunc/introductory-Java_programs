/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veriyapilariodev1stack;

/**
 *
 * @author UMUTCAN TUNÇ
 */
public class Stack {
    private int [] values;
    private int top;
    
    public Stack(int size){
        this.values=new int[size];
        this.top=-1;
    }
    public void push(int val){
        if(isFull())
            System.out.println("stack is full");
        else{
            this.top++;
            this.values[this.top]=val;
        }
    }
    
    public int pop() throws Exception{
        if(isEmpty())
            throw new Exception("Stack is empty");
        else{
            this.top--;
            return this.values[this.top+1];
        }
    }
    
    public int peek() throws Exception{
        if(isEmpty())
            throw new Exception("Stack is empty");
        else{
            return this.values[this.top];
        }
    }
    
    
    public int size(){
        return this.values.length;
    }
    public int count(){
        return this.top+1;
    }
    public void clear(){
        this.top=-1;
    }
    public boolean isEmpty(){
        return this.top==-1;
    }
    
    public boolean isFull(){
        return this.top==this.values.length-1;
        
    }
    public void display(){
        int i=this.top;
        if(top==-1){
            System.out.println("stack is empty");
            return;
        }
            
        while(i!=-1){
            System.out.println(this.values[i]);
            i--;
        }
        System.out.println("");
    }
    
}
