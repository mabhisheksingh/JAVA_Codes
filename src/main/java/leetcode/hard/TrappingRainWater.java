package leetcode.hard;

import lombok.experimental.Helper;

//** Example 1 */
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

//* Example 2 */
// Input: height = [4,2,0,3,2,5]
// Output: 9


public class TrappingRainWater {

    public static void main(String[] args) {
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        // int [] height = {4,5,6};
        // int output = trappingRainWater( height);
        int output = trapRainWater( height);
        System.out.println("outPut : "+output);

    }

    //TODO: Brute force method.
    private static int trappingRainWater(int ... args) {
        int trapWater =0;
        for (int i = 1; i < args.length -1 ; i++) {
            //**finding left max
            int leftMax =  args[i];
            for (int j = i-1 ; j >=0 ; j--)
                leftMax = Math.max(leftMax, args[j]);
            //** RightMax */
            int rightMax =  args[i];
            for (int j = i+1 ; j < args.length ; j++ )
                rightMax = Math.max(rightMax, args[j]);
            int waterLevelPoint = Math.min(leftMax, rightMax);
            trapWater+=( waterLevelPoint - args[i]);
        }
        return trapWater;
    }

    //**using memory
    //TODO optimised version
    private static int trapRainWater(int ...heights) {
        int trapWater = 0;
        int len =  heights.length;

        int [] leftMaxArray = new int [len];
        leftMaxArray[0] = heights[0];
        for (int i = 1; i < len ; i++)
            leftMaxArray[i] =  Math.max(leftMaxArray[i - 1], heights[i]);

        int [] rightMaxArray = new int [len];
        rightMaxArray[len-1] = heights[len - 1 ];
        for (int i = len-2; i >=0 ; i--)
            rightMaxArray[i] =  Math.max(rightMaxArray[ i + 1], heights[i]);
        
        for (int i = 1; i < len -1 ; i++)
            trapWater+= ( Math.min(leftMaxArray[i], rightMaxArray[i]) - heights[i]);

        return trapWater;
        
    }
}
