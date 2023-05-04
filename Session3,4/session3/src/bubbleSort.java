import java.util.Scanner;

public class bubbleSort {
    private int arr[] = new int[1000];
    private int n;

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        try {
            n = Integer.parseInt(sc.nextLine());
            if (n < 2) {
                throw new Exception();

            } else {
                System.out.print("Chuoi so: ");
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
            }
        } catch (Exception e) {
            System.out.println("Loi: N phai la mot so >=2");
            System.exit(0);
        }

    }

    // bubble sort desc
    public void sort() {
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public void output() {
        System.out.print("Danh sach sau khi sap theo bubble sort: \n");
        System.out.print(arr[0]);
        for (int i = 1; i < n; i++) {
            System.out.print("-" + arr[i]);
        }
    }

    public void binarySearch() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nSo can tim: ");
        int valueToSearch = Integer.parseInt(sc.nextLine());
        int low = 0;
        int high = n - 1;
        int mid = 0;
        int position = -1;
        // thuat toan binary search
        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == valueToSearch) {
                position = mid;
                break;
                // search ve phia ben trai
            } else if (arr[mid] < valueToSearch) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        if (position == -1) {
            System.out.printf("Khong tim thay so %d trong mang", valueToSearch);
        } else {
            System.out.printf("Ket qua tim: thay tai vi tri thu %d\n", (position + 1));
        }

    }
}
