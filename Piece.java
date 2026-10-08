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

        if(type == 'R'){
            addRookMoves(from, board, possibleMoves);
        }else if(type == 'B'){
            addBishopMoves(from, board, possibleMoves);
        }else if(type == 'Q'){
            addRookMoves(from, board, possibleMoves);
            addBishopMoves(from, board, possibleMoves);
        }else if(type == 'K'){
            addKnightMoves(from, board, possibleMoves);
        }

        return possibleMoves;
    }

    private void addRookMoves(Position from, Board board, ArrayList<Position> possibleMoves){

        
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

       int line = from.line;
       int column = from.column;


       for(int i=0; i<directions.length; i++){
        int []direction = directions[i];

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


        }
       }

    }

    private void addBishopMoves(Position from, Board board, ArrayList<Position> possibleMoves){

        int[][] directions = {{1,1}, {-1,1}, {-1,-1}, {1,-1}};

       int line = from.line;
       int column = from.column;


       for(int i=0; i<directions.length; i++){
        int []direction = directions[i];

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


        }
       }
    }

    private void addKnightMoves(Position from, Board board, ArrayList<Position> possibleMoves){
        int[][] directions = {{2,1}, {1,2}, {2,-1}, {1,-2}, {-1, 2}, {-2,1}, {-2,1}, {-1, 2}};

       int line = from.line;
       int column = from.column;


       for(int i=0; i<directions.length; i++){
        int []direction = directions[i];

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


        }
       }
    }
}
