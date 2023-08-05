package ex;

import java.util.HashMap;
import java.util.Map;

public class Compression {
    public static String betterCompression(String s) {
        char[] chars = s.toCharArray();
        char currChar;
        int value;
        Map<Character, Integer> expr = new HashMap<>();

        System.out.println(chars.length);
        for (int i = 0; i < chars.length; i++) {
            System.out.println(Character.isDigit(chars[i]));
            if(Character.isDigit(chars[i])) {
                continue;
            } else {
                currChar = chars[i];
                System.out.println(currChar);
            }
            String valueToParse = "";
            int j = i + 1;
            while (j < chars.length && Character.isDigit(chars[j])) {
                System.out.println(Character.isDigit(chars[j]));
                valueToParse = valueToParse.concat(String.valueOf(chars[j]));
                j++;
            }
            System.out.println("valueToParse=" + valueToParse);
            value = Integer.parseInt(valueToParse);

            if (expr.containsKey(currChar)) {
                int sum = expr.get(currChar) + value;
                expr.put(currChar, sum);
            } else {
                expr.put(currChar, value);
            }
        }

        StringBuilder result = new StringBuilder();
        for (Character key : expr.keySet()) {
            System.out.println("key=" + key);
            System.out.println("value=" + expr.get(key));
            result.append(key.toString()).append(expr.get(key).toString());
            System.out.println("result=" + result);
        }

        System.out.println(result);
        return result.toString();
    }
}
