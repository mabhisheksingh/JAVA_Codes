package CodingQuestions.recursion;

//abcde -> edcba
public class ReverseStringUsingRecursion {
    //static char[] charArray = {'H','a','n','n','a','h'};//{'A','n','a','n','d','i','t','a','s'};
    static int count =0;
    public static void main(String[] args) {
        String str = "Abhishek";
        String output = reverse(str);
        char[] charArray = {'H','a','n','n','a','h'};//{'A','n','a','n','d','i','t','a','s'};
        System.out.println("Output : " +output+" Str : "+str);

        for (char c : charArray) {
            System.out.print(c + " ");
        }
        System.out.println();
        reverseCharArray(charArray);

        for (char c : charArray) {
            System.out.print(c + " ");
        }
    }

    private static String reverse(String str) {
        if(str.length()==1){
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
    //char array
    //swaping
    private static void swaping(char [] chars , int pre ,int next){
        char temp = chars[pre];
        chars[pre]= chars[next];
        chars[next] = temp;
    }
    private static void reverseCharArray(char[] str) {
        if(str.length%2==0){
            if (count == str.length/2) {
                swaping(str,count,str.length-count);
                return;
            }
        }else {
            if (count == Math.floor(str.length/2)) {
               // System.out.println("Count : "+count);
                swaping(str,count,count);
                return;
            }
        }
        swaping(str,count,str.length-1-count);
        count++;
        reverseCharArray(str);
        return;

    }
}
