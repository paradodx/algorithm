package exam.test;

import java.util.Scanner;
/*
 * 小美数组
 * */
public class exam02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String str = scanner.next();
        int res = 0;
        for (char s : str.toCharArray()){
            if (s == 'M' || s == 'T'){
                res++;
            }
        }
        res = res + Math.min((n - res), k);
        System.out.println(res);
    }
}

