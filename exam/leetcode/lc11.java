package exam.leetcode;

public class lc11 {

    public static int maxArea(int[] height){
        if (height == null || height.length < 2) return 0;
        int i = 0, j = height.length - 1, area = 0;
        while (i < j){
            area = height[i] <= height[j] ?
                    Math.max(area, (j - i) * height[i++]) :
                    Math.max(area, (j - i) * height[j--]);
        }
        return area;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int area = maxArea(height);
        System.out.println(area);
    }
}
