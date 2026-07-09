package com.strings.jalana;

public class TotalNumberOfCharacters {
    public static void main(String[] args) {
        String s= "Scaler by InterviewBit";
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' ')
                count++;
        }
        System.out.println("The total number of characters in a given string is:"+count);
    }
}
