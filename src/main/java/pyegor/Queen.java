package pyegor;

public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        Rook rook = new Rook(this.color);
        Bishop bishop = new Bishop(this.color);

        return rook.canMoveToPosition(chessBoard, line, column, toLine, toColumn) ||
               bishop.canMoveToPosition(chessBoard, line, column, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}