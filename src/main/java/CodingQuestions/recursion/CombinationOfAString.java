package CodingQuestions.recursion;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CombinationOfAString {
    /*private static  int count =0;*/
    private static List<String> list = new ArrayList<String>();
    public static void main(String[] args) {
        String str = "nitin";
        System.out.println("Original String : "+str+"\n");
        System.out.println("Before Combination of String : "+list);
        findAllCombinationOfString(str,"",0);
        System.out.println("After Combination of String : "+list);
        list =list.stream().filter(s -> s.length()==2 )
                        .filter(
                                (s)->{
                                    String str2="";
                                    for (int i = 0; i < s.length(); i++) {
                                        str2+=s.charAt(s.length()-i-1);
                                    }
                                    if(str2.equalsIgnoreCase(s)){
                                        return true;
                                    }
                                    return  false;
                                }
                        ).collect(Collectors.toList());
        System.out.println("After Combination of String Filter palindrome : "+list);
        //System.out.println("Combination of String of length r:");
        //findAllCombinationOfStringOflengthR(str,"",0,2);
    }

    private static void findAllCombinationOfString(@NonNull String str, String combString, int counter) {
        if(str.length()==counter){
            list.add(combString);
            System.out.println(combString);
            return;
        }
        counter++;
        findAllCombinationOfString(str,combString,counter);
        findAllCombinationOfString(str,combString+str.charAt(counter-1),counter);
    }

    private static void findAllCombinationOfStringOflengthR(@NonNull String str, String combString, int counter,int r) {
        if(str.length()==counter){
            if(combString.length()==r)
                System.out.println(combString);
            return;
        }
        counter++;
        findAllCombinationOfStringOflengthR(str,combString,counter,r);
        findAllCombinationOfStringOflengthR(str,combString+str.charAt(counter-1),counter,r);
    }
}
