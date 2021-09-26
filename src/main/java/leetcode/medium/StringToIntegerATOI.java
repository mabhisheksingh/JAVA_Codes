package leetcode.medium;

/*
* The algorithm for myAtoi(string s) is as follows:
1. Read in and ignore any leading whitespace.
2. Check if the next character (if not already at the end of the string) is '-' or '+'.
    Read this character in if it is either. This determines if the final result is negative or
    positive respectively. Assume the result is positive if neither is present.
3. Read in next the characters until the next non-digit charcter or the end of the input is reached.
    The rest of the string is ignored.
4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32).
     If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
5. If the integer is out of the 32-bit signed integer range [-231, 231 - 1],
     then clamp the integer so that it remains in the range. Specifically, integers less than -231
     should be clamped to -2^31, and integers greater than 2^31 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
*
* min ::: -2^31 = -2147483648. and max ::: 2^31 -1 = 2147483647*/
public class StringToIntegerATOI {
    public static void main(String[] args) {
        String str ="   -943-5";
        int no = myAtoi(str);
        System.out.println("INT min "+Integer.MIN_VALUE +" MAX "+Integer.MAX_VALUE);
        System.out.println("str : "+str +" No : "+no);
    }

    //DONE
    private static int myAtoi(String str) {
        long min = -2147483648;
        long max = 2147483647;
        long tempnumber = 0;
        long k =1;
        boolean flag= true;
        boolean leadZero= true;
        boolean postive = false;
        boolean negative = false;
        char currch ='A';
        for(int i=0 ;i< str.length() ;i++){
            currch = str.charAt(i);
            if(!( currch >= 48 && currch <=57) && tempnumber!=0){
                break;
            }
            if(currch == '-' || currch == '+' ||  currch == ' ' ||  ( currch >= 48 && currch <=57) && flag  ){
                System.out.println("currch"+currch);
                if( (currch == '-' || currch == '+' ) &&   i+1 < str.length()
                        && (str.charAt(i+1) =='-' || str.charAt(i+1) =='+'
                        || str.charAt(i+1) ==' '  ) && tempnumber ==0  )
                {
                    System.out.println("rrrrrrr" + str.charAt(i+1));
                    if(str.charAt(i+1) =='-' || str.charAt(i+1) =='+' || str.charAt(i+1) ==' '){
                        System.out.println("dsdsds");
                    }
                    return  0;
                }else if(currch == ' ' && tempnumber ==0){
                    postive = true;
                    negative =  false;
                    continue;
                }else if(currch == '+' || currch =='-' || currch == ' ' &&tempnumber ==0 ) {
                    if(currch == '-') {negative = true;postive = false;  };
                    if(currch == '+'  || currch == ' ') {postive = true;negative =  false;  };
                }else if(  currch >= 48 && currch <=57) {
                    if(currch == '0' && leadZero  ) {
                        if( i+1 < str.length() && ( str.charAt(i+1) == ' ' || str.charAt(i+1) == '-'|| str.charAt(i+1) == '+') ){
                            break;
                        }
                        continue;
                    }
                    else {
                        System.out.println("temp before "+tempnumber + " c "+currch + " k "+k +" ne "+negative+" p "+postive);
                        leadZero = false;
                        if(tempnumber >= 0){
                            tempnumber = tempnumber*k  + (currch-48) ;
                        }else {
                            tempnumber = ( tempnumber*k *-1  + (currch-48) )*-1 ;
                        }

                        k = 10;
                        System.out.println("temp After "+tempnumber);
                        if(negative){
                            negative = false;
                            tempnumber= -1 * tempnumber;
                        }
                        if(tempnumber < 0  && tempnumber < min ) return  -2147483648;
                        else  if(tempnumber > 0  && tempnumber > max ) return  2147483647;
                    }
                }else flag = false;

            }else {
                if(currch == '.'){
                    break;
                }
                if(flag){
                   break;
                }else{
                    System.out.println("fla "+flag);
                    break;
                }
            }

        }
       /* if(negative){
            tempnumber= -1 * tempnumber;
        }*/


        return (int) tempnumber;
    }
}
