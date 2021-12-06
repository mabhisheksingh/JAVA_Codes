package leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/*
* Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n
* vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
* Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
Notice that you may not slant the container.
* */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int [] height = {4,3,2,1,4};//{1,8,6,2,5,4,8,3,7};
        int output = containerWithMostWater(height);
        System.out.println("Output : "+output);
    }

    //use two pointer approach
    private static int containerWithMostWater(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea=0;
        int currentArea  = 0;
        while(left!=right && left < right) {
            if (height[left] <= height[right]) {
                currentArea = (right-left)*height[left];
                left++;
            }else{
                currentArea = (right-left)*height[right];
                right--;
            }
            if (currentArea > maxArea) {
                maxArea= currentArea;
            }
        }

        return maxArea;
    }
}
