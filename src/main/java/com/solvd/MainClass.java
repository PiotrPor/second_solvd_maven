package com.solvd;

import org.apache.commons.lang3.StringUtils; //a single class imported ??
import org.apache.commons.io.FileUtils; //a single class imported ??

public class MainClass {
    public static void main(String[] args) {
        String testedString = "Am I empty?";
        if(StringUtils.isEmpty(testedString)) {
            System.out.println("This string is empty");
        } else {
            System.out.println("Non-empty string: "+ testedString);
        }
    }
}
