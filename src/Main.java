import ArraysPractice.ArraysEasy;
import ArraysPractice.ArraysMedium;
import BinarySearch.MyBinarySearch;
import SlidingWindow.SlidingWindow;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Contains Duplicates: "+ ArraysEasy.containsDuplicate(new int[]{1, 2, 3, 4, 5, 1}));
        System.out.println("Is Anagram: "+ ArraysEasy.isAnagram("car","rat"));
        System.out.println("TwoSum: "+ Arrays.toString(ArraysEasy.twoSum(new int[]{2, 7, 11, 15}, 9)));
       int i =  MyBinarySearch.myBinarySearch(new int[]{1,0,3,5,9,12},2);

        int j = SlidingWindow.lengthOfLongestSubstring("dvdf");

        System.out.println("group anagrams "+ ArraysMedium.groupAnagrams(new String []{"eat","tea","tan","ate","nat","bat"}));
        System.out.println("two sum with 0(1) space: "+ Arrays.toString(SlidingWindow.twoSum(new int[]{1,2,3,4,4,9,56,90}, 8)));

        System.out.println("string replacement: "+ SlidingWindow.characterReplacement("ABAB",2));

        System.out.println("topKfrequent"+Arrays.toString(ArraysMedium.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));

        int [] res = ArraysMedium.productExceptSelf(new int[]{1,2,3,4});
    }



}
