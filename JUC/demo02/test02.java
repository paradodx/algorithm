package JUC.demo02;

public class test02 {


    public static void main(String[] args) {
        ThreadDemo02 t = new ThreadDemo02();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
