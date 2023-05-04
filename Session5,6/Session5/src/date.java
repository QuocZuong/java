import java.util.Date;
import java.util.Scanner;

public class date {
    private Date today;
    private String inputDay;

    // constructor
    public date() {
        today = new Date();
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ngay hen = ");
        inputDay = sc.nextLine();
        check();
    }

    public void check() {
        // tach ra ngay, thang, nam va luu vao mang
        String[] storageDay = new String[10000];
        if (inputDay.contains("/")) {
            storageDay = inputDay.split("/");
        } else if (inputDay.contains("-")) {
            storageDay = inputDay.split("-");

        } else {
            System.out.println("Thong bao: Ngay khong hop le");
            System.exit(0);
        }
        int dayOfThisMonth = -1;
        int leapYear = 0;

        // create Date
        Date checkDate = new Date(Integer.parseInt(storageDay[2]) - 1900, Integer.parseInt(storageDay[1]) - 1,
                Integer.parseInt(storageDay[0]));

        // check valid date
        if (Integer.parseInt(storageDay[2]) % 400 == 0
                || ((Integer.parseInt(storageDay[2]) % 4 == 0 && Integer.parseInt(storageDay[2]) % 100 != 0))) {
            leapYear = 1;
        }
        // check day
        if (Integer.parseInt(storageDay[0]) <= 0 || Integer.parseInt(storageDay[0]) > 31) {
            System.out.println("Thong bao: Ngay khong hop le");
            System.exit(0);

            // check year
        } else if (Integer.parseInt(storageDay[2]) <= 0) {
            System.out.println("Thong bao: Ngay khong hop le");
            System.exit(0);
        } else if (Integer.parseInt(storageDay[1]) < 1 || Integer.parseInt(storageDay[1]) > 12) {
            System.out.println("Thong bao: Ngay khong hop le");
            System.exit(0);
        }

        // check year
        switch (Integer.parseInt(storageDay[1])) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dayOfThisMonth = 31;
                break;
            case 2:
                dayOfThisMonth = 28 + leapYear;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dayOfThisMonth = 30;
                break;
            default:
                dayOfThisMonth = -1;
                break;
        }

        // check day
        if (Integer.parseInt(storageDay[0]) > dayOfThisMonth) {
            System.out.println("Thong bao: Ngay khong hop le");
        } else if (checkDate.before(today)) {
            System.out.println("Thong bao: Ngay khong hop le");
        } else {
            System.out.println("Thong bao: Ngay hop le");
        }

    }
}