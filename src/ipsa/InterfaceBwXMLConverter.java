package ipsa;

public class InterfaceBwXMLConverter {



    public static void main(String[] args) {
        String str = "Gigabitethernet1/2/2";
        // String str = "Gigabitethernet1-2/2";
        //   System.out.println("N : "+ str);
        //String str= "1-2-3.1223";
        interfaceCorrectForAlactel(str);
    }

    //Convert Interface in Alcatel format
    private static void interfaceCorrectForAlactel(String str){
        str=str.toLowerCase();//for Alcatel
        if(str.contains(".")){
            str = str.split("\\.")[0];
        }
        int firstIndexOfInteger = 0;

        if(str.contains("g") ||str.contains("x")   ){
            for(int i=0 ;i< str.length() ;i++) {
                char ch = str.charAt(i);
                if (ch >= 48 && ch <= 57) {
                    firstIndexOfInteger = str.indexOf(ch);
                    //System.out.println("firstIndexOfInteger : " + firstIndexOfInteger + " ch " + ch);
                    break;
                }
            }
        }else{
            for(int i=0 ;i< str.length() ;i++){
                char ch = str.charAt(i);
                if(ch >= 48  && ch <= 57){
                    firstIndexOfInteger = str.indexOf(ch);
                    //System.out.println("firstIndexOfInteger : "+firstIndexOfInteger +" ch "+ ch);
                    break;
                }
            }
        }
        str = str.substring(firstIndexOfInteger , str.length() );
        //System.out.println("SubNewInterface : "+str);
        //converting in formate
        for(int i=0;i<str.length();i++ ){
            char ch = str.charAt(i);
            if( !(ch >= 48  && ch <= 57) ){
                System.out.println(" ch "+ ch);
                str = str.replace(ch,'/');
            }
        }
        System.out.println("New Correct formate : "+str);
    }
}
