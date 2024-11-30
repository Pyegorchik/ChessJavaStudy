package pyegor;

public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;

        if (Math.abs(line - toLine) != Math.abs(column - toColumn)) return false;

        int deltaX = (toLine > line) ? 1 : -1;
        int deltaY = (toColumn > column) ? 1 : -1;

        for (int i = 1; i < Math.abs(toLine - line); i++) {
            if (chessBoard.board[line + i * deltaX][column + i * deltaY] != null) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}