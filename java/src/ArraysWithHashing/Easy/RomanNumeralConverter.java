package ArraysWithHashing.Easy;

import java.util.Map;

/*
    13. Roman to Integer
 */
public class RomanNumeralConverter {

    public static int romanToInt(String s) {
        Map<Character,Integer> romanMap = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L',50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        if (s.length()==0) return 0;
        int res =0;

        res +=romanMap.get(s.charAt(0));

        for( int i =1; i< s.length();i++){
            char prev = s.charAt(i-1);
            if(s.charAt(i)=='V' && prev == 'I'){
                res-=1;
                res+=4;
            }
            else if(s.charAt(i)=='X' && prev =='I'){
                res-=1;
                res+=9;
            }
            else if(s.charAt(i)=='L' && prev=='X'){
                res-=10;
                res+=40;
            }
            else if(s.charAt(i)=='C' && prev=='X'){
                res-=10;
                res+=90;
            }
            else if(s.charAt(i)=='D' && prev=='C'){
                res-=100;
                res+=400;
            }
            else if(s.charAt(i)=='M' && prev=='C'){
                res-=100;
                res+=900;
            }else{
                res+=romanMap.get(s.charAt(i));
            }
        }

        return res;
    }
}
