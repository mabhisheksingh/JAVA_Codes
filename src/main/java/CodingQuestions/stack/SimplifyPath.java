package CodingQuestions.stack;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
//        String str = "//a/../../bee/../c//.//f1//";
//        String str = "/.../";
        String str = "/../";
        System.out.println("output : "+simplifyPath(str) );
    }
    public static String simplifyPath(String path) {
        if( path.length() == 0) return "/";
        String str [] = path.split("/");
        Stack<String> stack = new Stack<>();
//        for (int i = 0; i < str.length; i++) {
//            System.out.println("str : "+str[i]);
//            if( !str[i].equalsIgnoreCase("") )
//                stack.push(str[i]);
//        }
//        System.out.println();
        for (int i = 0; i < str.length; i++) {
            if (str[i].equalsIgnoreCase(".") || ( str[i].equalsIgnoreCase("..") && stack.isEmpty() ) ) continue;
            if( !str[i].equalsIgnoreCase("") ){
                if( str[i].equalsIgnoreCase("..") && !stack.isEmpty()){
                    stack.pop();
                }else{
                    stack.push(str[i]);
                }
            }
        }
        StringBuilder stringBuilder =new StringBuilder("/");
        while (!stack.isEmpty()){
           String string = stack.pop();
           if( string.equalsIgnoreCase(""))continue;
            stringBuilder.insert(0,string);
            stringBuilder.insert(0,"/");
        }
//        stringBuilder.reverse();
        if( stringBuilder.length() > 1) stringBuilder.replace( stringBuilder.length() -1 , stringBuilder.length() , "");

        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }

}