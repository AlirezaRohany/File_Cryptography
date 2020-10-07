package ir.aut.midProject;

import java.io.*;

/**
 * It's a class for reading files
 * Has a method for this and returns all bytes of that file in a byte array
 */
class InputFileReader {
    /**
     * This method gets a file and reads all bytes of it
     * Reads byte by byte and make all bytes a byte array and returns that array
     *
     * @param file The file that will be read
     * @return Returns an array of bytes that contains all byte of the file
     * @throws FileNotFoundException Throws exception for fileInputStream when needed
     */
    byte[] readFile(File file) throws IOException {
        FileInputStream reader = new FileInputStream(file);
        int bytesOfContent;
        byte[] bytes = new byte[(int) file.length()];
        int k = 0;
        while ((bytesOfContent = reader.read()) != -1) bytes[k++] = (byte) bytesOfContent;
        reader.close();
        return bytes;
    }
}