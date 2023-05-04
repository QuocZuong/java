import java.util.Scanner;

public class bubble {
    private int arr[] = new int[1000];
    private int len;

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");

        try {
            len = Integer.parseInt(sc.nextLine());
            if (len < 2) {
                throw new Exception();
            } else {
                System.out.print("Chuoi so: ");
                for (int i = 0; i < len; i++) {
                    arr[i] = sc.nextInt();
                }
            }
        } catch (Exception e) {
            System.out.println("Loi: N phai la mot so >= 2");
            System.exit(0);
        } finally {
            sc.close();
        }
    }

    void sort() {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int j = 0; j < len - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    sorted = false;
                }
            }

        }
    }

    void print() {

        System.out.println("Danh sach sau khi sap xep bubble sort:");
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                System.out.print(arr[i]);

            } else {
                System.out.print("-" + arr[i]);
            }
        }

    }
}