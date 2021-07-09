package ShivamProblems;
/*
* Given a String, rearrange the characters so that any two adjacent char are not same
* EX I = "aab" ,O ="aba"  return "s";
* EX I = "aaab" , O = not possoble  return "";
* */
public class ReorganizeString {
    public static void main(String[] args) {
        String str = "aaba";
        if(str.length()>=2)
            System.out.println("OP : " +CheckreorganizeString( String.valueOf(str.charAt(0)),str.substring(1,str.length())) );
        else
            System.out.println("String should be >2");
    }
    private static String CheckreorganizeString(String ch , String str){
       // System.out.println("ch : "+ch +" str : "+str);
        if(str.isEmpty()){
            if(ch.charAt(ch.length()-1) ==  ch.charAt(ch.length()-2)){
                return "";
            }else
                return "s";
        }
        for ( int i =0;i< str.length();i++){
            if(ch.charAt(ch.length()-1) != str.charAt(i)){
                //modify String
                String temp= str.substring(0,i)+str.substring(i+1,str.length());
               //System.out.println("Tep : "+temp);
                return CheckreorganizeString(ch+str.charAt(i),temp);
            }
        }



    return "";
    }
}
