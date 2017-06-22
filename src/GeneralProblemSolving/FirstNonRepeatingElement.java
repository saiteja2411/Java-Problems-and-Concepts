/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneralProblemSolving;

import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Set;
import static java.util.stream.Collectors.toList;


/**
 *
 * @author Saiteja
 */
public class FirstNonRepeatingElement {
    public static void main(String[] args)  {
        String str = "assa2aii*eqjeejajt";
        FirstNonRepeatingElement d= new FirstNonRepeatingElement();
        System.out.println(d.findFirstNonRepeatingElement(str));
    }
    
    //Total Time complexity would be :
    //     Best case O(n) , Worst case = O(n)
    public Character findFirstNonRepeatingElement(String str){
        //Base conditions
        if(str==null)
            return null;
        if(str.length()==1)
            return str.charAt(0);
        //Executes only for str with length > 2
        //Linked hasmap is used to preserve the order of insertion.
        LinkedHashMap<Character, Boolean> lhm = new LinkedHashMap<>();
        //interating through the string 
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(lhm.containsKey(c))
                lhm.put(c, Boolean.FALSE); //if character is found again, set the calue of the key to false
            else
                lhm.put(c, Boolean.TRUE); //else set it to true. hence, its non repeating charater                                 
        }
        //set to collect all the keys from the map.
        Set<Character> set= lhm.keySet();
        
        //Using Java 8 streams for fast parallel processing for large chuck of data.
        return set.parallelStream()
                .filter((c) -> (Objects.equals(lhm.get(c), Boolean.TRUE)))//filtering the map, selecting only the keys with values = TRUE.
                .collect(toList()).get(0);//getting the first Non Repeating value.
    }
    
}

