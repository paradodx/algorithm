package JUC.demo03;

public class test01 {


    public static void main(String[] args) {
        ThreadDemo01 t1 = new ThreadDemo01();
        ThreadDemo01 t2 = new ThreadDemo01();
        ThreadDemo01 t3 = new ThreadDemo01();

        t1.setName("number 1");
        t2.setName("number 2");
        t3.setName("number 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
