package backtracking;

public class WordSearch79 {

    static int m, n;
    static char[][] board;
    static String word;
    public static boolean exist(char[][] board, String word) {
        m= board.length;
        n= board[0].length;
        WordSearch79.board = board;
        WordSearch79.word = word;

        for (int i=0;i<m;i++){
            for (int j=0; j<n; j++){
               if (dfs(i,j,0)){
                   return true;
               }
            }
        }
        return false;
    }

    private static boolean dfs(int r, int c, int i){
        if (i == word.length()) return true;

        if (r < 0 || c < 0 || r >=m || c >= n || board[r][c] != word.charAt(i))
            return false;

        boolean result;
        char o = board[r][c];
        board[r][c] = 0;

        result = dfs(r+1, c , i+1) || dfs(r, c+1, i+1) ||
                 dfs(r-1, c, i+1)  || dfs(r, c-1, i+1);

        board[r][c] = o;

        return result;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word= "ABCCEDF";
        System.out.println(exist(board, word));
    }
}
