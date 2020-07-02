package com.brayden.uplus.datastructure.leetcode;

import java.util.TreeSet;

/**
 * @Description：
 * @Date: Created in 2020/7/1 21:13
 * @Author Brayden
 * @Version 1.0
 */
public class MosiPassword {

    public static void main(String[] args) {
        MosiPassword mosiPassword = new MosiPassword();
        String[] params = {"gin", "zen", "gig", "msg"};
        int i = mosiPassword.uniqueMorseRepresentations(params);
        System.out.println(i);
    }

    public int uniqueMorseRepresentations(String[] words) {
        TreeSet <String> result = new TreeSet <>();
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        for (int i = 0; i < words.length; i++) {
            StringBuffer sb = new StringBuffer();
            for (int k = 0; k < words[i].length(); k++) {
                sb.append(codes[words[i].charAt(k) - 'a']);
            }
            result.add(sb.toString());
        }
        return result.size();

    }
}
