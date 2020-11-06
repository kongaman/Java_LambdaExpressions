public class Main {

    public static void main(String[] args) {
        new Thread(new CodeToRun()).start();

        //or

        new Thread(new Runnable() {
            public void run() {
                System.out.println("Printing from the Runnable2");
            }
        }).start();

        // lambda

        new Thread(() -> System.out.println("Printing from the Runnable Lambda")).start();

        // lambda multiple statements

        new Thread(() -> {
            System.out.println("Printing from the Runnable Lambda - Line1");
            System.out.println("Line2");
            System.out.println("Line3");
        }).start();

    }

}

class CodeToRun implements Runnable {

    @Override
    public void run() {
        System.out.println("Printing from the Runnable");
    }

}