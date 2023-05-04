public class EightQueen {
    static int a[] = new int[9];// a[i] co nghia la quan hau dang co toa do i = i, j = a[i]

    public static void main(String[] args) {
        Job(1);

    }

    public static void Job(int i) {
        for (int j = 1; j <= 8; j++) {
            if (check(i, j)) {// khong va cham thi luu toa do cua quan hau hien tai vao mang a
                a[i] = j;
                if (i == 8) {
                    output();
                    System.out.println();
                }
                Job(i + 1);
            }
        }
    }

    public static boolean check(int x, int y) {// check xem co bi va cham voi cac quan hau da dat truoc do hay k
        for (int i = 1; i < x; i++) {
            if (i - a[i] == x - y || i + a[i] == x + y || a[i] == y) {
                return false;
            }
        }
        return true;
    }

    public static void output() {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (a[i] == j) {
                    System.out.print(" Q ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }
}
