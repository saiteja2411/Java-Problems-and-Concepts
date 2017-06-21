package Test;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import GeneralProblemSolving.UniqueStringOrNot;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Saiteja
 */

public class UniqueStringOrNotTest {
    
    static UniqueStringOrNot unique;
    
    @BeforeClass
    public static void before(){
         unique= new UniqueStringOrNot();
    }
    
    //writing test method for every individual check
    @Test
    public void testUniqueString() {
        String expected="Not Unique";
        String actual=unique.uniqueOrNot("asfd");
        Assert.assertEquals(expected, actual);
    }
    //writing test cases for group of tests.
    //even if one assert fails the whole test case fails
    @Test
    public void testUniqueString2() {
        Assert.assertEquals("Unique", unique.uniqueOrNot("asdf"));
        Assert.assertNotEquals("Not Unique", unique.uniqueOrNot("asdf"));
        Assert.assertFalse(1==3);
    }
    @Test
    public void generalTests(){
        Assert.assertFalse(1==3);
        Assert.assertTrue("This is assert true failed",1>0); //messege is shown only if assert fails
        Assert.assertNull("This is not null",unique);
        
    }
}
