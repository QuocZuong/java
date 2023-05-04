class Main extends Thread {
    public static int amount = 0;

    public static void main(String[] args) {
        Main thread = new Main(); // luong 2

        thread.start();
        System.out.println("main 1: " + amount);
        amount++;
        System.out.println("main 2: " + amount);
        amount++;
        System.out.println("main 3: " + amount);
        amount++;
        System.out.println("main 4: " + amount);
        amount++;
        System.out.println("main 5: " + amount);
        amount++;
        System.out.println("main 6: " + amount);

    }

    // 012 021 102 112
    public void run() {
        System.out.println("run 1: " + amount);
        amount++;
        System.out.println("run 2: " + amount);

        amount++;
        System.out.println("run 3: " + amount);

        amount++;
        System.out.println("run 4: " + amount);

        amount++;

        System.out.println("run 5: " + amount);
        amount++;

        System.out.println("run 6: " + amount);

        System.out.println("run 7: " + amount);
    }
}
