package CodingQuestions.string;


import com.sun.source.tree.Tree;

import java.util.*;

public class RemoveDuplicatesFromGivenString {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(removeDups(str));
        System.out.println(removeDupsWithHashMap(str));
    }

    //nlogn because set use log(n) time complexity
    private static String removeDups(String str) {
        Set<Character> chars = new HashSet<>();
        for (char ch  : str.toCharArray()) {
            chars.add(ch);
        }
        return chars.toString();
    }
    private static String removeDupsWithHashMap(String str) {
        Map<Character,Character> chars = new LinkedHashMap();
        for (Character ch  : str.toCharArray()) {
            chars.put(ch,ch);
        }
        return chars.toString();
    }

}
