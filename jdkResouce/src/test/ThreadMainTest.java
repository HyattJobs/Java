package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadMainTest {
    public static void main(String[] args) {
/*        // 创建task
        Runnable printA = new PrintChar('a', 100);  // Runnable 改成 PrintChar 也可以
        Runnable printB = new PrintChar('b', 100);  // Runnable 改成 PrintChar 也可以
        Runnable print100 = new PrintNum(100);  // Runnable 改成 PrintNum 也可以
        // 创建线程
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);
        // 启动线程
        thread1.start();
        thread2.start();
        thread3.start();*/
        // Create a fixed thread pool with maximum three threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // Submit runnable tasks to the executor
        executor.execute(new PrintChar('a', 100));
        executor.execute(new PrintChar('b', 100));
        executor.execute(new PrintNum(100));
        // Shut down the executor
        executor.shutdown();
    }


}
// 打印指定次数字符的 task
class PrintChar implements Runnable {
    private char charToPrint; // The character to print
    private int times; // The number of times to repeat

    /**
     * Construct a task with a specified character and number of
     * times to print the character
     */
    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
    }

    @Override
    /** Override the run() method to tell the system
     * what task to perform
     */
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.print(charToPrint);
        }
    }
}


// The task class for printing numbers from 1 to n for a given n
class PrintNum implements Runnable {
    private int lastNum;

    /**
     * Construct a task for printing 1, 2, ..., n
     */
    public PrintNum(int n) {
        lastNum = n;
    }

    @Override
    /** Tell the thread how to run */
    public void run() {
        for (int i = 1; i <= lastNum; i++) {
            System.out.print(" " + i);
        }
    }
}
