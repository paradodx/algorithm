package JUC.demo03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo01 extends Thread {
    static int ticket = 0;
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (ticket < 100) {
                    Thread.sleep(10);
                    ticket++;
                    System.out.println(getName() + " sold " + ticket + " ticket");
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
