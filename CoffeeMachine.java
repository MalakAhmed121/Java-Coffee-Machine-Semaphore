 class Semaphore {
    protected int value = 0;

    protected Semaphore() {
        value = 0;
    }

    protected Semaphore(int initial) {
        value = initial;
    }

    protected synchronized void P() {
        value--;
       if (value < 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }

    protected synchronized void V() {
        value++;
        if (value <= 0)
            notify();
    }

}
public class CoffeeMachine {
    Semaphore CoffSemaphore=new Semaphore();

    public CoffeeMachine() {
    CoffSemaphore = new Semaphore(1);
    }

    public CoffeeMachine(int capacity){
     CoffSemaphore=new Semaphore(capacity);
    }

    public void  UseMachie(){
        CoffSemaphore.P();
    }

    public void  LeaveMachine(){
     CoffSemaphore.V();
    }
}

class customur implements Runnable{

CoffeeMachine cm;

 customur(CoffeeMachine cm){
    this.cm=cm;
}

    public void run(){
        // System.out.println(Thread.currentThread().getName()
        // + " is waiting");
        cm.UseMachie();
         System.out.println(Thread.currentThread().getName()
                + " Use the machine");
         try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()
                + " Leave  the machine");
        cm.LeaveMachine();
    
 }
 

}


class Main {
    public static void main(String[] args) {
        CoffeeMachine coffeemachine = new CoffeeMachine(3);
       
        Thread c1 = new Thread(new customur(coffeemachine), "customur 1");
        Thread c2 = new Thread(new customur(coffeemachine), "customur 2");
        Thread c3 = new Thread(new customur(coffeemachine), "customur 3");
        Thread c4 = new Thread(new customur(coffeemachine), "customur 4");
        Thread c5 = new Thread(new customur(coffeemachine), "customur 5");
    
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }
}
