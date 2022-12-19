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
//    Input: digits ="234"
//    Output: ["adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi",
//    "cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]
    @Test
    public  void emptyLetterCombinationsTest() {
        List<String> expectedList = Arrays.asList( );
        Assert.assertEquals( letterCombinations(""),expectedList );
    }

    @Test
    public  void letterCombinationsTest() {
        List<String> expectedList = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf" );
        Assert.assertEquals( letterCombinations("23"), expectedList );
    }
}
