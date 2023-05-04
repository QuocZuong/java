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
        int i = 0;
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
            i++;
            System.out.printf("Lan lap thu %d:\n", i);
            print();
            System.out.println();
            max(arr);
        }
    }

    void max(int arr[]) {
        int max = arr[0];
        System.out.println(max);
    }

    void print() {

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                System.out.print(arr[i]);

            } else {
                System.out.print("-" + arr[i]);
            }
        }

    }
}