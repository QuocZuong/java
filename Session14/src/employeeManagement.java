import java.util.ArrayList;
import java.util.Scanner;

public class employeeManagement {

    ArrayList<Employee> storageEmployee = new ArrayList<>();

    public void menu() {
        Scanner sc = new Scanner(System.in);
        String input = "";

        while (true) {
            System.out.println("CHUONG TRINH QUAN LY THONG TIN NHAN VIEN");
            System.out.println("1. Nhap 1 nhan vien");
            System.out.println("2. In danh sach nhan vien");
            System.out.println("3. Thoat");
            System.out.println("---------------------------------");
            System.out.print("Ban chon: ");
            try {
                input = sc.next();
                System.out.println("---------------------------------");
                if (Integer.parseInt(input) == 1) {
                    inputEmployee();
                } else if (Integer.parseInt(input) == 2) {
                    displayEmployee();
                } else if (Integer.parseInt(input) == 3) {
                    System.out.println("TAM BIET!!!");
                    sc.close();
                    System.exit(0);
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Vui long chon 1-5!");

            }

        }
    }

    public void inputEmployee() {
        Employee employee = new Employee();
        employee.NhapTT();
        storageEmployee.add(employee);
    }

    public void displayEmployee() {
        System.out.println("--Danh sach giao vien--");
        System.out.println("Ma so -- Ho ten -- Email –- Dien thoai");
        for (Employee employee : storageEmployee) {
            employee.InTT();
        }
        System.out.println("---------------------------------");

    }
}
