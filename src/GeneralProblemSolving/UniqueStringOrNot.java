/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneralProblemSolving;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Saiteja
 */
public class UniqueStringOrNot {

    public static void main(String[] args) {
        UniqueStringOrNot t = new UniqueStringOrNot();
        System.out.println(t.uniqueOrNot("qweerety"));
    }

    public String uniqueOrNot(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) 
                return "Not Unique";
            else 
                set.add(str.charAt(i));
        }
        return "Unique";
    }
}
