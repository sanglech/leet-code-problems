package ArraysWithHashing.Easy;

/*
    520. Detect Capital
 */
public class DetectCapitol {
    public boolean detectCapitalUse(String word) {
        if (word.length()==0) return false;
        int countCap = 0;
        String capWord = word.toUpperCase();

        for (int i =0; i< word.length();i++){
            if(word.charAt(i)==capWord.charAt(i)){
                countCap++;
            }
        }
        if(countCap==0){
            return true;
        }
        if(countCap==1 && capWord.charAt(0)==word.charAt(0)){
            return true;
        }
        return countCap == word.length();
    }
}
