package ShivamProblems.UnsortedArray;

/*
majority element should appear more than n/2 times.... where n is no. of element
*/

public class MajorityElement {
    public static void main(String[] args) {
        int arr[] = {2,3,4,5,1,1,1,1,1,1};
        //int arr[] = {1,0,1,0,0,0,1,1,1,1};
        //int arr[] = {8,3,4,8,8};
        //int arr[] = {3,7,4,7,7,5};
        findMajorityElement(arr);
        findMajorityElementOptimize(arr);
    }

    private static void findMajorityElement(int[] arr) {
        int majority_element_count =0;
        int majority_element_value =0;
        int temp_1_value =arr[0];
        int temp_1_count = 1;
        int temp_2_value =arr[1];
        int temp_2_count = 1;
        for(int i  =2;i< arr.length ;i++){
            if(temp_1_value == arr[i]){
                temp_1_count++;
                if(majority_element_count < temp_1_count){
                    majority_element_count = temp_1_count;
                    majority_element_value = temp_1_value;
                }
            }else if (temp_2_value == arr[i] ){
                temp_2_count++;
                if(majority_element_count < temp_2_count) {
                    majority_element_count = temp_2_count;
                    majority_element_value = temp_2_value;
                }
            }else {
                if(majority_element_count < temp_1_count){
                    majority_element_count = temp_1_count;
                    majority_element_value = temp_1_value;
                }
                if(majority_element_count < temp_2_count) {
                    majority_element_count = temp_2_count;
                    majority_element_value = temp_2_value;
                }
                temp_1_value = arr[i];
                temp_1_count = 1;
            }
        }

        System.out.println( "majority_element_value : "+majority_element_value+" majority_element_count : "+majority_element_count);
        int temp_count =0;
        for(int i=0;i< arr.length ;i++){
            if(majority_element_value == arr[i]){
                temp_count++;
            }
        }
        if(temp_count > arr.length/2)
            System.out.println("output " +majority_element_value);
        else {
            System.out.println("output No Majority");
        }

    }

    private static void findMajorityElementOptimize(int []arr){
        int majority_element_count =1;
        int majority_element_value =arr[0];
        int temp_1_value =arr[0];
        int temp_1_count = 0;
        for (int i=1 ;i< arr.length;i++){
            if(temp_1_value == arr[i]){
                temp_1_count++;
                if(majority_element_count < temp_1_count){
                    majority_element_count = temp_1_count;
                    majority_element_value = temp_1_value;
                }
            }else {
                if(majority_element_count < temp_1_count){
                    majority_element_count = temp_1_count;
                    majority_element_value = temp_1_value;
                }

                temp_1_value = arr[i];
                temp_1_count = 1;
            }
        }
        System.out.println( "majority_element_value : "+majority_element_value+" majority_element_count : "+majority_element_count);
    }
}
