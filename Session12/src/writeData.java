import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class writeData {
    public void write(ArrayList<quiz> storageQuiz) {
        try (
                FileWriter fw = new FileWriter("/Users/quoczuong/FPT/SP23/Lab211/Code/Session12/src/quiz.txt", false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);) {

            for (int i = 0; i < storageQuiz.size(); i++) {
                pw.println(storageQuiz.get(i).getQuestion());
                pw.println(storageQuiz.get(i).getAnswer());

            }
        } catch (Exception e) {

        }
    }
}
