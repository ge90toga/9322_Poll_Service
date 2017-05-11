package com.badbanana.poll.api.tool;


import java.util.HashSet;
import java.util.Random;
import java.util.UUID;

/**
 * Created by langley on 11/5/17.
 */
public class IdentityGenerator {

    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };


    public static String generateShortUUID() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        System.out.println(shortBuffer.toString());
        return shortBuffer.toString();

    }

    public static void main(String args[]) {
        byte[] bytes = new byte[8];
        Random random = new Random();
        HashSet<String> hash = new HashSet<>();
        for (int j = 0; j < 1; j++) {
            hash.clear();
            for (int i = 0; i < 10; i++) {

                String s = generateShortUUID();
                if (hash.contains(s)) {
                    System.out.println("found repeat:" + i);
                    break;
                }
                hash.add(s);
            }
        }
    }
}
