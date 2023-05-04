import java.util.ArrayList;
import java.util.Scanner;

public class teacherManagement {
    private ArrayList<teacher> storageTeacher = new ArrayList<>();

    public void menu() {
        Scanner sc = new Scanner(System.in);
        String input = "";

        while (true) {
            System.out.println("CHUONG TRINH QUAN LY THONG TIN GIAO VIEN");
            System.out.println("1. Nhap 1 giao vien");
            System.out.println("2. In danh sach giao vien");
            System.out.println("3. Thoat");
            System.out.println("---------------------------------");
            System.out.print("Ban chon: ");
            try {
                input = sc.next();
                System.out.println("---------------------------------");
                if (Integer.parseInt(input) == 1) {
                    inputTeacher();
                } else if (Integer.parseInt(input) == 2) {
                    display();
                } else if (Integer.parseInt(input) == 3) {
                    System.out.println("TAM BIET!!!");
                    sc.close();
                    System.exit(0);
                } else {
                    System.out.println("Vui long chon 1-3!");
                }
            } catch (Exception e) {
                System.out.println("Vui long chon 1-3!");

            }

        }

    }

    public void inputTeacher() {
        Scanner sc = new Scanner(System.in);
        int tempid = 0;
        String tempname = "";
        String tempemail = "";
        String tempphoneNumber = "";
        boolean idWrong = true;
        boolean nameWrong = true;
        int countSpaceForName = 0;

        boolean phoneNumberWrong = true;
        System.out.println("--Nhap TT Giao vien--");

        do {

            try {
                idWrong = false;
                System.out.print("Ma: ");
                tempid = Integer.parseInt(sc.nextLine());
                char chars[] = String.valueOf(tempid).toCharArray();
                for (teacher teacher : storageTeacher) {
                    if (teacher.getId() == tempid) {
                        idWrong = true;
                    }
                }
                for (char eachChar : chars) {
                    if (!Character.isDigit(eachChar)) {
                        idWrong = true;
                    }
                }
                if (idWrong) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error: ma giao vien khong hop le. Vui long nhap lai");
                idWrong = true;

            }
        } while (idWrong);

        do {

            try {
                nameWrong = false;
                System.out.print("Ho ten: ");

                tempname = sc.nextLine();
                char chars[] = String.valueOf(tempname).toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    if (!((chars[i] >= 'A' && chars[i] <= 'Z')
                            || (chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] == ' '))) {
                        nameWrong = true;
                    }
                    if (chars[i] == ' ' && ((chars[i + 1] >= 'A' && chars[i + 1] <= 'Z')
                            || (chars[i + 1] >= 'a' && chars[i + 1] <= 'z'))) {
                        countSpaceForName++;
                    }
                }
                if (countSpaceForName == 0) {
                    nameWrong = true;
                }
                if (nameWrong) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error: ho ten khong hop le. Vui long nhap lai");
                nameWrong = true;

            }
        } while (nameWrong);

        System.out.print("Email: ");
        tempemail = sc.nextLine();

        do {

            try {
                phoneNumberWrong = false;
                System.out.print("Dien thoai: ");
                tempphoneNumber = sc.nextLine();
                char chars[] = String.valueOf(tempphoneNumber).toCharArray();

                for (char eachChar : chars) {
                    if (!Character.isDigit(eachChar) || chars.length != 10) {
                        phoneNumberWrong = true;
                    }
                }
                if (phoneNumberWrong) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error: Dien thoai khong hop le. Vui long nhap lai");
                phoneNumberWrong = true;

            }
        } while (phoneNumberWrong);

        storageTeacher.add(new teacher(tempid, tempname, tempemail, tempphoneNumber));
        System.out.println("---------------------------------");
    }

    public void display() {
        System.out.println("--Danh sach giao vien--");
        System.out.println("Ma so -- Ho ten -- Email – Dien thoai");
        for (teacher each : storageTeacher) {
            System.out.printf("%d -- %s -- %s -- %s\n", each.getId(), each.getName(), each.getEmail(),
                    each.getPhoneNumber());
        }
        System.out.println("---------------------------------");

    }
}
