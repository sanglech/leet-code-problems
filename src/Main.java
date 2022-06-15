import ArraysPractice.ArraysEasy;
import ArraysPractice.ArraysMedium;
import BinarySearch.MyBinarySearch;
import DynamicProgramming.LongestSequenceTwoArrays;
import SlidingWindow.SlidingWindow;

import java.util.Arrays;

import static ArraysPractice.ArraysMedium.longestConsecutive;
import static SlidingWindow.SlidingWindow.checkInclusion;
import static SlidingWindow.SlidingWindow.maxArea;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Contains Duplicates: "+ ArraysEasy.containsDuplicate(new int[]{1, 2, 3, 4, 5, 1}));
        System.out.println("Is Anagram: "+ ArraysEasy.isAnagram("car","rat"));
        System.out.println("TwoSum: "+ Arrays.toString(ArraysEasy.twoSum(new int[]{2, 7, 11, 15}, 9)));

        int i =  MyBinarySearch.myBinarySearch(new int[]{1,0,3,5,9,12},2);
        int j = SlidingWindow.lengthOfLongestSubstring("dvdf");

        System.out.println("Group anagrams: "+ ArraysMedium.groupAnagrams(new String []{"eat","tea","tan","ate","nat","bat"}));
        System.out.println("two sum with 0(1) space: "+ Arrays.toString(SlidingWindow.twoSum(new int[]{1,2,3,4,4,9,56,90}, 8)));
        System.out.println("string replacement: "+ SlidingWindow.characterReplacement("ABAB",2));
        System.out.println("topKfrequent: "+Arrays.toString(ArraysMedium.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));


        int [] res = ArraysMedium.productExceptSelf(new int[]{1,2,3,4});

        SlidingWindow.threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.print("Finding Maximum longest subarray in 2 arrays: "+LongestSequenceTwoArrays.FindMaxLength(new int[]{1, 2, 8, 2, 1}, new int[]{8, 2, 1, 4, 7 }));


        String[] user1 = {"grey", "pink", "green", "red","black","silver"};
        String[] user2 = {"grey", "rose red", "white", "pink", "green", "red","black","silver"};
        System.out.println("Longest contiguous in two arrays is "+ LongestSequenceTwoArrays.longestCommonSubarray(user1,user2));

        checkInclusion("adc","dcda");

        maxArea(new int[]{1,2,1});

        longestConsecutive(new int[]{100,4,200,1,3,2});
    }



}
