import BinarySearch.MyBinarySearch;
import DynamicProgramming.LongestSequenceTwoArrays;

import java.util.Arrays;

import static ArraysWithHashing.Easy.GetConcatination.getConcatenation;
import static ArraysWithHashing.Easy.PivotIndex.pivotIndex;
import static ArraysWithHashing.Easy.RemoveDuplicates.removeDuplicates;
import static ArraysWithHashing.Easy.RemoveElement.removeElement;
import static ArraysWithHashing.Easy.TwoSum.twoSum;
import static ArraysWithHashing.Medium.GroupAnagrams.groupAnagrams;
import static ArraysWithHashing.Medium.LongestConsecutiveSequence.longestConsecutive;
import static ArraysWithHashing.Medium.ProductExceptSelf.productExceptSelf;
import static ArraysWithHashing.Medium.TopKFrequent.topKFrequent;
import static BinarySearch.EatingBananas.minEatingSpeed;
import static DynamicProgramming.ClimbingStairsWithCost.minCostClimbingStairs;
import static DynamicProgramming.UniquePathsWithObstacles.uniquePathsWithObstacles;
import static Graphs.CourseSchedule.canFinish;
import static SlidingWindow.BadgeTimes.badgeTimes;
import static SlidingWindow.IsSubsequence.isSubsequence;
import static SlidingWindow.LongestPalindrome.longestPalindrome;
import static SlidingWindow.LongestRepeatingCharacterReplacement.characterReplacement;
import static SlidingWindow.LongestSubstringWithoutRepeat.lengthOfLongestSubstring;
import static SlidingWindow.PermutationInString.checkInclusion;
import static SlidingWindow.findAnagrams.findAnagrams;
import static Stack.DailyTemperatures.dailyTemperatures;
import static Stack.QueuePractice.countStudents;
import static Stack.StackPractice.calPoints;
import static TwoPointers.ContainerWithTheMostWater.maxArea;
import static TwoPointers.ThreeSum.threeSum;
import static TwoPointers.TwoSum2.twoSum2;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("TwoSum: "+ Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));

        System.out.println("Pivot Index: "+ pivotIndex(new int[]{1,7,3,6,5,6}));

        int i =  MyBinarySearch.myBinarySearch(new int[]{1,0,3,5,9,12},2);
        int j = lengthOfLongestSubstring("dvdf");

        System.out.println("Group anagrams: "+ groupAnagrams(new String []{"eat","tea","tan","ate","nat","bat"}));
        System.out.println("two sum with 0(1) space: "+ Arrays.toString(twoSum2(new int[]{1,2,3,4,4,9,56,90}, 8)));
        System.out.println("string replacement: "+ characterReplacement("ABAB",2));
        System.out.println("topKfrequent: "+Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));


        int [] res = productExceptSelf(new int[]{1,2,3,4});

        threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.print("Finding Maximum longest subarray in 2 arrays: "+LongestSequenceTwoArrays.FindMaxLength(new int[]{1, 2, 8, 2, 1}, new int[]{8, 2, 1, 4, 7 }));


        String[] user1 = {"grey", "pink", "green", "red","black","silver"};
        String[] user2 = {"grey", "rose red", "white", "pink", "green", "red","black","silver"};
        System.out.println("Longest contiguous in two arrays is "+ LongestSequenceTwoArrays.longestCommonSubarray(user1,user2));

        checkInclusion("adc","dcda");

        maxArea(new int[]{1,2,1});

        longestConsecutive(new int[]{100,4,200,1,3,2});

        String[][] badgeTimes = new String[][] {{"Paul", "1355"}, {"Jennifer", "1910"}, {"Jose", "835"}, {"Jose", "830"},
                {"Paul", "1315"}, {"Chloe", "0"}, {"Chloe", "1910"}, {"Jose", "1615"}, {"Jose", "1640"}, {"Paul", "1405"},
                {"Jose", "855"}, {"Jose", "930"}, {"Jose", "915"}, {"Jose", "730"}, {"Jose", "940"}, {"Jennifer", "1335"},
                {"Jennifer", "730"}, {"Jose", "1630"}, {"Jennifer", "5"}, {"Chloe", "1909"}, {"Zhang", "1"}, {"Zhang", "10"},
                {"Zhang", "109"}, {"Zhang", "110"}, {"Amos", "1"}, {"Amos", "2"}, {"Amos", "400"}, {"Amos", "500"},
                {"Amos", "503"}, {"Amos", "504"}, {"Amos", "601"}, {"Amos", "602"}, {"Paul", "1416"},};

        badgeTimes(badgeTimes);

        isSubsequence("abc","ahbgdc");

        longestPalindrome("abccccdd");

        removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});

        removeElement(new int[] {0,1,2,2,3,0,4,2},2);

        getConcatenation(new int[]{1,2,3});

        calPoints(new String[]{"5","-2","4","C","D","9","+","+"});

        countStudents(new int[]{0,0,0,1,1,1,1,0,0,0}, new int[]{1,0,1,0,0,1,1,0,0,0});

        minEatingSpeed(new int[]{3,6,7,11}, 8);

        minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1});

        findAnagrams("cbaebabacd","abc");

        canFinish(3,new int[][] {{1,0}, {1,2}, {0,1}});

       uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}});
        //uniquePathsWithObstacles(new int[][]{{0,0}});

        dailyTemperatures(new int[] {73,74,75,71,69,72,76,73});
    }



}