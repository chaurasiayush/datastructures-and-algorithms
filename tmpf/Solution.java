import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static void countWords(int ind, String[] words, Map<String, Integer> wmap) {

        if(ind >= words.length) return;
        int count = wmap.getOrDefault(words[ind], 0);
        wmap.put(words[ind], count+1);

        countWords(ind+1, words, wmap);
    }
    public static void main(String[] args) {
     
        String para = "my name iiss name is ayush";

        Map<String, Integer> wordCounts = new HashMap<>();

        String[] words = para.split(" ");
        countWords(0, words, wordCounts);

        System.out.println(wordCounts);
    }
    
}