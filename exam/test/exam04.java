package exam.test;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 解二元一次方程组张三的数学老师讲解了二元一次方程组的解法，二元一次方程是指含有两个未知数 (x和y)
 * 并且所含未知数的项的次数都是1的方程，两个结合在一起的共含有两个未知数的一次方程叫二元一次方程组
 * 张三觉得解方程组有些难，你能帮帮他吗?
 * 解答要求时间限制: C/C++1000ms,其他语言: 2000ms内存限制: C/C++ 256MB,
 * 输入：两行字符串，表示二元一次方程组。字符串仅包含+，-，=，x，y，以及0-9数字。方程中的系数和常数都为整数。
 * 按照一般习惯，系数为1将首略，不会存在取值为0的系数和常数项输入保证方程组合法且一定有解。
 * 输入中不含空格0<字符串长度<=10000 10000<系数和常数<=10000
 * 输出两行字符串依次为x和y的解，以”x=”和"y=”表示。输出中不含空格若解不是整数，仅需输出整数部分，舍弃小数部分，
 * 如2.5输出2，-3.2 样式：样例1 输入：2x+4y=12 x+y=5 输出:x=4 y=1
 * */
public class exam04 {

    public static int[][] parseEquations(String s1, String s2) {
        int[][] co = new int[2][3];
        parseEquation(s1, co, 0);
        parseEquation(s2, co, 1);
        return co;
    }

    public static void parseEquation(String equation, int[][] co, int index) {
        String[] paths = equation.split("=");
        String left = paths[0].replace("-", "+-");
        String right = paths[1].replace("-", "+-");
        String[] leftPath = left.split("\\+");
        String[] rightPath = right.split("\\+");
        for (String path : leftPath) {
            if (!path.isEmpty()) {
                if (path.contains("x")) {
                    co[index][0] = parseCo(path);
                } else if (path.contains("y")) {
                    co[index][1] = parseCo(path);
                }
            }
        }
        for (String path : rightPath) {
            if (!path.isEmpty()) {
                co[index][2] = parseCo(path);
            }
        }
    }

    public static int parseCo(String path) {
        if (path.equals("x") || path.equals("y")) return 1;
        else if (path.equals("-x") || path.equals("-y")) return -1;
        else return Integer.parseInt(path.replaceAll("[^0-9]", ""));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int[][] equations = parseEquations(s1, s2);
        int temp = equations[0][0] * equations[1][1] - equations[0][1] * equations[1][0];
        int x = (equations[0][2] * equations[1][1] - equations[1][2] * equations[0][1]) / temp;
        int y = (equations[0][0] * equations[1][2] - equations[1][0] * equations[0][2]) / temp;
        System.out.println("x=" + x + " y=" + y);
    }
}
