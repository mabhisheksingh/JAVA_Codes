package CodingQuestions.string;

import lombok.NonNull;

public class CheckStringsAreRotationsOfEachOtherOrNot {
    public static void main(String[] args) {
        String str1 = "rvvsvczyczqjojiovkpokdbaeggkqbchwxzucasgzlpquzeplvfvygxepdofftmdsnxunscpdthxslpdgub";
        String str2 =   "vsvczyczqjojiovkpokdbaeggkqbchwxzucasgzlpquzeplvfvygxepdofftmdsnxunscpdthxslpdgubrv";
        //System.out.println(0%5);
        System.out.println("1 : String are rotated or not "+areRotations1(str1,str2));
        System.out.println("2 : String are rotated or not "+areRotations2(str1,str2));
    }

    private static boolean areRotations1(String str1, String str2) {
        if(str1.length()!=str2.length()){
            return false;
        }else if(str1.equals(str2)){
            return true;
        }
        int postionOfFirstCharOfStr1 = 0;//count
        char ch = str1.charAt(0);
        while (postionOfFirstCharOfStr1 < str1.length() ) {
            for (int i = postionOfFirstCharOfStr1; i < str2.length(); i++) {
                if (ch == str2.charAt(i)) {
                    postionOfFirstCharOfStr1 = i;
                    break;
                }
            }
            int flag =0;
            for (int i = postionOfFirstCharOfStr1; i < (str2.length()+postionOfFirstCharOfStr1); i++) {
                System.out.println("postionOfFirstCharOfStr1 "+ postionOfFirstCharOfStr1+" i : "+i);
                if(str1.charAt(i-postionOfFirstCharOfStr1)!= str2.charAt(i%str2.length())){
                    System.out.println("!= "+str1.charAt(i-postionOfFirstCharOfStr1));
                    postionOfFirstCharOfStr1++;
                    flag=1;
                    break;
                }
                System.out.println("== "+str1.charAt(i-postionOfFirstCharOfStr1));
            }
            if(flag==0)
                return true;
        }
        return false;
    }
//Time O(n) and Space O(n)
    private static boolean areRotations2(String str1,String str2){
        if(str1.length()!=str2.length()) return false;
        if(str1.equals(str2)) return true;

        return false;
    }
}
