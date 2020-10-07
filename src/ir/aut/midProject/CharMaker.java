package ir.aut.midProject;

/**
 * It's a class uses for turning integers to chars by a specific order
 * It gets an integer array that all elements of that array is from 0 to 63
 * It returns a contractual char for each number
 * For "A" returns 0, for "B" returns 1, etc...
 * For "a" returns 26, for "b" returns 27, etc...
 * For "0" returns 52, for "1" returns 53, etc...
 * For "+" returns 62
 * For "/" returns 63
 */
class CharMaker {
    /**
     * This method does the act of turning integers to characters
     * It gets an integer array that all elements of that array is from 0 to 63
     *
     * @param charsNumberFrom0to63 An integer array that will be turned to string
     * @return Returns a string that comes from an integer array
     */
    String makeChar(int[] charsNumberFrom0to63) {
        StringBuilder charStream = new StringBuilder();
        for (int aCharsNumberFrom0to63 : charsNumberFrom0to63) {
            if (aCharsNumberFrom0to63 < 26) charStream.append((char) (aCharsNumberFrom0to63 + 65));
            else if (aCharsNumberFrom0to63 < 52) charStream.append((char) (aCharsNumberFrom0to63 + 71));
            else if (aCharsNumberFrom0to63 < 62) charStream.append((char) (aCharsNumberFrom0to63 - 4));
            else if (aCharsNumberFrom0to63 == 62) charStream.append('+');
            else charStream.append('/');
        }
        return charStream.toString();
    }
}