package com.solvd;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ArrayList; //?
import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class MainClass {
    public static void main(String[] args) {
        List<String> linesFromFile = new ArrayList<>();
        List<String> separateWords = new ArrayList<>();
        Map<String,Integer> wordQuantities = new HashMap<>();

        try {
            linesFromFile = FileUtils.readLines(FileUtils.getFile("about_Titanium.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] tempArray;
        for (String s1 : linesFromFile) {
            s1 = StringUtils.lowerCase(s1);
            tempArray = StringUtils.split(s1," ");
            for(String s2 : tempArray) {
                separateWords.add(s2);
            }
        }

        // www.geeksforgeeks.org/java-program-to-print-all-unique-words-of-a-string/
        for(String word : separateWords) {
            if(wordQuantities.containsKey(word)) {
                wordQuantities.put(word, wordQuantities.get(word)+1);
            } else {
                wordQuantities.put(word, 1);
            }
        }

        int amountOfUnique = 0;
        for(Map.Entry<String,Integer> aboutWord : wordQuantities.entrySet()) {
            if(aboutWord.getValue() == 1) {
                amountOfUnique += 1;
            }
        }

        //this information should be written to file
        System.out.println("Number of unique words in the file is "+ Integer.toString(amountOfUnique));

    }
}
