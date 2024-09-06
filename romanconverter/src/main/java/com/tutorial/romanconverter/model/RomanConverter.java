package com.tutorial.romanconverter.model;

import java.util.HashMap;

public class RomanConverter {

    private String roman;
    private static HashMap<Character, Integer> map = new HashMap<>();

    public RomanConverter(String roman) {
        this.roman = roman;
        initializeMap();
    }

    public String getRoman() {
        return roman;
    }

    private void initializeMap() {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public boolean isValidRoman() {
        return roman.matches("^[IVXLCDM]+$");
    }

    public int convertRomanToDecimal() {
        if (!isValidRoman()) {
            throw new IllegalArgumentException("Invalid Roman numeral");
        }

        int res = 0;
        int prev = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            int curr = map.get(roman.charAt(i));

            if (curr >= prev) {
                res += curr;
            } else {
                res -= curr;
            }

            prev = curr;
        }

        return res;
    }
}