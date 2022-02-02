package swati;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input {
    public static void main(String args[]) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("ENTER ANY INTEGER NO:");
        int i = Integer.parseInt(in.readLine());
        System.out.println("ENTER ANY float NO:");
        float f = Float.parseFloat(in.readLine());
        System.out.println("ENTER ANY STRING:");
        String s = in.readLine();
        System.out.println("INTEGER:" + i);
        System.out.println("FLOAT:" + f);
        System.out.println("STRING:" + s);

    }
}

