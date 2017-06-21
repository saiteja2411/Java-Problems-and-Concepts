/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoreJavaConcepts;

/**
 *
 * @author Saiteja
 */
class Person {
    String fname;
    int age;

    public Person(){
        
    }
    public Person(String fname, int age) {
        this.fname = fname;
        this.age = age;
    }
    
    public String toString(){
        return this.fname + "'s age is "+this.age;
    }
}
