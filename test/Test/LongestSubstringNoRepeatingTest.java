/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import GeneralProblemSolving.LongestSubstringNoRepeating;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Saiteja
 */
public class LongestSubstringNoRepeatingTest {
    @Before
    public void befortest(){
        System.out.println("Test started");
    }
    @After
    public void aftertest(){
        System.out.println("Test Ended");
    }
    
    @Test
    public  void longestSubstringNonRepeatingTest() {
        System.out.println("assert false");
        //assertTrue("The value is false", LongestSubstringNoRepeating.hasNonRepeating("ssddffgghh"));
        assertFalse("The value is true", LongestSubstringNoRepeating.hasNonRepeating("ssddff"));
    }
    @Test
    public  void longestSubstringNonRepeatingTest1() {
        //assertTrue("The value is false", LongestSubstringNoRepeating.hasNonRepeating("ssddffgghh"));
        System.out.println("assert true");
        assertTrue("The value is true", LongestSubstringNoRepeating.hasNonRepeating("adfff"));
    }
}
