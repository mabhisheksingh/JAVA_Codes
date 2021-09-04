package leetcode;
/*You are given a string s consisting only of characters 'a' and 'b'
You can delete any number of characters in s to make s balanced.
s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.
 Return the minimum number of deletions needed to make s balanced.*/
public class MinimumDeletionstoMakeStringBalanced {
    public static void main(String[] args) {
        String str = "baababbaabbaaabaabbabbbabaaaaaabaabababaaababbb"; //bbaaaaabb
        //            .aa.a..aa..aaa.aa........aaaaaab..bababaaababbb
        int i = minimumDeletions(str);
        System.out.println(str+" : "+i);
    }
    private static int minimumDeletions(String s) {
        int a_count_max =0;
       // int temp_a_count =0;
        int b_count_max =0;
       // int temp_b_count =0;//aababbab -> aaabbb or aabbbb
        //bbaaaaabb --> aaaaabb
        int count =1;
        int minDel =0;
        char prev = s.charAt(0);
        char curr ;
        for(int i =1 ;i<s.length() ;i++){
            curr = s.charAt(i);
            if(prev == curr){
                count++;
                prev = curr;
            }else{
                System.out.println("prev  "+prev + " curr "+ curr + " count "+count+" i "+i);
               if(prev == 'a') {
                   //temp_a_count = count;
                   if(a_count_max < count ){
                       minDel = minDel+a_count_max;
                       a_count_max = count;
                       if(count >= b_count_max ){
                           minDel = minDel+b_count_max;
                       }
                   }else if(count >= b_count_max ){
                       minDel = minDel+b_count_max;
                       a_count_max = a_count_max+ count;
                   }

               } else  if(prev == 'b') {
                   //temp_b_count = count;
                   if(b_count_max <count ){
                       minDel = minDel+b_count_max;
                       b_count_max = count;
                       if(count >= a_count_max ){
                           minDel = minDel+a_count_max;
                       }
                   }else if(count >= a_count_max ){
                       minDel = minDel+a_count_max;
                       b_count_max = b_count_max+ count;
                   }
               }
                count =1;
               prev = curr;
            }
            prev = curr;
        }
        System.out.println(" d "+ (s.length() - minDel));
    return minDel;
    }
}
