package Thread;

public class PrintEvenOdd {
    private static int count=1;
    private static int total=10;

    public void printEvenNo(){
        synchronized(this){
            while (count<=10){

                while(count%2!=0){
                    // Exception handle
                    try {
                        wait();
                    }
                    catch (
                            InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Even "+count++);
                // Notify to 2nd thread
                notify();
            }
        }


    }

    public void printOddNo(){
        synchronized(this){
            while (count<=10) {
                while(count%2==0){
                    // Exception handle
                    try {
                        wait();
                    }
                    catch (
                            InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("Odd "+count++);
                // Notify to 2nd thread
                notify();
            }

        }



    }
    public static void main(String[] args){
        PrintEvenOdd p=new PrintEvenOdd();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                p.printEvenNo();
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                p.printOddNo();
            }
        });
        t1.start();
        t2.start();

    }
}
