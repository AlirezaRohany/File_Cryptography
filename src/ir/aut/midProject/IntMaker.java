package ir.aut.midProject;

/**
 * It's a class uses for turning characters to integers by a specific order
 * It gets a specific string that contains maximum 64 contractual types of character
 * It returns a contractual number for each char
 * For 0 returns "A", for 2 returns "B", etc...
 * For 26 returns "a", for 27 returns "b", etc...
 * For 52 returns "0", for 53 returns "1", etc...
 * For 62 returns "+"
 * For 63 returns "/"
 */
class IntMaker {
    /**
     * This method does the act of turning characters to integers
     * It gets a specific string that contains maximum 64 contractual types of character
     *
     * @param plainText A string that will be turned to integer array
     * @return Returns an integer array that all elements of that array is from 0 to 63
     */
    int[] charsToInt(String plainText) {
        int[] charsNumberFrom0to63 = new int[plainText.length()];
        int k = 0;
        for (int i = 0; i < plainText.length(); i++) {
            for (int j = 65; j < 91; j++) {
                if ((int) plainText.charAt(i) == j) {
                    charsNumberFrom0to63[k] = (int) plainText.charAt(i) - 65;
                    k++;
                    break;
                }
            }
            for (int j = 97; j < 123; j++) {
                if ((int) plainText.charAt(i) == j) {
                    charsNumberFrom0to63[k] = (int) plainText.charAt(i) - 71;
                    k++;
                    break;
                }
            }
            for (int j = 48; j < 58; j++) {
                if ((int) plainText.charAt(i) == j) {
                    charsNumberFrom0to63[k] = (int) plainText.charAt(i) + 4;
                    k++;
                    break;
                }
            }
            if ((int) plainText.charAt(i) == 43) {
                charsNumberFrom0to63[k] = 62;
                k++;
            }
            if ((int) plainText.charAt(i) == 47) {
                charsNumberFrom0to63[k] = 63;
                k++;
            }
        }
        return charsNumberFrom0to63;
    }
}