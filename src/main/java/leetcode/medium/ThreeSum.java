package leetcode.medium;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};//{2,7,11,15};
        List<List<Integer>> lists = threeSumOptimized(arr);
        System.out.println("List output : "+ lists);
    }
// {-1,0,1,2,-1,-4};
    private static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> output = new ArrayList<>();
        Map<String,String> confict = new HashMap<>();
        for (int i = 0; i < arr.length-2; i++) {
            int temp_1 = arr[i];
            Map<Integer,Integer> hash = new HashMap<>();
            for (int j = i+1; j < arr.length; j++) {
                int temp = arr[j];
                int completed = temp_1+temp;
                if(!hash.isEmpty()){
                    if(completed == 0 ){
                        if(hash.containsKey(0)){
                            List<Integer> integerList = new ArrayList<>();
                            integerList.add(temp);
                            integerList.add(temp_1);
                            integerList.add(0);
                            int max = Math.max(temp , Math.max(temp_1,0));
                            int min = Math.min(temp , Math.min(temp_1,0));
                            int mid = temp + temp_1 + 0 - max - min;
                            String temp2 =String.valueOf(max)+String.valueOf(min)+String.valueOf(mid);
                            if(!confict.containsKey(temp2)){
                                output.add(integerList);
                                confict.put(temp2,temp2);
                            }
                        }
                    }else{
                        if(hash.containsKey( -1* completed)){
                            List<Integer> integerList = new ArrayList<>();
                            integerList.add(temp);
                            integerList.add(temp_1);
                            integerList.add( -1* completed);
                            int max = Math.max(temp , Math.max(temp_1,-1* completed));
                            int min = Math.min(temp , Math.min(temp_1,-1* completed));
                            int mid = temp + temp_1 + -1* completed - max - min;
                            String temp2 =String.valueOf(max)+String.valueOf(min)+String.valueOf(mid);
                            if(!confict.containsKey(temp2)){
                                output.add(integerList);
                                confict.put(temp2,temp2);
                            }
                        }
                    }

                }
                hash.put(temp,temp);
            }
        }
        return output;
    }

    private static List<List<Integer>> threeSumOptimized(int[] arr) {
        List<List<Integer>> output = new ArrayList<>();
        Map<String,String> conflict = new HashMap<>();
        for (int i = 0; i < arr.length-2; i++) {
            int temp_1 = arr[i];
            Map<Integer,Integer> hash = new HashMap<>();
            for (int j = i+1; j < arr.length; j++) {
                int temp = arr[j];
                int completed = temp_1+temp;
                if(!hash.isEmpty()){
                    if(hash.containsKey( -1* completed)){
                            List<Integer> integerList = new ArrayList<>();
                            integerList.add(temp);
                            integerList.add(temp_1);
                            integerList.add( -1* completed);
                            int max = Math.max(temp , Math.max(temp_1,-1* completed));
                            int min = Math.min(temp , Math.min(temp_1,-1* completed));
                            int mid = temp + temp_1 + -1* completed - max - min;
                            String temp2 =String.valueOf(max)+String.valueOf(min)+String.valueOf(mid);
                            if(!conflict.containsKey(temp2)){
                                output.add(integerList);
                                conflict.put(temp2,temp2);
                            }
                    }
                }
                hash.put(temp,temp);
            }
        }

        return output;
    }


}
