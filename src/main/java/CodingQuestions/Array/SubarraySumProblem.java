package CodingQuestions.Array;

import java.util.HashMap;

public class SubarraySumProblem {

    static int [] arr= { 10,15,-5,15,-10,6 };
    static int sum = 5;

    public static void main(String[] args) {
        findSubArrayIndex();
    }

    private static void findSubArrayIndex() {
        int currSum=0;
        int startIndex=0;
        int endIndex=-1;
        HashMap<Integer,Integer> hash = new HashMap<>();
        for (int i = 0; i < arr.length ; i++) {
            currSum+=arr[i];
            if(currSum-sum == 0){
                endIndex=i;
                startIndex=0;
                break;
            }
            if (hash.containsKey( currSum- sum )) {
                endIndex=i;
                startIndex= hash.get(currSum - sum)+1;
                break;
            }
            hash.put(currSum,i);
        }
        if(endIndex== -1) System.out.println("Not Fined");
        else System.out.println("Start index : "+startIndex+" End index : "+endIndex);
    }
}
