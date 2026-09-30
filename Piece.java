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

        for(int i=0; i<directions.length; i++){
            System.out.println("direcao " + i + ": linha " + directions[i][0] + ", coluna " + directions[i][1]);
        }

       int line = from.line;
       int column = from.column;

       while(true){
        line = line + 1;
        if(new Position(line, column).insideBoard()){
            System.out.println("(" + line + "," +  column + ")");
        }else{
            break;
        }
       }

       board.squares[line][column] != null;

        return new ArrayList<>();
    }
}
