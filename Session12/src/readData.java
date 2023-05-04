import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class readData {
    public ArrayList<quiz> storageQuiz = new ArrayList<>();

    public void read() {
        try {
            Scanner sc = new Scanner(new File("/Users/quoczuong/FPT/SP23/Lab211/Code/Session12/src/quiz.txt"));
            while (sc.hasNextLine()) {
                quiz quiz = new quiz();
                quiz.setQuestion(sc.nextLine());
                quiz.setAnswer(sc.nextLine());
                storageQuiz.add(quiz);
            }

        } catch (Exception e) {
            System.out.println("File khong ton tai");
        }
    }

    public ArrayList<quiz> getStorageQuiz() {
        read();
        return storageQuiz;
    }
}
