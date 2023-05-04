public class Knight_Tour {
    public static void main(String[] args) {
        int chessBoard[][] = new int[][] {
                { -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1 } };
        putKnight(0, chessBoard, 0, 0);
        printChessBoard(chessBoard);
    }

    public static boolean putKnight(int count, int board[][], int startX, int startY) {
        // Starting point
        if (count == 0) {
            board[startX][startY] = 0;
            count++;
        }

        // If the knight is move to all over the cells. Stop the recursion
        if (count >= 64 && FullBoard(board)) {
            return true;
        }
        int i, j;
        // Start with the 2 for to explore the chestboard easier
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                // Check if the next move is valid or not
                if (isNextMoveValid(board, startX, startY, i, j)) {
                    board[i][j] = count;
                    // NOTE: The Knight start exploring this path further (Exploring)
                    // Recursion
                    if (putKnight(count + 1, board, i, j)) {
                        return true;
                    }
                    // NOTE: If the knight can't move to all the cell in the board. The knight will
                    // backtracking 1 cell and start exploring again. (Backtracking)
                    board[i][j] = -1;
                }
            }
        }
        return false;
    }

    public static boolean isNextMoveValid(int board[][], int x, int y, int nextX, int nextY) {
        // Next move must be different from the current position
        if (x == nextX && y == nextY) {
            return false;
        }
        // TODO: If in the next (x,y) has been occupied return false
        if (board[nextX][nextY] != -1) {
            return false;
        }
        // The next move must be an L path in the chest board. If not return false
        if (!(absolute(nextX - x) == 2 && absolute(nextY - y) == 1
                || absolute(nextX - x) == 1 && absolute(nextY - y) == 2)) {
            return false;
        }

        return true;
    }

    // Check if the knight move to over the cell (Halmilton Path)
    public static boolean FullBoard(int board[][]) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == -1)
                    return false;
            }
        }
        return true;
    }

    public static void printChessBoard(int[][] chessBoard) {
        int len = chessBoard.length, ElementLen;
        for (int i = 0; i < len; i++) {
            ElementLen = chessBoard[i].length;
            for (int j = 0; j < ElementLen; j++) {
                if (chessBoard[i][j] < 10)
                    System.out.print(" ");
                System.out.print(chessBoard[i][j]);
                if (j < ElementLen - 1) {
                    System.out.print(" ");

                }
            }
            System.out.println();
        }
    }

    public static int absolute(int x) {
        if (x < 0)
            return -x;
        return x;
    }
}
