package ArraysWithHashing.Easy;

/*
    14. Longest Common Prefix
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==1) return strs[0];
        String base="";
        int max = Integer.MAX_VALUE;

        for(String s: strs){
            if(s.length()<max){
                max = s.length();
                base =s;
            }
        }

        String res = "";
        boolean end = false;

        for(int i=0;i< base.length();i++){
            for(int j=1; j< strs.length;j++){
                if(i<strs[j].length() && strs[j].charAt(i)!=base.charAt(i)) {
                    end = true;
                    break;
                }
            }
            if(end) break;
            else res = base.substring(0,i+1);
        }
        return res;
    }
}
