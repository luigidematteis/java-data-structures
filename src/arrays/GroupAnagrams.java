package arrays;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.AbstractList;
import java.util.Map;
import java.util.Comparator;

public class GroupAnagrams {

    /*
        Given an array of strings strs, group the anagrams together. You can return the answer in any order.

        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically
        using all the original letters exactly once.

        Example:
        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    */
    /*

    */
    public List<List<String>> groupAnagrams(String[] strs) {

        // ["eat","tea","tan","ate","nat","bat"]
        // eat -> e,a,t -> aet -> Map<aet, <eat>
        // tea -> t,e,a -> aet -> Map<aet, <eat,tea>>
        // tan -> t,a,n -> ant -> Map<ant, <tan>>
        // ate -> a,t,e -> aet -> Map<aet, <eat,tea,ate>
        // nat -> n,a,t -> ant -> Map<ant, <tan, nat>
        // bat -> b,a,t -> abt -> Map<abt, <bat>

        Map<String, List<String>> map = new HashMap<>();

        // Iterate through each element of the input array
        for (int i = 0; i < strs.length; i++) {
            // Transform the string into an array of chars
            char[] currentChars = strs[i].toCharArray();
            // Sort the chars array and transform it back to a string
            Arrays.sort(currentChars);
            System.out.println("Original string:" + strs[i]);
            System.out.println("Sorted string:" + Arrays.toString(currentChars));
            String sortedChars = Arrays.toString(currentChars);
            // We try to put it into a Map<String, List<String> ->
                // If the key is present, we take the value of that key, and then add to the List
                    // the second value
                // if it is not present, we just add the key and the value

            if (map.containsKey(sortedChars)) {
                List<String> values = new ArrayList<>(map.get(sortedChars));
                values.add(strs[i]);
                map.put(sortedChars, values);
            } else {
                map.put(sortedChars, List.of(strs[i]));
            }
        }

        // We transform again the map into a list of List<String>
        // We return this List
        List<List<String>> result = new ArrayList<>(map.values());
        result.sort(Comparator.comparingInt(List::size));
        System.out.println(result);
        return result;
    }

    public List<List<String>> groupAnagramsImproved(String[] strs) {
        return new AbstractList<List<String>>(){
            List<List<String>> result;
            Map<String, List<String>> map = new HashMap<>();

            public List<String> get(int i){
                if(result == null) init();
                return result.get(i);
            }

            public int size(){
                if(result == null) init();
                return result.size();
            }

            public void init(){
                for(int i = 0; i<strs.length; i++){
                    String sorted = getSortedString(strs[i]);
                    map.putIfAbsent(sorted, new ArrayList<>());
                    map.get(sorted).add(strs[i]);
                }
                result = new ArrayList<>(map.values());
            }
        };
    }

    public String getSortedString(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
