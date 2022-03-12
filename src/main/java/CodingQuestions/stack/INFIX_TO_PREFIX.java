package CodingQuestions.stack;

import java.util.*;
import java.util.stream.Collectors;

public class INFIX_TO_PREFIX {
    static ArrayDeque<Character> stack = new ArrayDeque<>();
    static ArrayDeque<String> stackPrefixToInfix = new ArrayDeque<>();
    static Map<Character,Integer> hash = new HashMap<>();
    static {
        hash.put('+',0);
        hash.put('-',0);
        hash.put('*',1);
        hash.put('/',1);
        hash.put('^',2);
    }
    public static void main(String[] args) {
        String str = " A * B + C / D+r-t*u^d";
        System.out.println("Original String : "+str.trim());
        StringBuilder output = infixToPrefix(str);
        System.out.println("infixToPrefix : "+output);
        System.out.println("prefixToInfix   : "+prefixToInfix(output));
    }

    private static StringBuilder infixToPrefix(String str) {
        StringBuilder output = new StringBuilder("");
        for (int i = str.length()-1; i >=0 ; i--) {
            if(str.charAt(i)==32) continue;
            if((str.charAt(i) >= 97 && str.charAt(i) <= 122)||(str.charAt(i) >= 65 && str.charAt(i) <= 92)){
                output.append(str.charAt(i));
            }else{
                if(stack.isEmpty() || hash.get(stack.peek()) <= hash.get(str.charAt(i)) ){
                    stack.push(str.charAt(i));
                }
                else if(hash.get(stack.peek()) > hash.get(str.charAt(i)) )  { //dcb^*
                    do {
                        output = output.append(stack.pop());
                    }while( !stack.isEmpty() && hash.get(stack.peek()) > hash.get(str.charAt(i)));
                    stack.push(str.charAt(i));
                }
            }
        }
        while (!stack.isEmpty()){
            output.append(stack.pop());
        }
        return output.reverse();
    }

    private static String prefixToInfix(StringBuilder str){
        StringBuilder output = new StringBuilder("");
        for (int i = str.length()-1; i >=0 ; i--) {
            char ch = str.charAt(i);
            if(ch==32) continue;
            if((str.charAt(i) >= 97 && str.charAt(i) <= 122)||(str.charAt(i) >= 65 && str.charAt(i) <= 92)){
                stackPrefixToInfix.push(String.valueOf(ch));
            }
            else{
                String justPrevChar = stackPrefixToInfix.pop();
                String justAfterPrevChar = stackPrefixToInfix.pop();
                String temp = String.valueOf(justPrevChar)+String.valueOf(ch)+String.valueOf(justAfterPrevChar);
                stackPrefixToInfix.push(temp);
            }
        }
        return Arrays.stream(stackPrefixToInfix.pop().split("")).collect(Collectors.joining(" ")).trim();
    }
}
