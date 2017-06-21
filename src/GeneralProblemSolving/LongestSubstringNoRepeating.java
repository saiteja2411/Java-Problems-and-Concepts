/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneralProblemSolving;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Saiteja
 */
public class LongestSubstringNoRepeating {

    public static void main(String[] args) {
        String str = "pwwkew";
        longestSubstringWithoutRepeatingChars(str);

    }

    private static void longestSubstringWithoutRepeatingChars(String str) {
        Set<Character> set = new HashSet();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        if (hasNonRepeating(str)) {
            System.out.println(set.size()-1);
        }
        else
            System.out.println(set.size());
            
    }

    public static boolean hasNonRepeating(String str) {
        LinkedHashMap<Character, Boolean> lhm = new LinkedHashMap<>();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(lhm.containsKey(c))
                lhm.put(c, Boolean.FALSE); 
            else
                lhm.put(c, Boolean.TRUE);                               
        }
        System.out.println(lhm);
        Set<Character> set= lhm.keySet();
        return set.stream()
                .anyMatch((c) -> (Objects.equals(lhm.get(c), Boolean.TRUE)));
    }
   
}