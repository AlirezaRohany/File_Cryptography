package ir.aut.midProject;

/**
 * It's a class that extends BaseCryptography
 * It has to define two abstract methods of mother class
 * It can do the act of encryption an decryption by getting a key of string and shifts the alphabetical order of each elements of that text by the arbitrary number of each elements of that string
 */
class ComplexShiftCryptography extends BaseCryptography {
    /**
     * A string key for encryption and decryption
     * For shifting alphabetical content of the elements
     */
    private String key;

    /**
     * A simple constructor for the class
     *
     * @param key key is the string key for shifting the characters of a text
     */
    ComplexShiftCryptography(String key) {
        this.key = key;
    }

    /**
     * This method shifts the alphabetical order of each elements of a text by the arbitrary number of each elements of the key
     * The arbitrary numbers are from 0 to 63, "A" equals 1, "B" equals 2, and etc...
     * For example for the key of ABC, the first char of text shifts one alphabetical order left, the second shifts two, the third shifts three, the forth shifts one, etc...
     * For another example the text "CELL" by the key of ABC changes to "BCIK"
     *
     * @param plainText plainText is a text that will be encrypted
     * @return Returns the encrypted text
     */
    String encrypt(String plainText) {
        IntMaker intMaker = new IntMaker();
        int[] charsNumberFrom0to63 = intMaker.charsToInt(plainText);
        int[] key = intMaker.charsToInt(this.key);
        int k = 0;
        for (int i = 0; i < charsNumberFrom0to63.length; i++) {
            charsNumberFrom0to63[i] -= (key[k] + 1);
            k++;
            if (k == key.length) k = 0;
            if (charsNumberFrom0to63[i] > 63) charsNumberFrom0to63[i] -= 64;
            if (charsNumberFrom0to63[i] < 0) charsNumberFrom0to63[i] += 64;
        }
        CharMaker charMaker = new CharMaker();
        return charMaker.makeChar(charsNumberFrom0to63);
    }

    /**
     * This method shifts the alphabetical order of each elements of a text by the arbitrary number of each elements of the key in the opposite order
     * The arbitrary numbers are from 0 to 63, "A" equals 1, "B" equals 2, and etc...
     * For example for the key of ABC, the first char of text shifts one alphabetical order right, the second shifts two, the third shifts three, the forth shifts one, etc...
     * For another example the text "CELL" by the key of ABC changes to "DGOM"
     *
     * @param cipherText cipherText is a text that will be decrypted
     * @return Returns the decrypted text
     */
    String decrypt(String cipherText) {
        IntMaker intMaker = new IntMaker();
        int[] charsNumberFrom0to63 = intMaker.charsToInt(cipherText);
        int[] key = intMaker.charsToInt(this.key);
        int k = 0;
        for (int i = 0; i < charsNumberFrom0to63.length; i++) {
            charsNumberFrom0to63[i] += (key[k] + 1);
            k++;
            if (k == key.length) k = 0;
            if (charsNumberFrom0to63[i] > 63) charsNumberFrom0to63[i] -= 64;
            if (charsNumberFrom0to63[i] < 0) charsNumberFrom0to63[i] += 64;
        }
        CharMaker charMaker = new CharMaker();
        return charMaker.makeChar(charsNumberFrom0to63);
    }
}