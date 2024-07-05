package com.zipcodewilmington;

import java.util.*;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {

        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {

        return Arrays.asList(array).contains(value);
        //return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        Collections.reverse(Arrays.asList(array));
        return array;

    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    //String[] array = {"a", "b", "c", "b", "a"} returns true
    public static boolean isPalindromic(String[] array) {
        String[] reversed = array.clone();
        Collections.reverse(Arrays.asList(array));
        return Arrays.equals(array, reversed);
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String arrayer = Arrays.toString(array).toLowerCase();
        char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        boolean results = true;
        for (int i = 0; i < alphabets.length; i++) {
            if (!arrayer.contains(String.valueOf(alphabets[i]))){
                return false;
            }
        }
        return true;

    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int results = 0;
        for(int i=0; i< array.length; i++){
            if(array[i].equals(value)){
                results++;
            }
        }
        return results;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        int resultsLength = ((array.length) - (getNumberOfOccurrences(array, valueToRemove)));
        String[]results = new String[resultsLength];
        int index = 0;
        for(int i =0; i< array.length; i++){
            if(!valueToRemove.equals(array[i])){
                results[index] = array[i];
                index++;
            }
        }
        return results;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList<String>results = new ArrayList<String>();

        for(int i=0; i< array.length; i++){

            if(i+1 <= array.length-1 && !array[i].equals(array[i+1])){
                results.add(array[i]);
            }else if(i+1 == array.length){
                results.add(array[i]);
            }
        }
        String[] solution = results.toArray(new String[0]);
        return solution;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> consecutiveDupe = new ArrayList<>();
        String accum = "";

        for (String eachStr : array) {
            if (accum.isEmpty()) {
                accum = eachStr;
            } else {
                if (accum.charAt(0) == eachStr.charAt(0)) {
                    accum += eachStr;
                } else {
                    consecutiveDupe.add(accum);
                    accum = eachStr;
                }
            }
        }
        consecutiveDupe.add(accum);
        return consecutiveDupe.toArray(String[]::new);
    }


}
