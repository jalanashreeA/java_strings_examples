package com.strings.jalana;

public class PermutationsOfString {

    static void printAllPermutes(String s1, String s2){
        if(s1.length()==0){
            System.out.println(s2);
            return;
        }
        //choose every character one by one
        for(int i=0; i<s1.length(); i++){
            char ch=s1.charAt(i);

            String s3=s1.substring(0,i) + s1.substring(i+1);
            printAllPermutes(s3,s2+ch);
        }
    }
    public static void main(String[] args) {
        String s="abc";
        printAllPermutes(s," ");
    }
}
