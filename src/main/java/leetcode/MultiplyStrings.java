package leetcode;

public class MultiplyStrings {
    public static void main(String[] args) {
        String num1= "89000";
        String num2 = "0";
        String num3 = multiply(num1,num2);
        System.out.println("NUM1 : "+num1+" NUM2 "+num2+" Num3 : "+num3);

    }

    private static String multiply(String num1, String num2) {
        //make num1 = max and num2 = min
        if(num2.length() > num1.length()){ //making num1 max and num2 min
            String str = num1;
            num1 = num2;
            num2 = str;
        }
        int num1Len = num1.length();
        int num2Len = num2.length();

        int carry =0;
        int val = 0;

        int totalpossiblelen = num1Len+num2Len;
        int [][]  output = new int[num2Len][totalpossiblelen];
        //System.out.println("num1 "+num1 +" num2 "+num2);
        for(int i=0 ;i< num2Len ;i++){ //min
            int x = num2.charAt(num2Len-1-i)-48; //min
            carry =0;
            for (int j =0 ;j<num1Len;j++){ //max
                int y = num1.charAt(num1Len-1-j)-48;  //max
                val = (x*y+carry)%10;
               // System.out.println("x "+x+" y "+y+" ca rruy "+carry+" val "+val);
                output[i][totalpossiblelen-j-1-i]=val ;
                carry = (x*y+ carry)/10;
            }
            output[i][totalpossiblelen-num1Len-1-i]=carry ;
        }
        //System.out.println("car" +carry);
       // output[i][totalpossiblelen-num2Len-1-i]=carry ;
        for(int i=0 ;i< num2Len ;i++){
            for (int j =0 ;j<totalpossiblelen;j++){ //max
               // System.out.print(output[i][j] +" ");
            }
           // System.out.println();
        }

        carry=0;
        String out = "" ;
        for(int i=0 ;i< totalpossiblelen ;i++){
            int sum = 0;
            for (int j =0 ;j<num2Len;j++){ //max
              sum=  sum + output[j][totalpossiblelen-1-i];
            }
            out = String.valueOf((sum+carry)%10)+out;
            carry=(sum+carry)/10;
        }
        System.out.println("sum "+out);
        int outLen = out.length();
        for (int ch =0;ch< outLen ;ch++){
            if(out.length()>1 && out.charAt(0)== '0' ){
               out= out.replaceFirst("0","");
            }else break;
        }
        System.out.println("sum "+out);
        return out;
    }
}
