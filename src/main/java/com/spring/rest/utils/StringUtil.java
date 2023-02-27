package com.spring.rest.utils;

import java.util.HashMap;
import java.util.Map;

public class StringUtil {

    public static Map<String, String> convertStringToMap(String str){
        Map<String, String> hashMap = new HashMap<>();
        String[] parts = str.split("\\r?\\n");
        for (String part : parts) {
            String[] stuData = part.split(":");
            String stuRollNo = stuData[0].trim();
            String stuName = stuData[1].trim();
            hashMap.put(stuRollNo, stuName);
        }
        return hashMap;
    }
}
