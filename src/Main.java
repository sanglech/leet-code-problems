import ArraysPractice.ArraysEasy;
import BinarySearch.MyBinarySearch;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Contains Duplicates: "+ ArraysEasy.containsDuplicate(new int[]{1, 2, 3, 4, 5, 1}));
        System.out.println("Is Anagram: "+ ArraysEasy.isAnagram("car","rat"));
        System.out.println("TwoSum: "+ Arrays.toString(ArraysEasy.twoSum(new int[]{2, 7, 11, 15}, 9)));
       int i =  MyBinarySearch.myBinarySearch(new int[]{1,0,3,5,9,12},2);
    }
    
}
