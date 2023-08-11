import javax.swing.*;

public class ArrayQueue {
    public static int[]a;
    public static int size,front,rear;
    ArrayQueue(int n){
        a=new int[n];
        size=n;
        front=-1;rear=-1;
    }
    public void add(int n)
    {
        if(front==rear&&front==-1){
            a[0]=n;rear=0;
            front=0;
         return;
        }
        rear++;
        if(rear==size){
            System.out.println("Queue out of bound");
            return;
        }
        else a[rear]=n;

    }
    public void remove( ){
        if(rear<front){
            System.out.println("Queue is empty");
            return;

        }
        for(int i=0;i<rear;i++)
            a[i]=a[i+1];
             a[rear]=0;
             rear--;

    }
    public int peek(){
        return a[front];
    }
    public void print(){
        for(int i=front;i<=rear;i++){
            System.out.print(a[i]+"   ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue q=new ArrayQueue(5);
        q.add(2);
        q.add(3);
        q.add(6);
        q.add(9);
        q.print();
        q.peek();
        q.remove();
        q.remove();
        q.print();
    }
}
