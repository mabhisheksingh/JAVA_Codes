package CodingQuestions.recursion;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class ReverseANumber {
    static int ans= 0;
    public static void main(String[] args) {
        int number = 124;
        int rev = reverse(number);
        if(number == rev){
            System.out.println(number+" is Palindrome");
        }else
            System.out.println(rev +" is not Palindrome");

    }
    private static int reverse(int number){
        if(number==0)
            return number;
        ans =  ans*10+ number%10;
        reverse(number/10);
        return ans;

    }
}
