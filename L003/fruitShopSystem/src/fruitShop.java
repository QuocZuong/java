import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class fruitShop {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private String origin;

    private ArrayList<fruitShop> storage = new ArrayList<>();
    private Hashtable<String, shopping> customer = new Hashtable<>();
    private ArrayList<shopping> order = new ArrayList<>();

    public ArrayList<fruitShop> getStorage() {
        return storage;
    }

    public void setStorage(ArrayList<fruitShop> storage) {
        this.storage = storage;
    }

    Scanner sc = new Scanner(System.in);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public fruitShop() {

    }

    public fruitShop(int id, String name, int price, int quantity, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public void menu() {

        while (true) {
            System.out.println("   FRUIT SHOP SYSTEM");
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
            System.out.print("   Please choose: ");
            try {

                int input = sc.nextInt();
                sc.nextLine();
                if (input == 1) {
                    addFruit();
                } else if (input == 2) {
                    viewOrders();
                } else if (input == 3) {
                    shoppingForBuyer();
                } else if (input == 4) {
                    System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Please choose from 1 to 4!\n");

            }
        }

    }

    public void addFruit() {
        boolean isContinue = true;
        boolean idWrong = false;
        boolean priceWrong = false;
        boolean quantityWrong = false;

        while (isContinue) {

            do {

                try {
                    idWrong = false;
                    System.out.print("ID = ");

                    this.id = sc.nextInt();
                    sc.nextLine();

                } catch (Exception e) {
                    System.out.println("Please enter integer id!");
                    idWrong = true;

                }
            } while (idWrong);

            System.out.print("Name = ");
            this.name = sc.nextLine();

            do {

                try {
                    priceWrong = false;
                    System.out.print("Price = ");
                    this.price = sc.nextInt();
                    sc.nextLine();

                } catch (Exception e) {
                    System.out.println("Please enter integer price!");
                    priceWrong = true;
                }
            } while (priceWrong);

            do {

                try {
                    quantityWrong = false;
                    System.out.print("Quantity = ");
                    this.quantity = sc.nextInt();
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println("Please enter integer quantity!");
                    quantityWrong = true;
                }
            } while (quantityWrong);

            System.out.print("Origin = ");
            this.origin = sc.nextLine();

            fruitShop fruit = new fruitShop(this.id, this.name, this.price, this.quantity, this.origin);
            storage.add(fruit);
            boolean isContinueInput = true;
            while (isContinueInput) {
                System.out.println("Do you want to order now (Y/N)?");
                String inputAnswer = sc.nextLine();

                if (inputAnswer.equalsIgnoreCase("N") || inputAnswer.equalsIgnoreCase("n")) {
                    isContinue = false;
                    isContinueInput = false;
                } else if (inputAnswer.equalsIgnoreCase("Y") || inputAnswer.equalsIgnoreCase("y")) {
                    isContinue = true;
                    isContinueInput = false;

                } else {
                    System.out.println("Please enter Y or N!");
                    isContinueInput = true;
                }
            }

        }

    }

    public void viewOrders() {
        System.out.println("hihi");
        Set<String> customerName = customer.keySet();
        System.out.println("hoho");
        int total = 0;
        for (String name : customerName) {
            System.out.println("Customer: " + name);
            System.out.println("+-----+--------------------+----------+-------+--------+");
            System.out.println("| No. | Product            | Quantity | Price | Amount |");
            System.out.println("+-----+--------------------+----------+-------+--------+");
            for (int i = 0; i < order.size(); i++) {
                total += order.get(i).getUserQuantity() * order.get(i).getPriceOfOrder();
                System.out.printf("| %3d | %-18s | %8d | %4d$ | %5d$ |\n", i + 1, order.get(i).getUserOrder(),
                        order.get(i).getUserQuantity(), order.get(i).getPriceOfOrder(),
                        (order.get(i).getUserQuantity() * order.get(i).getPriceOfOrder()));
            }
            System.out.println("+-----+--------------------+----------+-------+--------+");
            System.out.printf("|                                       TOTAL | %4d$ |\n", total);
            System.out.println("+-----+--------------------+----------+-------+--------+");
        }
    }

    public void shoppingForBuyer() {
        String continueOrder = "";
        boolean exit = true;
        boolean anotherOrder = true;
        int count = 0;
        int priceOfOrder = 0;

        while (anotherOrder) {
            System.out.print("List of Fruit:" +
                    "\n+-----+--------------------+-------------+-------+\n" +
                    "| No. | Fruit Name         | Origin      | Price |\n" +
                    "+-----+--------------------+-------------+-------+\n");
            for (int i = 0; i < storage.size(); i++) {
                System.out.printf("| %3d | %-18s | %-11s | %4d$ |\n", i + 1,
                        storage.get(i).name, storage.get(i).origin, storage.get(i).price);
            }

            System.out.println("+-----+--------------------+-------------+-------+\n");
            System.out.print("You selected: ");
            String userOrder = "";
            // check if food exit
            while (exit) {
                userOrder = sc.nextLine();
                for (fruitShop each : storage) {
                    if (each.getName().equalsIgnoreCase(userOrder)) {
                        exit = false;
                        count++;
                    }

                }
                if (count == 0) {
                    System.out.println("Please enter another food!");
                }

            }
            // check if food's quantity enough to order
            int userQuantity = 0;
            boolean quantityEnough = false;

            while (!quantityEnough) {
                System.out.print("Please input quantity: ");
                userQuantity = sc.nextInt();
                sc.nextLine();
                for (fruitShop each : storage) {
                    if (each.getName().equalsIgnoreCase(userOrder)) {
                        if (each.getQuantity() >= userQuantity) {
                            quantityEnough = true;
                        } else {
                            System.out.printf(" Only have %d %s left. Please try again!\n", each.getQuantity(),
                                    each.getName());
                        }
                        break;
                    }
                }

            }

            // get price of order food
            for (fruitShop each : storage) {
                if (each.getName().equalsIgnoreCase(userOrder)) {
                    priceOfOrder = each.getPrice();
                }
            }

            shopping box = new shopping(userOrder, userQuantity, priceOfOrder);
            order.add(box);

            System.out.println("Do you want to order now (Y/N)");
            while (true) {
                continueOrder = sc.nextLine();
                if (continueOrder.equalsIgnoreCase("y")) {
                    anotherOrder = true;
                    break;
                } else if (continueOrder.equalsIgnoreCase("n")) {
                    anotherOrder = false;
                    break;
                } else {
                    System.out.print("Please enter Y or N: ");
                }
            }
            System.out.print("Input your name: ");
            String userName = sc.nextLine();
            customer.put(userName, box);
        }

    }
}