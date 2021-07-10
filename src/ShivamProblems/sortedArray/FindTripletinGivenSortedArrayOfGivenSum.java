package ShivamProblems.sortedArray;

public class FindTripletinGivenSortedArrayOfGivenSum {
    public static void main(String[] args) {
        int arr[] = {2,4,5,8,9,20,40};
        int sum = 32;
        String output = tripletSumPossibleOrNot(arr,sum);
        System.out.println("Triplet Exist : "+output);
    }

    private static String tripletSumPossibleOrNot(int[] arr,int sum) {
        String output = "No";
        int temp_sum =0;
        for(int left2 =1 ;left2< arr.length-2;left2++){
            int left = 0,right = arr.length - 1;
            while (left<right){
                if(arr[left] + arr[left2]+arr[right] == sum){
                    System.out.println(arr[left] +" " + arr[left2]+" "+arr[right]);
                    return "yes";
                }
                if(left!=left2 && (arr[left] + arr[left2]+arr[right]) > sum)  right--;
                else left++;

            }

        }
        return output;
    }
}
