package pyegor;

public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверка: начальная и конечная позиции совпадают
        if (line == toLine && column == toColumn) return false;

        // Проверка: ход не по прямой линии
        if (line != toLine && column != toColumn) return false;

        // Проверка: на конечной позиции своя фигура
        if (chessBoard.board[toLine][toColumn] != null 
            && chessBoard.board[toLine][toColumn].getColor().equals(color)) {
            return false;
        }

        // Проверка: наличие препятствий на пути
        if (line == toLine) {
            int step = (toColumn > column) ? 1 : -1;
            for (int i = column + step; i != toColumn; i += step) {
                if (chessBoard.board[line][i] != null) return false;
            }
        } else { 
            int step = (toLine > line) ? 1 : -1;
            for (int i = line + step; i != toLine; i += step) {
                if (chessBoard.board[i][column] != null) return false;
            }
        }

        return true;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
