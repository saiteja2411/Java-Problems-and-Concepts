/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneralProblemSolving;
/**
 *
 * @author Saiteja
 */
public class StringCompress {
    public static void main(String[] args) {
        System.out.println(stringCompress("aabbccc"));
    }

    private static String stringCompress(String str) {
        
        if(str.length()<=2)
            return str;
        if(str.isEmpty())
            return "";
        
        int count=1;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i)==str.charAt(i+1)){
                count++;
            }else{
                sb.append(str.charAt(i)).append(count);
                count=1;
            }
        }
        sb.append(str.charAt(str.length()-1)).append(count);
        if(str.length()<=sb.length())
            return str;
        else
            return sb.toString();
    }
}
