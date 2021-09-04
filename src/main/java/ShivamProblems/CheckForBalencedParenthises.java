package ShivamProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*I/P : stn = "([])"
0/P: Yes
I/P : str = "((())"
O/P : No
I/p: stn = "([)]
0/P: No
I/p: str = "{}([( )])"
0/P : Yes
I/P: str = "(()))"
O/P: No
I/P: str = "({})[{()}]"
O/P: Yes
Check for Balanced Parenthesis
Six Possible Characters in
I/P String:
(,), {,} ,[ and ]*/
public class CheckForBalencedParenthises {
    public static void main(String[] args) {
        String str ="[]";
        String checkBalened = checkBalencedorNot(str,str.length());
        System.out.println("checkBalened "+checkBalened);
    }
    private static String checkBalencedorNot(String str, int strlength) {
        String flag = "Yes";
        Stack<Character> stk = new Stack<>();
        for(int i =0;  i<strlength ;i++){
            char ch = str.charAt(i);
            if(ch =='(' || ch == '{' || ch == '[') { //opening tag
                //System.out.println(" CH "+ch);
                stk.push(ch);
            }else {
                if(stk.isEmpty()) return "No";

                char temp = stk.peek();
                //System.out.println("TEMP : "+temp + " AND CH "+ch);
                if( (temp == '(' && ch == ')'  || temp == '{' && ch == '}'  || temp == '[' && ch == ']')){
                    stk.pop();
                    continue;
                }else return "No";
            }
        }
        if(stk.isEmpty())
            return flag;
        else return "No";
    }

}
