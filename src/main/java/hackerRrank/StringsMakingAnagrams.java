package hackerRrank;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/*
* A student is taking a cryptography class and has found anagrams to be very useful.
* Two strings are anagrams of each other if the first string's letters can be rearranged to form the second string.
*  In other words, both strings must contain the same exact letters in the same exact frequency. For example,
* bacdc and dcbac are anagrams, but bacdc and dcbad are not.

The student decides on an encryption scheme that involves two large strings.
* The encryption is dependent on the minimum number of character deletions required to make the
* two strings anagrams. Determine this number.

Given two strings, a and b, that may or may not be of the same length, determine the minimum number of character
* deletions required to make a and b anagrams. Any characters can be deleted from either of the strings.

Example
a = 'ced';
b = 'dcf'

Delete  e from a and  f from b so that the remaining strings are  and  which are anagrams. This takes  character deletions.
Function Description
*/
public class StringsMakingAnagrams {
    public static void main(String[] args) {
        //makeAnagram("aacccffrr" , "aabbccde");
       makeAnagram("bacdc" , "dcbad");
    }

    public static int makeAnagram(String a, String b) {
        // Write your code here
        int count = 0;
        HashMap<Character ,Integer> hasha = new HashMap<Character ,Integer>();
        HashMap<Character ,Integer> hashb = new HashMap<Character ,Integer>();
        for (int i =0;i< a.length() ; i++){
            if(hasha.containsKey( a.charAt(i))){
                hasha.put( a.charAt(i) , 1+hasha.get(a.charAt(i)));
            }else{
                hasha.put( a.charAt(i) , 1);
            }
        }
        for (int i =0;i< b.length() ; i++){
            if(hashb.containsKey( b.charAt(i))){
                hashb.put( b.charAt(i) , 1+hashb.get(b.charAt(i)));
            }else{
                hashb.put( b.charAt(i) , 1);
            }
        }
        //System.out.println("HASH A "+hasha +" HASH B "+ hashb);

        for (Character key : hasha.keySet()){

            if(hashb.containsKey(key)){
                count = count + Math.abs( hasha.get(key) - hashb.get(key));
            }else {
                count = count + hasha.get(key);
            }
        }

        for (Character key : hashb.keySet()){

            if(!hasha.containsKey(key)){
                count = count + hashb.get(key);
            }
        }

        //System.out.println(" Count : "+count);
        return count;
    }
}
