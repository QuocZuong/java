import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter text to encrypt: ");
        String plainText = input.nextLine();
        System.out.println("Enter the shift key (0-25): ");
        int shiftKey = input.nextInt();
        String cipherText = encrypt(plainText, shiftKey);
        System.out.println("Encrypted text: " + cipherText);
        String decryptedText = decrypt(cipherText, shiftKey);
        System.out.println("Decrypted text: " + decryptedText);
    }

    public static String encrypt(String plainText, int shiftKey) {
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            if (Character.isUpperCase(plainText.charAt(i))) {
                char ch = (char) (((int) plainText.charAt(i) + shiftKey - 65) % 26 + 65);
                cipherText.append(ch);
            } else if (Character.isLowerCase(plainText.charAt(i))) {
                char ch = (char) (((int) plainText.charAt(i) + shiftKey - 97) % 26 + 97);
                cipherText.append(ch);
            } else {
                cipherText.append(plainText.charAt(i));
            }
        }
        return cipherText.toString();
    }

    public static String decrypt(String cipherText, int shiftKey) {
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            if (Character.isUpperCase(cipherText.charAt(i))) {
                char ch = (char) (((int) cipherText.charAt(i) - shiftKey - 65 + 26) % 26 + 65);
                plainText.append(ch);
            } else if (Character.isLowerCase(cipherText.charAt(i))) {
                char ch = (char) (((int) cipherText.charAt(i) - shiftKey - 97 + 26) % 26 + 97);
                plainText.append(ch);
            } else {
                plainText.append(cipherText.charAt(i));
            }
        }
        return plainText.toString();
    }
}
