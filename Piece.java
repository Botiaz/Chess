public class Piece {

    char type;      // type stands for the type of piece (rook, knight, queen...)
    boolean color;

    public Piece(char type, boolean color){
        this.type = type;
        this.color = color;
    }

    char symbol(){                  // this function returns the piece in upperCase in case of being white and lowerCase in case of being black
        if(color) return type;
        else{
            return Character.toLowerCase(type);
        }
    }
}
