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

        ArrayList<Position> possibleMoves = new ArrayList<>();

        if(type == 'P'){
            possibleMoves = addPawnMoves(from, board, possibleMoves);    //pawns work different from others pieces
        }

        possibleMoves = addMoves(from, board, possibleMoves);

        return possibleMoves;
    }


    private ArrayList<Position>addMoves(Position from, Board board, ArrayList<Position> possibleMoves){

          int[][] directions = new int[0][];
          boolean slides = true;

        if(type == 'R'){
              directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        }else if(type == 'B'){
            directions = new int[][]{{1,1}, {-1,1}, {-1,-1}, {1,-1}};
        }else if(type == 'Q'){
            directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {-1,1}, {-1,-1}, {1,-1}};
        }else if(type == 'N'){
            directions = new int[][]{{2,1}, {1,2}, {2,-1}, {1,-2}, {-1, 2}, {-2,1}, {-2,-1}, {-1, -2}};
            slides = false;
        }else if(type == 'K'){
            directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {-1,1}, {-1,-1}, {1,-1}};
            slides = false;
        }

       for(int i=0; i<directions.length; i++){
        int []direction = directions[i];
        int line = from.line;
        int column = from.column;

        while(true){
            line += direction[0];
            column += direction[1];

            Position position = new Position(line, column);

            if(!position.insideBoard()){
                break;
            }

            Piece piece = board.squares[line][column];

            if(piece == null){
                possibleMoves.add(position);
            }else{
                if(piece.color != this.color){
                    possibleMoves.add(position); // capture
                }
                break;
            }

            if(slides == false) break;

        }
       }

        return possibleMoves;
    }


    private ArrayList<Position>addPawnMoves(Position from, Board board, ArrayList<Position> possibleMoves){

        int line = from.line;
        int column = from.column;

        Piece piece = board.squares[line+1][column];

        Position position = new Position(line + 1, column);


            if(position.insideBoard()){
                if(piece == null){
                    possibleMoves.add(position);
                }
            }

       /*  if(position.insideBoard()){
            if(color == true){
                if(board.squares[line+1][column+1] != null && board.squares[line+1][column-1].color != this.color) possibleMoves.add(new Position(line, column));
                if(board.squares[line-1][column+1] != null && board.squares[line+1][column+1].color != this.color) possibleMoves.add(new Position(line, column));
            }else if(color == false){
                if(board.squares[line+1][column-1] != null && board.squares[line-1][column+1].color != this.color) possibleMoves.add(new Position(line, column));
                if(board.squares[line-1][column-1] != null && board.squares[line-1][column-1].color != this.color) possibleMoves.add(new Position(line, column));
            }  
        }
*/

        return possibleMoves;
    }


}


