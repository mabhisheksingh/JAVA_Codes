package Leetcode.medium;

import leetcode.medium.Subsets;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsTest {

    @Test
    public  void emptyTest() {
        List<List<Integer>> expectedList = new ArrayList<>();
        int nums[] = {};
        Assert.assertEquals( expectedList ,Subsets.subsets( nums ));
    }
    @Test
    public  void OneTestCase() {
        List<List<Integer>> expectedList = new ArrayList<>();
        expectedList.add(Arrays.asList(0));
        expectedList.add( new ArrayList<>());
        int nums[] = {0};
        Assert.assertEquals( expectedList ,Subsets.subsets( nums ));
    }
}
