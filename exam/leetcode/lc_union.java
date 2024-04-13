package exam.leetcode;

public class lc_union {

    // leetcode 2894
    public static int differSum(int n, int m){
        int num1 = 0, num2 = 0;
        for (int i = 1; i <= n; i++){
            if (i % m != 0){
                num1 += i;
            }else {
                num2 += i;
            }
        }
        return num1 - num2;
    }

    public static void main(String[] args) {
        int res = differSum(10, 3);
        System.out.println(res);
    }
}
