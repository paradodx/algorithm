package exam.leetcode;

public class lc79 {

    static int n, m, w;
    static char[] letters;
/*    static boolean[][] visited;*/
    public static boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        letters = word.toCharArray();
        w = word.length();
/*        visited = new boolean[n][m];*/
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                boolean res = search(board, i, j, 0);
                if (res) return true;
            }
        }
        return false;
    }

    public static boolean search(char[][] board, int i, int j, int index){
        if (index >= w) return true;
        if (i < 0 || j < 0 || i >= n || j >= m || letters[index] != board[i][j]) return false;
/*        visited[i][j] = true;*/
        boolean res = search(board, i + 1, j, index + 1) || search(board, i - 1, j, index + 1)
                || search(board, i, j + 1, index + 1) || search(board, i, j - 1, index + 1);
/*        visited[i][j] = false;*/
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},{'S', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}};
        boolean res1 = exist(board, "ABCCED");
        boolean res2 = exist(board, "ABCB");
        System.out.println(res1);
        System.out.println(res2);
    }
}
