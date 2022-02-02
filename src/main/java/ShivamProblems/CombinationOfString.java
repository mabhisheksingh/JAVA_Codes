package ShivamProblems;

public class CombinationOfString {
    public static void main(String[] args) {
        String str = "abc";
        String input = "";
        printAllCombination(input ,str);
    }

    private static void printAllCombination(String input ,String str){
        if(str.length() == 0 ){
            System.out.println(input);
            return;
        }
        printAllCombination(input,str.substring(0 ,str.length() -1 )) ;
        printAllCombination(str.charAt(str.length() -1)+input,str.substring(0 ,str.length() -1 )) ;
    }
}
