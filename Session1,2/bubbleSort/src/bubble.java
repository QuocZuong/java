import java.util.Set;

public class bubble {
    private int arr[];
    private int len;

    
    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public bubble() {

    }

    public bubble(int arr[], int len) {
        this.arr = arr;
        this.len = len;

    }

    void sort(int arr[], int len) {
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }
    }

    void print(int arr[], int len) {
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