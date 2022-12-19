package Tree;
/*
for n =4
*
* *
* * *
* * * *

* */
public class PatternPrinting {
    public static void main(String[] args) {
        printPattern(4);
    }

    private static void printPattern(int i) {
        int uptoPrint=i;
        if(i==0) return;
        printPattern(i-1);
        for (int j = 0; j < uptoPrint; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
