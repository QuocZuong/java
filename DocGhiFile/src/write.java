import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class write {

    public void writeFile(ComicBook book) {

        try (
                FileWriter fw = new FileWriter("ComicBooks.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);) {

            for (int i = 0; i < book.listBook.size(); i++) {
                pw.println(book.listBook.get(i).getID());
                pw.println(book.listBook.get(i).getTitle());
                pw.println(book.listBook.get(i).getBookRentalPrice());
                pw.println(book.listBook.get(i).getAuthor());
                pw.println(book.listBook.get(i).getVolume());

            }
        } catch (Exception e) {

        }

    }
}
