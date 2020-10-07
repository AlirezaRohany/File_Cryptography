package ir.aut.midProject;

/**
 * It's a class that extends BaseCryptography
 * It has to define two abstract methods of mother class
 * It can do the act of encryption an decryption by getting a key of integer and shifts the alphabetical order of each elements of that string by the size of that integer
 * Shifting to left or right depends on choosing the encrypt or decrypt
 */
class SimpleShiftCryptography extends BaseCryptography {
    /**
     * A integer key for encryption and decryption
     * For shifting alphabetical content of the elements
     */
    private int key;

    /**
     * A simple constructor for the class
     *
     * @param key key is the integer key for shifting the characters of a text
     */
    SimpleShiftCryptography(int key) {
        this.key = key;
    }

    /**
     * This method shifts the alphabetical order of all elements of a text to left by the size of the key
     * For example for the key of 2, all C characters will turn to A
     *
     * @param plainText plainText is a text that will be encrypted
     * @return Returns the encrypted text
     */
    String encrypt(String plainText) {
        IntMaker intMaker = new IntMaker();
        int[] charsNumberFrom0to63 = intMaker.charsToInt(plainText);
        for (int i = 0; i < charsNumberFrom0to63.length; i++) {
            charsNumberFrom0to63[i] -= key;
            if (charsNumberFrom0to63[i] > 63) charsNumberFrom0to63[i] -= 64;
            if (charsNumberFrom0to63[i] < 0) charsNumberFrom0to63[i] += 64;
        }
        CharMaker charMaker = new CharMaker();
        return charMaker.makeChar(charsNumberFrom0to63);
    }

    /**
     * This method shifts the alphabetical order of all elements of a string to right by the size of the key
     * For a example for the key of 2, all A characters will turn to C
     *
     * @param cipherText cipherText is a text that will be decrypted
     * @return Returns the decrypted text
     */
    String decrypt(String cipherText) {
        IntMaker intMaker = new IntMaker();
        int[] charsNumberFrom0to63 = intMaker.charsToInt(cipherText);
        for (int i = 0; i < charsNumberFrom0to63.length; i++) {
            charsNumberFrom0to63[i] += key;
            if (charsNumberFrom0to63[i] > 63) charsNumberFrom0to63[i] -= 64;
            if (charsNumberFrom0to63[i] < 0) charsNumberFrom0to63[i] += 64;
        }
        CharMaker charMaker = new CharMaker();
        return charMaker.makeChar(charsNumberFrom0to63);
    }
}