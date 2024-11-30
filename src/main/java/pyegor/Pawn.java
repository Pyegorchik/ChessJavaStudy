package pyegor;


public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;

        int direction = color.equals("White") ? 1 : -1;
        int startLine = color.equals("White") ? 1 : 6;

        if (column == toColumn) { // Move forward
            if (line + direction == toLine && chessBoard.board[toLine][toColumn] == null) {
                return true;
            }
            if (line == startLine && line + 2 * direction == toLine && chessBoard.board[toLine][toColumn] == null) {
                return chessBoard.board[line + direction][toColumn] == null;
            }
        } else if (Math.abs(column - toColumn) == 1 && line + direction == toLine) { // Attack
            return chessBoard.board[toLine][toColumn] != null &&
                   !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}