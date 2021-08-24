package BasicConcepts.thread;

import com.sun.source.tree.SynchronizedTree;
import lombok.Synchronized;

public class PrintEvenoddWithTheHelpOfTwoThread {
    int counter =1;
    int N = 10;
    public static void main(String[] args) {
        PrintEvenoddWithTheHelpOfTwoThread r1 = new PrintEvenoddWithTheHelpOfTwoThread();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //r1.odd();
                r1.printEven();
            }
        },"Thread-1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
               // r1.even();
                r1.printOdd();
            }
        },"Thread-2");
        t1.start();
        t2.start();

    }

    public void odd() {
        synchronized (this){
            while(counter < N){
                while(counter%2!=0) {
                    try{
                        //System.out.println("even .. wait()");
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
                        //System.out.println("odd .. wait()");
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

    private void printEven(){
        synchronized (this){
            while(counter< N){
                if(counter%2!=0){
                   try{
                       wait();
                   }catch (Exception e){
                       e.printStackTrace();
                   }
                }
                System.out.println("Thread name : "+Thread.currentThread()+" "+counter);
                counter++;
               notify();
            }
        }
    }

    private void printOdd(){
        synchronized (this){
            while(counter< N){
                if(counter%2==0){
                    try{
                        wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread name : "+Thread.currentThread()+" "+counter);
                counter++;
                notify();
            }
        }
    }

}
