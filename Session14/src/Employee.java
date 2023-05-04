import java.util.Scanner;

public class Employee extends Person {

    private String phoneNumber;

    public Employee() {

    }

    public Employee(String maso, String hoTen, String email, String phoneNumber) {
        Maso = maso;
        HoTen = hoTen;
        Email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    void NhapTT() {
        Scanner sc = new Scanner(System.in);
        String tempid = "";
        employeeManagement management = new employeeManagement();
        String tempname = "";
        String tempemail = "";
        String tempphoneNumber = "";
        boolean idWrong = true;
        boolean nameWrong = true;
        int countSpaceForName = 0;

        boolean phoneNumberWrong = true;
        System.out.println("--Nhap TT Nhan vien--");

        do {

            try {
                idWrong = false;
                System.out.print("Ma: ");
                tempid = sc.nextLine();
                char chars[] = String.valueOf(tempid).toCharArray();
                for (Person employee : management.storageEmployee) {
                    if (employee.Maso.equals(tempid)) {
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
        Maso = tempid;
        HoTen = tempname;
        Email = tempemail;
        setPhoneNumber(tempphoneNumber);
        System.out.println("---------------------------------");
    }

    @Override
    void InTT() {
        System.out.printf("%s -- %s -- %s -- %s\n", Maso, HoTen, Email,
                getPhoneNumber());
    }

}
