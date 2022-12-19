package Leetcode.medium;


import leetcode.medium.LetterCombinationsPhoneNumber;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import static leetcode.medium.LetterCombinationsPhoneNumber.letterCombinations;


public class LetterCombinationsPhoneNumberTestCase {

//    Input: digits = "23"
//    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//    "234"
//    ["adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi",
//    "cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]

    @Test
    public void squareTest() {
        Assert.assertEquals(25, 25);
    }

    @Test
    public  void letterCombinationsTest() {
        List<String> expectedlist1 = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf" );
        List<String> expectedlist2 = Arrays.asList( );
        Assert.assertEquals( letterCombinations("23"), expectedlist1 );
        Assert.assertEquals( letterCombinations(""),expectedlist2 );
    }
}
