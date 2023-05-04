import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class quizExam {
    readData read = new readData();
    private ArrayList<quiz> quizStorage;
    private int numberOfQuiz = 0;

    public void menu() {

        Scanner sc = new Scanner(System.in);
        System.out.println("== DO VUI ==");
        System.out.println("1. Thiet lap qui mo de thi");
        System.out.println("2. Thi");
        System.out.println("3. Thoat");
        System.out.println("---------------------------------");

        while (true) {
            System.out.print("Ban chon: ");
            try {
                int option = Integer.parseInt(sc.nextLine());
                System.out.println("---------------------------------");
                if (option == 1) {
                    setUp();
                } else if (option == 2) {
                    startTheTest();
                } else if (option == 3) {
                    System.out.println("Tam biet!!!");
                    System.exit(0);
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Vui long chon tu 1-3");
            }
        }
    }

    public void setUp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("QUI MO DE THI");
        System.out.print("So luong cau hoi cho de thi: ");
        numberOfQuiz = Integer.parseInt(sc.nextLine());
        quizStorage = read.getStorageQuiz();
        System.out.println("Luu thanh cong");
    }

    public void startTheTest() {
        if (numberOfQuiz == 0) {
            System.out.println("Vui long thiet lap quy mo de thi truoc khi bat dau!");
        } else {
            Random random = new Random();
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < numberOfQuiz; i++) {
                int question = random.nextInt(quizStorage.size());
                System.out.println("CAU HOI");
                System.out.printf("Noi dung cau hoi: %s\n",
                        quizStorage.get(question).getQuestion());
                System.out.print("Tu khoa: ");
                for (int j = 0; j < quizStorage.get(question).getAnswer().length(); j++) {
                    System.out.print("-");
                }
                System.out.println();

                System.out.print(
                        "Cac ky tu co trong tu khoa la: " + randomKeyWord(quizStorage.get(question).getAnswer())
                                + "\n");
                System.out.print("Dap an cua ban la: ");
                String yourAnswer = sc.nextLine();

                if (yourAnswer.equals(quizStorage.get(question).getAnswer()) && i != quizStorage.size() - 1) {
                    System.out.println("=> CHUC MUNG, TIEP TUC");
                    quizStorage.remove(question);

                } else if (yourAnswer.equals(quizStorage.get(question).getAnswer()) && i == numberOfQuiz - 1) {
                    System.out.println("=> BAN DA THANG TRO CHOI");

                } else {
                    System.out.println("=> THUA");
                    break;
                }
            }
        }
    }

    public StringBuilder randomKeyWord(String answer) {
        ArrayList<Character> letters = new ArrayList<>();
        StringBuilder hintForAnswer = new StringBuilder();
        for (char c : answer.toCharArray()) {
            if (!(letters.contains(c))) {
                letters.add(c);
            }
        }
        Collections.shuffle(letters);
        for (char letter : letters) {
            if (letter != ' ') {
                hintForAnswer.append(letter);
            }
        }
        return hintForAnswer;
    }
}
