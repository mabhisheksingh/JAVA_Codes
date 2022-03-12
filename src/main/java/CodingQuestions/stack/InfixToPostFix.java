package CodingQuestions.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class InfixToPostFix {
    static ArrayDeque<Character> stack = new ArrayDeque<>();
    static ArrayDeque<String> stackPostfixToInfix = new ArrayDeque<>();
    static Map<Character,Integer> hash = new HashMap<>();
    static {
        hash.put('+',0);
        hash.put('-',0);
        hash.put('*',1);
        hash.put('/',1);
        hash.put('^',2);
    }
    public static void main(String[] args) {
        String str = " A * B + C / D+r-t*u^d"; //A+b *c;--> Abc*+
        System.out.println("Original String : "+str.trim());
        StringBuilder output = infixToPostfix(str);
        System.out.println("infixToPostfix : "+output);
        System.out.println("postfixToInfix   : "+postfixToInfix(output.toString()));
    }

    private static String postfixToInfix(String str) {
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i <str.length() ; i++) {
            char ch = str.charAt(i);
            if(ch==32) continue;
            if((str.charAt(i) >= 97 && str.charAt(i) <= 122)||(str.charAt(i) >= 65 && str.charAt(i) <= 92)){
                stackPostfixToInfix.push(String.valueOf(ch));
            }
            else{
                String justPrevChar = stackPostfixToInfix.pop();
                String justAfterPrevChar = stackPostfixToInfix.pop();
                String temp = String.valueOf(justPrevChar)+String.valueOf(ch)+String.valueOf(justAfterPrevChar);
                stackPostfixToInfix.push(temp);
            }
        }
        return new StringBuilder(Arrays.stream(stackPostfixToInfix.pop().split("")).collect(Collectors.joining(" "))).reverse().toString();
    }

    private static StringBuilder infixToPostfix(String str) { //A * B + C / D+r-t*u^d --> AB*CD/rtud^*-
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i <str.length() ; i++) {
            //System.out.println("stringBuilder "+stringBuilder);
            char ch  = str.charAt(i);
            if(ch ==32 ) continue;
            if ( (ch >= 65 && ch <=92) || (ch  >=97 && ch <=122) ) {
                stringBuilder.append(ch);
            }else if(stack.isEmpty() || (hash.get(stack.peek() ) < hash.get(ch))) stack.push(ch);
            else {
                do{
                    char temp = stack.pop();
                    stringBuilder.append(temp);
                }while ( !stack.isEmpty() && hash.get(stack.peek() ) >= hash.get(ch));
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) stringBuilder.append(stack.pop());
        return stringBuilder;
    }
}
