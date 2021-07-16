package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
    public static void main(String[] args) {
        String s = "MCMXCIV";

        int i = romanToInt(s);
        System.out.println(s+" : "+ i);
    }
    private static Map<String, Integer> hash = new HashMap<>();
    private static int romanToInt(String s) {
        int i =0;
        String temp_s=s;
        hash.put("M",1000);
        hash.put("CM",900);
        hash.put("D",500);
        hash.put("CD",400);
        hash.put("C",100);
        hash.put("XC",90);
        hash.put("L",50);
        hash.put("XL",40);
        hash.put("X",10);
        hash.put("IX",9);
        hash.put("V",5);
        hash.put("IV",4);
        hash.put("I",1);
        if(s.length()==1){
            return hash.get(s);
        }else{
            for (int j =0 ;temp_s.length()>0 ;j++){
               // System.out.println("i "+i);
                if(temp_s.length()>=2){
                   // System.out.println("j "+j+" s "+temp_s);
                    String sub = temp_s.substring(0,2);

                    if(hash.containsKey(sub)){
                        i=i+hash.get(sub);
                        temp_s = temp_s.substring(2);
                    }else {
                        char ch = temp_s.charAt(0);
                        //System.out.println("ch "+ch);
                        i+= hash.get(String.valueOf(ch));
                        temp_s = temp_s.substring(1);
                    }
                }else {
                   // System.out.println("ch.... "+temp_s);

                    char ch = temp_s.charAt(0);
                    //System.out.println("ch "+ch+" temp "+temp_s);
                    i+= hash.get(String.valueOf(ch));
                    temp_s = temp_s.substring(1);
                }
               // System.out.println("i "+i);
            }
        }

        return i;

    }
}
