
import java.util.Scanner;

public class separateLetter {
    private String str;
    private char arr[] = new char[1000];
    private int numberOfA;
    private int numberOfB;
    private int numberOfC;
    private int numberOfD;

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Chuoi: ");
        str = sc.nextLine();
        try {
            arr = str.toCharArray();

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 'a') {
                    numberOfA += 1;
                } else if (arr[i] == 'b') {
                    numberOfB += 1;
                } else if (arr[i] == 'c') {
                    numberOfC += 1;
                } else if (arr[i] == 'd') {
                    numberOfD += 1;
                } else {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("Loi: chuoi co ky tu khac a, b, c va d");
            System.exit(0);
        }
        System.out.println("Danh sach cac ky tu:");
        System.out.printf("a: %d lan\n", numberOfA);
        System.out.printf("b: %d lan\n", numberOfB);
        System.out.printf("c: %d lan\n", numberOfC);
        System.out.printf("d: %d lan\n", numberOfD);

    }
}
