package TwoPointers;

/*
    125. Valid Palindrome
    Time complexity: O(logn)
    Space complexity: O(1)
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        final StringBuilder sb = new StringBuilder();
        for (Character c : s.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }

        int i =0;
        int j = sb.length()-1;

        while(i<j){
            if(sb.charAt(i) != sb.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
