import java.util.ArrayList;
import java.util.Scanner;

public class quizManagement {
    ArrayList<quiz> storageQuiz = new ArrayList<>();

    public void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("NGAN HANG CAU HOI");
        System.out.println("1. Them cau hoi");
        System.out.println("2. Sua cau hoi");
        System.out.println("3. Xoa cau hoi");
        System.out.println("4. In danh sach cau hoi");
        System.out.println("5. Tim cau hoi theo STT");
        System.out.println("6. Thoat");
        do {

            System.out.println("---------------------------------");
            System.out.print("Ban chon: ");
            try {
                int input = Integer.parseInt(sc.nextLine());
                System.out.println("---------------------------------");
                if (input == 1) {
                    input();
                } else if (input == 2) {
                    edit();
                } else if (input == 3) {
                    delete();
                } else if (input == 4) {
                    display();
                } else if (input == 5) {
                    search();
                } else if (input == 6) {
                    System.out.println("TAM BIET!!!");
                    System.exit(0);
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Vui long chon tu 1-6!");
            }
        } while (true);
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("CAU HOI");
        System.out.print("Noi dung cau hoi: ");
        String word = sc.nextLine();
        System.out.print("Tu khoa: ");
        String mean = sc.nextLine();
        storageQuiz.add(new quiz(word, mean));
        System.out.println("Luu thanh cong");
    }

    public void edit() {
        Scanner sc = new Scanner(System.in);
        int sttToEdit = 0;
        String newQuestion = "";
        String newAnswer = "";
        int temp = 0;
        System.out.println("(nhap ‘n’ - neu noi dung do khong thay doi)");
        System.out.println("SUA CAU HOI");
        System.out.print("Stt cau can sua: ");
        sttToEdit = Integer.parseInt(sc.nextLine()) - 1;
        System.out.print("Noi dung cau hoi: ");
        newQuestion = sc.nextLine();
        System.out.print("Tu khoa: ");
        newAnswer = sc.nextLine();
        for (int i = 0; i < storageQuiz.size(); i++) {
            if (i == sttToEdit) {
                if (!newQuestion.equalsIgnoreCase("n")) {
                    storageQuiz.get(i).setQuestion(newQuestion);
                }
                storageQuiz.get(i).setAnswer(newAnswer);
                temp++;
                System.out.println("Luu thanh cong");
                break;
            }
        }
        if (temp == 0) {
            System.out.println("Ket qua: khong tim thay");
        }
    }

    public void delete() {
        Scanner sc = new Scanner(System.in);
        int sttToDelete = 0;
        int temp = 0;
        System.out.println("XOA CAU HOI");
        System.out.print("Stt cau can xoa: ");
        sttToDelete = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < storageQuiz.size(); i++) {
            if (i == sttToDelete - 1) {
                storageQuiz.remove(i);
                temp++;
                System.out.println("Xoa thanh cong.");
                break;
            }
        }
        if (temp == 0) {
            System.out.println("Ket qua: khong tim thay");
        }
    }

    public void display() {
        System.out.println("DANH SACH CAU HOI");
        System.out.println("Stt - Noi dung cau hoi - Tu khoa");
        for (int i = 0; i < storageQuiz.size(); i++) {
            System.out.printf("%d - %s - %s\n", i + 1, storageQuiz.get(i).getQuestion(),
                    storageQuiz.get(i).getAnswer());
        }
    }

    public void search() {
        Scanner sc = new Scanner(System.in);
        int temp = 0;
        int sttToSearch = 0;
        System.out.println("NOI DUNG CAU HOI");
        System.out.print("Stt: ");
        sttToSearch = Integer.parseInt(sc.nextLine()) - 1;
        for (int i = 0; i < storageQuiz.size(); i++) {
            if (i == sttToSearch) {
                System.out.println("Noi dung cau hoi: " + storageQuiz.get(i).getQuestion());
                System.out.println("Tu khoa: " + storageQuiz.get(i).getAnswer());
                temp++;
                break;
            }
        }
        if (temp == 0) {
            System.out.println("Ket qua: khong tim thay");
        }
    }
}
