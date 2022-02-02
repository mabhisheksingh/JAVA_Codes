package swati;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class length{
    public static void main(String args[]) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the Name : ");
        String s=in.readLine();

        System.out.println("Lenth of Name "+s.length());
    }
}
