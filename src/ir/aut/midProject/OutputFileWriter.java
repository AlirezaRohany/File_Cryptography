package ir.aut.midProject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * It's a class for writing to files
 * Has a method for this and gets an array of bytes and writes all bytes to it
 */
class OutputFileWriter {
    /**
     * This method gets an array of bytes and a file and writes all bytes of array to file
     *
     * @param bytes The array byte that will be wrote to file
     * @param file  The file that the byte array will be written on it
     * @throws IOException Throw exception for the file input stream when needed
     */
    void write(byte[] bytes, File file) throws IOException {
        FileOutputStream writer = new FileOutputStream(file);
        writer.write(bytes);
        writer.close();
    }
}