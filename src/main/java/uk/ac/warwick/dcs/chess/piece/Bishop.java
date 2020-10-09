
package uk.ac.warwick.dcs.chess.piece;
import uk.ac.warwick.dcs.chess.*;
public class Bishop extends ChessPiece {

    private static final long serialVersionUID = 1L;
    public Bishop(Board board, boolean isWhite, int vertical, int horizontal) {
        super(board, isWhite, (char)((int)ChessIcons.W_BISHOP + (isWhite ? 0 : 6)), vertical, horizontal);
    }

    @Override
    public Move[] getAvailableMoves() {
        availableMoves.clear();

        if(board.locationValid(this.vertical-1, this.horizontal+1)) {
            ChessPiece pieceAtIntendedLocation = board.pieceAtLocation(this.vertical-1,this.horizontal+1);
            if(pieceAtIntendedLocation == null) { //The intended locaion is empty
                Move m = new Move(this,this.vertical-1,this.horizontal+1,false);
                availableMoves.add(m);
            } else { //We have a peice at the intended lcoation
                if(pieceAtIntendedLocation.isWhite != this.isWhite) { //The piece is an opponenets piece
                    Move m = new Move(this, this.vertical-1,this.horizontal+1,true);
                    availableMoves.add(m);
                }
            }
        }

        return availableMoves.movesToArray();
    }
}
