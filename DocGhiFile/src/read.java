import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class read {
    public ArrayList<ComicBook> listBook = new ArrayList<>();

    public void readBook() {
        try {
            Scanner sc = new Scanner(new File("ComicBooks.txt"));
            while (sc.hasNextLine()) {
                ComicBook book = new ComicBook();
                book.setID(Integer.parseInt(sc.nextLine()));
                book.setTitle(sc.nextLine());
                book.setBookRentalPrice(Double.parseDouble(sc.nextLine()));
                book.setAuthor(sc.nextLine());
                book.setVolume(Integer.parseInt(sc.nextLine()));
                listBook.add(book);

            }
        } catch (Exception e) {

        }

    }

    public ArrayList<ComicBook> getListBook() {
        return listBook;
    }
}
