package exam.test;

import java.util.*;

public class t {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入的方程组
        String equation1 = scanner.nextLine();
        String equation2 = scanner.nextLine();

        // 解析方程组
        int[][] coefficients = parseEquations(equation1, equation2);

        // 计算行列式的值
        int determinant = coefficients[0][0] * coefficients[1][1] - coefficients[0][1] * coefficients[1][0];

        // 计算 x 和 y 的值
        int x = (coefficients[1][1] * coefficients[0][2] - coefficients[0][1] * coefficients[1][2]) / determinant;
        int y = (coefficients[0][0] * coefficients[1][2] - coefficients[1][0] * coefficients[0][2]) / determinant;

        // 输出结果
        System.out.println("x=" + x + " y=" + y);

        scanner.close();
    }

    // 解析方程组，返回系数矩阵
    private static int[][] parseEquations(String equation1, String equation2) {
        int[][] coefficients = new int[2][3]; // 系数矩阵

        parseEquation(equation1, coefficients, 0); // 解析第一条方程
        parseEquation(equation2, coefficients, 1); // 解析第二条方程

        return coefficients;
    }

    // 解析方程，将系数和常数项存入系数矩阵中
    private static void parseEquation(String equation, int[][] coefficients, int index) {
        String[] parts = equation.split("=");

        String left = parts[0].replaceAll("-", "+-");
        String right = parts[1].replaceAll("-", "+-");

        String[] leftParts = left.split("\\+");
        String[] rightParts = right.split("\\+");

        for (String part : leftParts) {
            if (!part.isEmpty()) {
                if (part.contains("x")) {
                    coefficients[index][0] = parseCoefficient(part);
                } else if (part.contains("y")) {
                    coefficients[index][1] = parseCoefficient(part);
                }
            }
        }

        for (String part : rightParts) {
            if (!part.isEmpty()) {
                coefficients[index][2] = parseCoefficient(part);
            }
        }
    }

    // 解析方程中的系数
    private static int parseCoefficient(String term) {
        if (term.equals("x") || term.equals("y")) {
            return 1;
        } else if (term.equals("-x") || term.equals("-y")) {
            return -1;
        } else {
            return Integer.parseInt(term.replaceAll("[^0-9]", ""));
        }
    }
}

