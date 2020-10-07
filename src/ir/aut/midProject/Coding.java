package ir.aut.midProject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

/**
 * It's a class uses for encoding and decoding
 * Encoding does the act of turning bytes to String with some specific rules
 * Decoding does the act of turning string to bytes with some specific rules
 */
class Coding {
    /**
     * This method gets an array of bytes and returns a string
     * Writes all the bytes as a stream
     * Reads the bytes 6 bits by 6 bits and make each 6 bits to a char from 64 specific chars
     * Makes all chars a string and returns that string
     *
     * @param bytes The bytes that will be encoded
     * @return Returns a string made from that bytes
     * @throws UnsupportedEncodingException When we use an unsupported encoding it throws an exception
     */
    String encode(byte[] bytes) throws UnsupportedEncodingException {
        String str = new String(bytes, "UTF-8");
        char[] chars = str.toCharArray();
        String[] charsInRadixTwo = new String[chars.length];
        StringBuilder binaryStream = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            charsInRadixTwo[i] = Integer.toString(chars[i], 2);
            int neededZeroes = 8 - charsInRadixTwo[i].length();
            for (int j = 0; j < neededZeroes; j++) binaryStream.append(0);
            binaryStream.append(charsInRadixTwo[i]);
        }
        if (chars.length % 3 == 2) binaryStream.insert(binaryStream.length() - 4, "00");
        if (chars.length % 3 == 1) binaryStream.insert(binaryStream.length() - 2, "0000");
        int[] intOfChars = new int[binaryStream.length() / 6];
        int i;
        for (int j = 0; j < binaryStream.length() / 6; j++) {
            i = j * 6;
            if (Objects.equals(binaryStream.charAt(i), '1')) intOfChars[j] += 32;
            if (Objects.equals(binaryStream.charAt(i + 1), '1')) intOfChars[j] += 16;
            if (Objects.equals(binaryStream.charAt(i + 2), '1')) intOfChars[j] += 8;
            if (Objects.equals(binaryStream.charAt(i + 3), '1')) intOfChars[j] += 4;
            if (Objects.equals(binaryStream.charAt(i + 4), '1')) intOfChars[j] += 2;
            if (Objects.equals(binaryStream.charAt(i + 5), '1')) intOfChars[j] += 1;
        }
        CharMaker charMaker = new CharMaker();
        return charMaker.makeChar(intOfChars);
    }

    /**
     * This method gets a string and returns an array of bytes
     * Writes all the chars of string as a stream
     * Reads the bytes of chars 6 bits by 6 bits and make each 8 bits to a char by ascii code
     * Makes all chars to a byte array and returns that string
     *
     * @param str The string that will be decoded
     * @return Returns an array byte made from that string
     */
    byte[] decode(String str) {
        char[] chars = str.toCharArray();
        StringBuilder binaryStream = new StringBuilder();
        for (char aChar : chars) {
            for (int j = 65; j < 91; j++) {
                if ((int) aChar == j) {
                    String charInRadixTwo = Integer.toString(j - 65, 2);
                    int neededZeroes = 6 - charInRadixTwo.length();
                    for (int k = 0; k < neededZeroes; k++) binaryStream.append(0);
                    binaryStream.append(charInRadixTwo);
                    break;
                }
            }
            for (int j = 97; j < 123; j++) {
                if ((int) aChar == j) {
                    String charInRadixTwo = Integer.toString(j - 71, 2);
                    int neededZeroes = 6 - charInRadixTwo.length();
                    for (int k = 0; k < neededZeroes; k++) binaryStream.append(0);
                    binaryStream.append(charInRadixTwo);
                    break;
                }
            }
            for (int j = 48; j < 58; j++) {
                if ((int) aChar == j) {
                    String charInRadixTwo = Integer.toString(j + 4, 2);
                    int neededZeroes = 6 - charInRadixTwo.length();
                    for (int k = 0; k < neededZeroes; k++) binaryStream.append(0);
                    binaryStream.append(charInRadixTwo);
                    break;
                }
            }
            if ((int) aChar == 43) {
                String charInRadixTwo = Integer.toString(62, 2);
                int neededZeroes = 6 - charInRadixTwo.length();
                for (int k = 0; k < neededZeroes; k++) binaryStream.append(0);
                binaryStream.append(charInRadixTwo);
            }
            if ((int) aChar == 47) {
                String charInRadixTwo = Integer.toString(63, 2);
                int neededZeroes = 6 - charInRadixTwo.length();
                for (int k = 0; k < neededZeroes; k++) binaryStream.append(0);
                binaryStream.append(charInRadixTwo);
            }
        }
        if (chars.length % 4 == 3) for (int i = 0; i < 2; i++) binaryStream.deleteCharAt(binaryStream.length() - 5);
        if (chars.length % 4 == 2) for (int i = 0; i < 4; i++) binaryStream.deleteCharAt(binaryStream.length() - 3);
        int[] intOfChars = new int[binaryStream.length() / 8];
        StringBuilder charStream = new StringBuilder();
        for (int i = 0; i < binaryStream.length() / 8; i++) {
            int j = i * 8;
            if (Objects.equals(binaryStream.charAt(j), '1')) intOfChars[i] += 128;
            if (Objects.equals(binaryStream.charAt(j + 1), '1')) intOfChars[i] += 64;
            if (Objects.equals(binaryStream.charAt(j + 2), '1')) intOfChars[i] += 32;
            if (Objects.equals(binaryStream.charAt(j + 3), '1')) intOfChars[i] += 16;
            if (Objects.equals(binaryStream.charAt(j + 4), '1')) intOfChars[i] += 8;
            if (Objects.equals(binaryStream.charAt(j + 5), '1')) intOfChars[i] += 4;
            if (Objects.equals(binaryStream.charAt(j + 6), '1')) intOfChars[i] += 2;
            if (Objects.equals(binaryStream.charAt(j + 7), '1')) intOfChars[i] += 1;
            charStream.append((char) intOfChars[i]);
        }
        return charStream.toString().getBytes();
    }
}