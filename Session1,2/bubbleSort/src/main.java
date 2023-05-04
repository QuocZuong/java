import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        int n = 0;

        try {
            n = sc.nextInt();
            if (n < 2) {
                System.out.println("Loi: N phai la mot so >= 2");
            } else {
                int arr[] = new int[n];
                System.out.print("Chuoi so: ");
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                bubble bb = new bubble();
                bb.sort(arr, arr.length);
                bb.print(arr, arr.length);
            }
        } catch (Exception e) {
            System.out.println("Loi: N phai la mot so >= 2");
        }

    }
}