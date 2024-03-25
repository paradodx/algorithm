package JUC.demo01;

public class ThreadDemo01 extends Thread{
    static int ticket = 0;

    @Override
    public void run() {
        while (true){
            synchronized (ThreadDemo01.class){
                if (ticket < 100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket++;
                    System.out.println(getName() + " sold " + ticket + " ticket");
                }else {
                    break;
                }
            }
        }
    }
}
