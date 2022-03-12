package leetcode.medium;

public class ZigzagConversion {
    public static void main(String[] args) {
        String str = "PAYPALISHIRING"; //PAHNAPLSIIGYIR
        int row = 3;
        System.out.println(convert(str,row));
    }
    public static String convert(String s, int numRows) {
        if(s.length()<=numRows  || numRows<=1){
            return s;
        }
        int intervals = 2 * numRows - 2;
        int count=0;
        char outputChars [] = new char[s.length()];
        for(int i =0 ;i< numRows;i++){
            int step = intervals - 2 * i;
            for(int j =i ;j < s.length();j+=intervals){
                outputChars[count] = s.charAt(j);
                count++;
                if(step>0  && step < intervals && j+step < s.length()){
                    outputChars[count]= s.charAt(j+step);
                    count++;
                }
            }
        }
        return new String(outputChars);
    }
}
