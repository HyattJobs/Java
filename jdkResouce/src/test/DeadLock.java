package test;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLock implements Runnable{
    private ReentrantLock lock1 = new ReentrantLock();

    @Override
    public void run() {

    }
}
