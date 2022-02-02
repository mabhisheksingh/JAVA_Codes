package CodingQuestions.recursion;

import java.util.Stack;

public class ReverseStackUsingRecursion {
    static Stack<Character> st = new Stack<>();
    public static void main(String[] args) {
        st.push('a');
        st.push('b');
        st.push('c');
        st.push('d');
        System.out.println(st);
        st = reverse(st);
        System.out.println(st);
    }
    private static Stack<Character> reverse(Stack<Character> st) {
        if(st.isEmpty())
            return st;
        char ch = st.pop();
        System.out.println(ch);
        reverse(st);
        System.out.println(ch);
        pushing(ch);
        return st;
    }
    private static void pushing(char ch){
        if(st.isEmpty()){
            st.push(ch);
        }else
        {
            char a = st.pop();
            pushing(ch);
            st.push(a);
        }
    }
}
