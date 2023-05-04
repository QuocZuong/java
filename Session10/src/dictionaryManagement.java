import java.util.ArrayList;
import java.util.Scanner;

public class dictionaryManagement {
    ArrayList<dictionary> storageDictionary = new ArrayList<>();

    public void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("MY DICTIONARY");
        System.out.println("1. Nhap 1 tu");
        System.out.println("2. Sua 1 tu");
        System.out.println("3. Xoa 1 tu");
        System.out.println("4. In danh sach cac tu da hoc");
        System.out.println("5. Tim tu");
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
        System.out.println("-- Nhap Tu --");
        System.out.print("Tu: ");
        String word = sc.nextLine();
        System.out.print("Nghia: ");
        String mean = sc.nextLine();
        storageDictionary.add(new dictionary(word, mean));
    }

    public void edit() {
        Scanner sc = new Scanner(System.in);
        String wordToEdit;
        String newMeaning = "";
        int temp = 0;
        System.out.println("-- Sua Tu --");
        System.out.print("Tu can sua: ");
        wordToEdit = sc.nextLine();
        for (dictionary word : storageDictionary) {
            if (word.getWord().equalsIgnoreCase(wordToEdit)) {
                System.out.print("Nghia moi: ");
                newMeaning = sc.nextLine();
                word.setMean(newMeaning);
                System.out.println("Ket qua: da sua thanh cong");
                temp++;
                break;
            }
        }
        if (temp == 0) {
            System.out.println("Ket qua: khong tim thay");
        }
    }

    public void delete() {
        System.out.println("--Xoa Tu--");
        String wordToDelete = "";
        int temp = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Tu can xoa: ");
        wordToDelete = sc.nextLine();
        for (dictionary word : storageDictionary) {
            if (word.getWord().equalsIgnoreCase(wordToDelete)) {
                storageDictionary.remove(word);
                temp++;
                System.out.println("Ket qua: da xoa thanh cong");
                break;
            }
        }
        if (temp == 0) {
            System.out.println("Ket qua: khong tim thay");
        }
    }

    public void display() {
        System.out.println("--Danh sach cac tu da hoc--");
        for (dictionary word : storageDictionary) {
            System.out.printf("%s: %s\n", word.getWord(), word.getMean());
        }
    }

    public void search() {
        System.out.println("--Tim Tu--");
        Scanner sc = new Scanner(System.in);
        int temp = 0;
        String wordToSearch = "";
        System.out.print("Tu can tim: ");
        wordToSearch = sc.nextLine();
        for (dictionary word : storageDictionary) {
            if (word.getWord().equalsIgnoreCase(wordToSearch)) {
                System.out.printf("Nghia: %s\n", word.getMean());
                temp++;
            }
        }
        if (temp == 0) {
            System.out.println("Ket qua: khong tim thay");
        }
    }
}
