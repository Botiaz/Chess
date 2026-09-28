public class Position {

    int line;
    int column;

    public Position(int line, int column){
        this.line = line;
        this.column = column;
    }

    boolean insideBoard(){
        if(line < 0 || column < 0 || line > 7 || column > 7){
            return false;
        }
        return true;
    }
}
