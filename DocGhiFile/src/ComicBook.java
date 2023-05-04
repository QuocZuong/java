import java.util.*;

public class ComicBook {

    private int ID;
    private String Title;
    private double bookRentalPrice;
    private String Author;
    private int Volume;
    Scanner sc = new Scanner(System.in);
    read read = new read();
    write write = new write();
    public ArrayList<ComicBook> listBook = read.getListBook();

    public ComicBook() {

    }

    public ComicBook(int ID, String Title, double bookRentalPrice, String Author, int Volume) {
        this.ID = ID;
        this.Title = Title;
        this.bookRentalPrice = bookRentalPrice;
        this.Author = Author;
        this.Volume = Volume;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setBookRentalPrice(double bookRentalPrice) {
        this.bookRentalPrice = bookRentalPrice;
    }

    public void setAuthor(String author) {
        this.Author = author;
    }

    public void setVolume(int volume) {
        this.Volume = volume;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public double getBookRentalPrice() {
        return bookRentalPrice;
    }

    public String getAuthor() {
        return Author;
    }

    public int getVolume() {
        return Volume;
    }

    public void showBook() {
        for (int i = 0; i < listBook.size(); i++) {
            System.out.printf("-- %d -- %s -- %.2f -- %s -- %d", listBook.get(i).getID(), listBook.get(i).getTitle(),
                    listBook.get(i).getBookRentalPrice(), listBook.get(i).getAuthor(), listBook.get(i).getVolume());
            System.out.println();
            System.out.println("----------------------------------------------");

        }
    }

    public void addBook() {
        ComicBook book = new ComicBook();

        int n = 0;
        System.out.print("ID: ");
        book.setID(sc.nextInt());
        sc.nextLine();
        System.out.print("Title: ");
        book.setTitle(sc.nextLine());
        System.out.print("Rental Price: ");
        book.setBookRentalPrice(sc.nextDouble());
        sc.nextLine();
        System.out.print("Author: ");
        book.setAuthor(sc.nextLine());
        System.out.print("Volume: ");
        book.setVolume(sc.nextInt());
        listBook.add(n, book);
        sc.nextLine();
        n++;
        System.out.println("Add book successfully!!!");
        System.out.println("----------------------------------------------");

    }

    public void searchByName() {
        System.out.print("Please enter a title you want to search: ");
        String name = sc.nextLine();
        boolean check = false;
        System.out.println("-- ID -- Title -- RentalPrice -- Author -- Volume");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < listBook.size(); i++) {
            if ((listBook.get(i).getTitle().toLowerCase()).contains(name.toLowerCase())) {
                System.out.print("-- " + listBook.get(i).getID() + " --");
                System.out.print(listBook.get(i).getTitle() + " -- ");
                System.out.print(listBook.get(i).getBookRentalPrice() + " -- ");
                System.out.print(listBook.get(i).getAuthor() + " -- ");
                System.out.println(listBook.get(i).getVolume() + " --");
                System.out.println("----------------------------------------------");
                check = true;
            }

        }
        if (check == false) {
            System.out.println("Book not found with this title!");
        }
    }

    public void searchByAuthor() {
        System.out.print("Please enter an author's name you want to search: ");
        String author = sc.nextLine();
        System.out.println("-- ID -- Title -- RentalPrice -- Author -- Volume");
        System.out.println("----------------------------------------------");
        boolean check = false;
        for (int i = 0; i < listBook.size(); i++) {
            if ((listBook.get(i).getAuthor().toLowerCase()).contains(author.toLowerCase())) {
                System.out.print("-- " + listBook.get(i).getID() + " --");
                System.out.print(listBook.get(i).getTitle() + " -- ");
                System.out.print(listBook.get(i).getBookRentalPrice() + " -- ");
                System.out.print(listBook.get(i).getAuthor() + " -- ");
                System.out.println(listBook.get(i).getVolume() + " --");
                System.out.println("----------------------------------------------");
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Book not found with this author!");
        }
    }

    public void upDateRentalPrice() {
        System.out.print("Please enter an ID of the book you want to update price: ");
        int id = sc.nextInt();
        for (int i = 0; i < listBook.size(); i++) {
            if (listBook.get(i).getID() == id) {
                System.out.println("The rental price of this book is: " + listBook.get(i).getBookRentalPrice());
                System.out.print("Please enter the new rental price: ");
                listBook.get(i).setBookRentalPrice(sc.nextDouble());
                sc.nextLine();
                System.out.println("Update successfully!");
                System.out.println("----------------------------------------------");
                break;
            } else {
                System.out.println("There is no book with this ID. Please try again!");
            }
        }
    }

    public void removeBook() {
        System.out.print("Please enter the ID of the book to remove");
        int id = sc.nextInt();
        for (int i = 0; i < listBook.size(); i++) {
            if (listBook.get(i).getID() == id) {
                listBook.remove(i);
                System.out.println("Remove successfully!");
                System.out.println("----------------------------------------------");
                break;
            }
        }
    }

}