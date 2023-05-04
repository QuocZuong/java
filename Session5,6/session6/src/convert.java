import java.util.Scanner;

public class convert {
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("CHUONG TRINH QUI DOI CO SO");
        System.out.println("1. Doi tu thap phan sang thap luc phan");
        System.out.println("2. Doi tu thap luc phan sang thap phan");
        System.out.println("3. Thoat");
        System.out.println("---------------------------------");

        while (true) {
            System.out.print("Ban chon: ");
            try {
                int choice = Integer.parseInt(sc.nextLine());

                if (choice == 1) {
                    decimalToHexa();
                    System.out.println("---------------------------------");

                } else if (choice == 2) {
                    hexaToDecimal();
                    System.out.println("---------------------------------");

                } else if (choice == 3) {
                    System.out.println("TAM BIET!!!");
                    System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Vui long chon so 1-3");
            }
        }
    }

    public void decimalToHexa() {
        Scanner sc = new Scanner(System.in);
        String binary = "";
        System.out.print("Nhap decimal: ");
        int decimal = sc.nextInt();
        while (decimal > 0) {
            binary = decimal % 2 + binary;
            decimal = decimal / 2;
        }
        System.out.println("So nhi phan: " + binary);
    }

    public void hexaToDecimal() {
        Scanner sc = new Scanner(System.in);
        int decimal = 0;
        String binary = sc.nextLine();
        for (int i = 0; i < binary.length(); i++) {
            int bi = binary.charAt(i) - '0';
            decimal += bi * Math.pow(2, binary.length() - i - 1);
        }
        System.out.println("So thap phan: " + decimal);
    }
}