package test;

public class MapTest {
    public static String apple = "apple";
    public static String orange = "orange";
    public static void main(String[] args) {

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(apple);
            }
        };
        Thread thread1 = new Thread(runnable1);
        thread1.start();

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println(orange);
                System.out.println(orange);
            }
        };
        Thread thread2 = new Thread(runnable2);
        thread2.start();
    }
}


