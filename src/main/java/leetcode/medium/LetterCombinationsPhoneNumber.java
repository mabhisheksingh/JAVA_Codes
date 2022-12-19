package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class LetterCombinationsPhoneNumber {

//    Input: digits = "23"
//    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//    "234"
//    ["adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi",
//    "cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]
    
    private static HashMap<Integer,ArrayList<String> > phoneNumberChar = new HashMap<>();
    private static void prepareMap(){
        int k = 97; //ascii for a
        for (int i = 2; i <=9 ; i++) {
            int range =3;
            if(i == 7 || i ==9 ) range = 4;
            for (int j = 0; j < range; j++) {
                if( phoneNumberChar.containsKey(i)){
                    ArrayList<String> list = phoneNumberChar.get(i);
                    list.add( String.valueOf((char)k++));
                    phoneNumberChar.put(i, list);
                } else{
                    ArrayList<String> list = new ArrayList<>();
                    list.add( String.valueOf((char)k++));
                    phoneNumberChar.put(i, list);
                }
            }
        }

//        System.out.println(""+ phoneNumberChar);
    }
    public static void main(String[] args) {
        String digits = "234";
        System.out.println("List : "+letterCombinations(digits));
    }

   

    public static List<String> letterCombinations(String digits) {
        prepareMap();
        if(digits.isEmpty()) return new ArrayList<>();
        if (digits.length() == 1) return phoneNumberChar.get(Integer.parseInt(digits));
        int traverse = 1;
        String [] inputs = digits.split("");
        List<String> output = phoneNumberChar.get( Integer.parseInt(inputs[0]) );
        List<String> str2 = null;
        while (traverse < inputs.length ){
            str2 = phoneNumberChar.get( Integer.parseInt( inputs[ traverse ] ) );
            traverse++;
            List<String> tempList = new ArrayList<>();
            for (int k = 0; k < output.size(); k++) {
                String temp = output.get(k);
                for (int l = 0; l < str2.size(); l++) {
                    tempList.add( temp + str2.get(l) );
                }
            }
            output = new ArrayList<>(tempList);
        }
        return output;
    }
}
