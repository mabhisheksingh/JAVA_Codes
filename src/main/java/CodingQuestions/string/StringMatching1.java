package CodingQuestions.string;

public class StringMatching1 {

    public static void main(String[] args) {
        String s = "a good   example";
        String output="";
        s = s.replaceAll("\\s","");
        System.out.println(s);
        String [] str = s.split(" ");
        System.out.println(str.length);
        for(int i =str.length-1;i>=0;i--){
            output=output+str[i].trim()+" ";
        }
        System.out.println(output);
    }
}
