package ShivamProblems;

public class LargestOddNumberInString {
    public static void main(String[] args) {
        String str = "A74f]y9o566";

        int max =-1;
        System.out.println("Str "+str);
        System.out.println(findLargestOddinString(str  ,max));
    }

    private static int findLargestOddinString(String str ,int max){

        if (!str.isEmpty() &&  (  str.charAt( str.length() -1) >=48 &&  str.charAt( str.length() -1) <58 ) ){
            char ch = str.charAt( str.length() -1);
            if ( (ch -48 )%2!=0 ){
                System.out.println(" ch : "+ch);
                if(max < ch-48) {
                    max = ch - 48;
                }
            }
            str= str.substring(0,str.length()-1);
            return findLargestOddinString( str , max);


        }else if(!str.isEmpty()  ){
            str= str.substring(0,str.length()-1);
            return findLargestOddinString( str , max);
        }

        if(str.length()==0){
             return max;
        }
       return max;
    }
}
