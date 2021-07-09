package BasicConcepts.thread;

import com.sun.source.tree.SynchronizedTree;

public class PrintEvenoddWithTheHelpOfTwoThread {
    int counter =1;
    int N = 10;
    public static void main(String[] args) {
        PrintEvenoddWithTheHelpOfTwoThread r1 = new PrintEvenoddWithTheHelpOfTwoThread();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                r1.odd();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                r1.even();
            }
        });
        t1.start();
        t2.start();

    }

    public void odd() {
        synchronized (this){
            while(counter < N){
                while(counter%2!=0) {
                    try{
                        System.out.println("even .. wait()");
                        wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                System.out.println("Even " +counter);
                counter++;
                notify();
            }
        }
    }
    public void even() {
        synchronized (this){
            while(counter < N){
                while(counter%2==0) {
                    try{
                        System.out.println("odd .. wait()");
                        wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                System.out.println("Odd " +counter);
                counter++;
                notify();
            }
        }


    }
}

/*
Showing issue was in thread not saved means
package BasicConcepts.thread;
class Even {
    public void even() {
        for (int i=0;i<20;i++){
            if(i%2==0) {
                System.out.println("EVEN "+i);
            }
        }

    }
}

class Odd {
    public void odd() {
        for (int i=0;i<20;i++){
            if(i%2!=0) {
                System.out.println("ODD " +i);
            }
        }

    }
}
public class PrintEvenoddWithTheHelpOfTwoThread {
    public static void main(String[] args) {
        Even r1 = new Even();
        Odd r2 = new Odd();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                r1.even();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                r2.odd();
            }
        });
        t1.start();
        t2.start();

    }
}
*/
