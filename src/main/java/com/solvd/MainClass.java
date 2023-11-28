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
        List<String> linesFromFile;
        List<String> separateWords = new ArrayList<>();
        Map<String,Integer> wordQuantities = new HashMap<>();

        String titleOfTextFile = "about_Titanium.txt";
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

        String descriptionOfResult = "In \""+ titleOfTextFile +"\" there were ";
        descriptionOfResult += Integer.toString(amountOfUnique) +" unique words.";
        File fileWithResult = new File("results.txt");
        try {
            FileUtils.touch(fileWithResult);
            FileUtils.write(fileWithResult, descriptionOfResult, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("IO exception: "+ e.getMessage());
        }
    }
}
