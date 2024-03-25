package JUC.demo02;

public class ThreadDemo02 implements Runnable{
    int ticket = 0;

    @Override
    public void run() {
        while (true){
            if (method()) break;
        }
    }

    private synchronized boolean method() {
        if (ticket == 100){
            return true;
        }else {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ticket++;
            System.out.println(Thread.currentThread().getName() + "正在卖" + ticket + "张票！");
        }
        return false;
    }
}
