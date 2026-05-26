package com.bajaj.apitest.service.impl;

import com.bajaj.apitest.dto.BfhlRequest;
import com.bajaj.apitest.dto.BfhlResponse;
import com.bajaj.apitest.service.BfhlService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    private static final String USER_ID = "meet_kelwa_23071997";
    private static final String EMAIL = "meetkelwa230797@acropolis.in";
    private static final String ROLL_NUMBER = "0827CI231081";

    @Override
    public BfhlResponse processRequest(BfhlRequest request) {
        if (request == null || request.getData() == null) {
            return new BfhlResponse(
                    false,
                    USER_ID,
                    EMAIL,
                    ROLL_NUMBER,
                    Collections.emptyList(),
                    Collections.emptyList(),
                    Collections.emptyList(),
                    Collections.emptyList(),
                    "0",
                    ""
            );
        }

        List<String> evenNumbers = new ArrayList<>();
        List<String> oddNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();
        
        BigInteger sum = BigInteger.ZERO;
        List<Character> allAlphabetChars = new ArrayList<>();

        for (String item : request.getData()) {
            if (item == null) {
                continue;
            }

            // 1. Check if the item is a valid integer number (composed of digits, optionally signed)
            if (item.matches("^[+-]?\\d+$")) {
                try {
                    BigInteger num = new BigInteger(item);
                    sum = sum.add(num);
                    
                    // Check if even or odd (num % 2 == 0)
                    if (num.remainder(BigInteger.TWO).equals(BigInteger.ZERO)) {
                        evenNumbers.add(item);
                    } else {
                        oddNumbers.add(item);
                    }
                } catch (NumberFormatException e) {
                    // Fallback to special character if parsing fails inexplicably
                    specialCharacters.add(item);
                }
            } 
            // 2. Check if the item consists purely of alphabetic characters
            else if (item.matches("^[a-zA-Z]+$")) {
                alphabets.add(item.toUpperCase());
                
                // Collect individual characters for the alternating caps reverse string
                for (char ch : item.toCharArray()) {
                    if (Character.isLetter(ch)) {
                        allAlphabetChars.add(ch);
                    }
                }
            } 
            // 3. Otherwise, classify as special characters
            else {
                specialCharacters.add(item);
                
                // Still collect any letters that might be inside mixed special character strings
                for (char ch : item.toCharArray()) {
                    if (Character.isLetter(ch)) {
                        allAlphabetChars.add(ch);
                    }
                }
            }
        }

        // Calculate alternating caps reversed string of alphabetic characters
        String concatString = buildAlternatingCapsReverseString(allAlphabetChars);

        return new BfhlResponse(
                true,
                USER_ID,
                EMAIL,
                ROLL_NUMBER,
                evenNumbers,
                oddNumbers,
                alphabets,
                specialCharacters,
                sum.toString(),
                concatString
        );
    }

    private String buildAlternatingCapsReverseString(List<Character> chars) {
        if (chars == null || chars.isEmpty()) {
            return "";
        }

        // Reverse the collected alphabet character list
        List<Character> reversedChars = new ArrayList<>(chars);
        Collections.reverse(reversedChars);

        // Apply alternating caps: index 0 (even indices) is uppercase, index 1 (odd indices) is lowercase
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < reversedChars.size(); i++) {
            char ch = reversedChars.get(i);
            if (i % 2 == 0) {
                sb.append(Character.toUpperCase(ch));
            } else {
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb.toString();
    }
}
