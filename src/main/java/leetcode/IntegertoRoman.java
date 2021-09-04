package leetcode;
/*
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
Constraints:
1 <= num <= 3999
* */

import java.util.HashMap;

public class IntegertoRoman {
    static HashMap<Integer,String> hash = new HashMap<>();
    public static void main(String[] args) {
        int i = 48;
        if(i>4000) System.out.println("Value out of Range value must in between 1 and 3999");
        String output = intToRoman1(i);
        System.out.println(i+" 1: "+output);
        output = intToRoman(i);
        System.out.println(i+" 2:  "+output);
    }


    private static String ontToThree(int i,String str){
        for(int j =0 ;j <i ;j++){
            str= str + "I";
        }
        return str;
    }

    private static  String fourToEight(int i ,String str){
        if(i ==4) str="IV";
        if(i>4 && i <9){
            str = ontToThree(i-5,"V");
        }
        return str;
    }

    private static  String NineToThirtyNine(int i ,String str){

        int temp_i=i;
        while(temp_i>0){
            int no_of_10 = temp_i/10;
            while (no_of_10>0){
                str=str+hash.get(10);
                no_of_10--;
            }
            temp_i =temp_i - (temp_i/10) * 10;
            if(temp_i ==9){
                str=str+"IX";
                temp_i = temp_i-9;
            }else {
                //System.out.println("temp : "+temp_i+ " Str : "+str);
                str =str+callFinctionAccordingToValue(temp_i,str);
                break;
            }
        }

        return str;
    }

    private static  String fourtyToEightyNine(int i ,String str){

        int temp_i=i;
        while(temp_i>0){
            int no_of_10 = temp_i/50;
            while (no_of_10>0){
                str=str+hash.get(50);
                no_of_10--;
            }
            temp_i =temp_i - (temp_i/50) * 50;
            if(temp_i >=40 && temp_i <50){
                str=str+"XL";
                temp_i = temp_i-40;
                str =str+callFinctionAccordingToValue(temp_i,str);
                break;
            }else {
                str =str+callFinctionAccordingToValue(temp_i,str);
                break;
            }
        }

        return str;
    }

    private static  String ninetyTo399(int i ,String str){

        int temp_i=i;
        while(temp_i>0){
            int no_of_10 = temp_i/100;
            while (no_of_10>0){
                str=str+hash.get(100);
                no_of_10--;
            }
            temp_i =temp_i - (temp_i/100) * 100;
            if(temp_i >=90 && temp_i <100){
                str=str+"XC";
                temp_i = temp_i-90;
                str =str+callFinctionAccordingToValue(temp_i,str);
                break;
            }else {
                str =str+callFinctionAccordingToValue(temp_i,str);
                break;
            }
        }

        return str;
    }

    private static  String fourHundredto899(int i ,String str){

        int temp_i=i;
        while(temp_i>0){
            int no_of_10 = temp_i/500;
            while (no_of_10>0){
                str=str+hash.get(500);
                no_of_10--;
            }
            temp_i =temp_i - (temp_i/500) * 500;
            if(temp_i >=400 && temp_i <500){
                str=str+"CD";
                temp_i = temp_i-400;
                str =str+callFinctionAccordingToValue(temp_i,str);
                break;
            }else {
                str =str+callFinctionAccordingToValue(temp_i,str);
                break;
            }
        }

        return str;
    }

    private static  String NineHundredto3999(int i ,String str){

        int temp_i=i;
        while(temp_i>0){
            int no_of_10 = temp_i/1000;
            while (no_of_10>0){
                str=str+hash.get(1000);
                no_of_10--;
            }
            temp_i =temp_i - (temp_i/1000) * 1000;
            if(temp_i >=900 && temp_i <1000){
                str=str+"CM";
                temp_i = temp_i-900;
                str =str+callFinctionAccordingToValue(temp_i,str);
                break;
            }else {
                str =str+callFinctionAccordingToValue(temp_i,str);
                break;
            }
        }

        return str;
    }

    private static String callFinctionAccordingToValue(int i ,String str){
        if(i ==0 ) return "";
        if(i >= 1 && i<4){
            return ontToThree(i,"");
        }else if(i >=4 && i<9){
            return fourToEight(i,"");
        }else if(i >= 9 && i< 40){
            return NineToThirtyNine(i,"");
        }else if( i >=40  &&  i<90){
            return fourtyToEightyNine(i,"");
        }else  if( i >=90 && i <400){
            return ninetyTo399(i,"");
        }else  if( i >=400 && i <900){
            return fourHundredto899(i,"");
        }else  if( i >=900 && i <3999){
            return NineHundredto3999(i,"");
        }
        return str;
    }

    private static String intToRoman1(int i) {

        hash.put(1,"I");
        hash.put(5,"V");
        hash.put(10,"X");
        hash.put(50,"L");
        hash.put(100,"C");
        hash.put(500,"D");
        hash.put(1000,"M");
        String str="";
        if(i >= 1 && i<4){
           return ontToThree(i,"");
        }else if(i >=4 && i<9){
            return fourToEight(i,"");
        }else if(i >= 9 && i< 40){
            return NineToThirtyNine(i,"");
        }else if( i >=40  &&  i<90){
            return fourtyToEightyNine(i,"");
        }else  if( i >=90 && i <400){
            return ninetyTo399(i,"");
        }else  if( i >=400 && i <900){
            return fourHundredto899(i,"");
        }else  if( i >=900 && i <=3999){
            return NineHundredto3999(i,"");
        }


        return str;
    }

    //optimize Solution
    private static String intToRoman(int num) {
        String rom[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int n[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String sol="";
        for(int i=0;num>0;i++)
        {
            int k= num/n[i];
            for(int j=0;j<k;j++)
                sol =sol +(rom[i]);
            num %= n[i];
        }
        return sol;
    }
}
