package Recursionproblems;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class RecursionFirst {
    public static void main(String[] args) {
        String str ="aabacaaaaacccccceeeeff";
        HashMap<String,String> hash = new HashMap<String,String>();
        System.out.println("String W duplicate :"+str);
        removeDuplicateChar(str,hash);
        System.out.println("String WO duplicate :"+hash);
    }
    //remove dublicate char from string
    private static @NotNull
    HashMap<String, String> removeDuplicateChar(String str, HashMap<String, String> hash) {
      //  HashMap<String, String> hashMap;
        if (str.length() == 1) {
            hash.put(str,str);
            return hash;
        }
        String lastchar =  String.valueOf( str.charAt(str.length() - 1) ) ;
        hash = removeDuplicateChar(str.substring(0,str.length()-1) ,hash);
        if(!hash.containsKey(lastchar)){
           hash.put(lastchar,lastchar);
        }
        return hash;
    }



}
