import java.util.ArrayList;

public class Piece {

    char type;      // type stands for the type of piece (rook, knight, queen...)
    boolean color;

    public Piece(char type, boolean color){
        this.type = type;
        this.color = color;
    }

    char symbol(){                  //returns the piece in upperCase in case of being white and lowerCase in case of being black
        if(color) return type;
        else{
            return Character.toLowerCase(type);
        }
    }

    ArrayList<Position> moves(Position from, Board board){
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

       int line = from.line;
       int column = from.column;

       while(true){
        line = line + 1;
        if(!new Position(line, column).insideBoard()) break;       // the square exists?
        if(board.squares[line][column] != null){                   // is the square free?
            if(this.color != board.squares[line][column].color){   // capturing
                System.out.println("(" + line + "," +  column + ")");
            }
            break;
        }
        System.out.println("(" + line + "," +  column + ")");
       }

        return new ArrayList<>();
    }
}
