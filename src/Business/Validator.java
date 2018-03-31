/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nishad
 */
public final class Validator {
    public static final  boolean StringEmpty(String text){
        Boolean isEmpty=false;
        if(text.trim().length() == 0)
        {
          isEmpty= true;
        }
        return isEmpty;
    }
 public static boolean isEmailValid(String email){
boolean isValid = false;
String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
CharSequence inputStr = email;
//Make the comparison case-insensitive.
Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
Matcher matcher = pattern.matcher(inputStr);
if(matcher.matches()){
isValid = true;
}
return isValid;
}
 
 public static boolean isPhoneNumberValid(String phoneNumber){
boolean isValid = false;
String expression = "^\\(?(\\d{3})\\)?(\\d{3})?(\\d{4})$";
CharSequence inputStr = phoneNumber;
Pattern pattern = Pattern.compile(expression);
Matcher matcher = pattern.matcher(inputStr);
if(matcher.matches()){
isValid = true;
}
return isValid;
}
    public static boolean isSSNValid(String ssn){
boolean isValid = false;
String expression = "^\\d{3}[- ]?\\d{2}[- ]?\\d{4}$";
CharSequence inputStr = ssn;
Pattern pattern = Pattern.compile(expression);
Matcher matcher = pattern.matcher(inputStr);
if(matcher.matches()){
isValid = true;
}
return isValid;
}
    
    public static final String isNumeric(String text){
        String msg="";
        try {
     Integer.parseInt(text.trim());
     //System.out.println("An integer"):
}
catch (NumberFormatException e) {
     //Not an integer
     msg = "Please enter a number";
}
        return msg; 
    }
}
