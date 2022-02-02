package leetcode.medium;

public class CountandSay {
    public static void main(String[] args) {
        int n = 4;
        System.out.println("output : "+countAndSay(n));
        //System.out.println(say("3322251"));
    }
    private static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return say( countAndSay(n-1) );
    }
    private static String say(String str){
        String output ="";
        int count=1;
        if (str == "1") {
            return "11";
        }else{
            //334
            for (int i = 1; i < str.length(); i++) {
                if(str.charAt(i-1)==str.charAt(i)){
                    count++;
                }else{
                    output=output+String.valueOf(count)+str.charAt(i-1);
                    count=1;
                }
            }
            output=output+String.valueOf(count)+str.charAt(str.length()-1);
        }

        return output;
    }

    private static String countAndSay(int n,int j) {
        if (n == 1) {
            return "1";
        }
        return say( countAndSay(n-1) );
    }
}
