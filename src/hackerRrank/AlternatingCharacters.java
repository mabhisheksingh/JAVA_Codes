package hackerRrank;
/*
You are given a string containing characters A and B only. Your task is to change it into a string
such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.

Your task is to find the minimum number of required deletions.

Example
s = AABAAB
Remove an A at positions 0 and 3 to make s=ABAB  in 2 deletions.

Function Description

Complete the alternatingCharacters function in the editor below.

alternatingCharacters has the following parameter(s):

string s: a string
Returns
int: the minimum number of deletions required
*/
public class AlternatingCharacters {
    public static void main(String[] args) {
        alternatingCharacters("AABAAB");
    }
    public static int alternatingCharacters(String s) {
        // Write your code here

        int count = 0;
        char curr ;
        char prev =s.charAt(0);
        for (int i =1;i<s.length();i++){
            curr = s.charAt(i);
            if(prev == curr){
                count++;
            }
            prev =curr;
        }
        System.out.println("S "+s + " count : "+count);
        return 0;
    }
}
