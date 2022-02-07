package leetcode.medium;

import java.math.BigInteger;
import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        //"1437219"--2-->"13219"
        String num="10001";
        int k=4;
        System.out.println("Output "+removeKdigits(num,k));
    }
    private static String removeKdigits(String num, int k) {
        if(num.length()==k) return "0";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            if(stack.isEmpty()){
                if(num.charAt(i)!='0') continue;
                else stack.push(num.charAt(i)-'0');
            }else{
                int topPosition = stack.peek();// num.charAt(i) - '0';
                int curNum = num.charAt(i) - '0';
                while(!stack.isEmpty() && k>0 && topPosition>curNum){
                    stack.pop();
                    k--;
                    if (!stack.isEmpty()) topPosition = stack.peek();
                    else break;
                }
                if(stack.isEmpty() && num.charAt(i)=='0') continue;
                else stack.push(curNum);
            }
        }
        while (!stack.isEmpty()&&k>0){
            stack.pop();
            k--;
        }
        if(stack.isEmpty() || k > stack.size())return "0";
        num="";
        for (int i = 0; i < stack.size(); i++) {
            num+=String.valueOf(stack.get(i));
        }
        System.out.println(num);
        return num;
    }
}
