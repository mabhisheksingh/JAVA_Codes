package leetcode.easy;
//Moore voting algorithm
public class MajorityElement {
    public static void main(String[] args) {
        int []arr ={2,2,1,1,1,2,2,1,1,1,2,2,2,2};
        int element = majorityElement(arr);
        System.out.println("maj element : "+element);
    }
    public static int majorityElement(int[] nums) {
        int frequency = 0;
        int element = 0;
        for (int num : nums) {
            if (frequency == 0) {
                frequency = 1;
                element = num;
            } else if (element == num) {
                frequency++;
            } else {
                frequency--;
            }
        }
        System.out.println("element "+element +" frequency : "+frequency);
        return element;
    }
}
