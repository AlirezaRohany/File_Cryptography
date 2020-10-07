package ir.aut.midProject;

/**
 * It's an abstract class that uses for cryptography
 * Has two methods
 * Method encrypt has a string input, and encrypt a string object and returns the encrypted
 * Method decrypt has a string input, and decrypt a string object and returns the decrypted
 */
abstract class BaseCryptography {
    abstract String encrypt(String plainText);

    abstract String decrypt(String cipherText);
}