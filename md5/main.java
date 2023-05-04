
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class main {
    public static void main(String[] args) {
        String input = "example string"; // this code you want to hash
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes()); // convert input string to byte array
            BigInteger no = new BigInteger(1, messageDigest); // To convert the byte array to a hexadecimal string, 1
                                                              // mean BigInteger must be positive
            String hashText = no.toString(16); // convert the BigInteger to a hexadecimal string using the toString
                                               // method with a radix of 16.
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            System.out.println("MD5 hash of '" + input + "' is: " + hashText);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
    }
}