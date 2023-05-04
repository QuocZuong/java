import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ComicBook book = new ComicBook();
        Scanner sc = new Scanner(System.in);
        read read = new read();
        read.readBook();
        book.listBook = read.getListBook();
        write write = new write();

        do {

            System.out.print("COMIC BOOK RENTAL SHOP" + "\n"
                    + "1. Add new comic book." + "\n"
                    + "2. Search book by title." + "\n"
                    + "3. Search book of an author." + "\n"
                    + "4. Update book rental price." + "\n"
                    + "5. Delete comic book." + "\n"
                    + "6. Quit." + "\n"
                    + "Please select a funtion: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    book.addBook();
                    book.showBook();
                    break;
                case 2:
                    book.searchByName();
                    break;
                case 3:
                    book.searchByAuthor();
                    break;
                case 4:
                    book.upDateRentalPrice();
                    System.out.println("Book list after update:");
                    book.showBook();
                    write.writeFile(book);
                    break;
                case 5:
                    book.removeBook();
                    book.showBook();
                    break;
                case 6:
                    System.out.println("Thanks for using my tool 😆");
                    write.writeFile(book);
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please enter a valid choice from 1 to 6");
            }
        } while (true);

    }
}
