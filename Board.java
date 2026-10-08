public class Board {

    static final int SIZE = 8;              // board size
    Piece[][] squares = new Piece[SIZE][SIZE];

    public Board() {
 

        char [] ordem = {'R','N','B','Q','K','B','N','R'};
        for (int j = 0; j < SIZE; j++) {
            squares[0][j] = new Piece (ordem[j], true);                          //  whites from behind
            squares[1][j] = new Piece('P', true);                           // pawns ahead
            squares[6][j] = new Piece('P', false);                          // black pawns
            squares[7][j] = new Piece (ordem[j], false);                         // blacks behind
        }

    }

    public void print(){
            for (int i = SIZE - 1; i >= 0; i--) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                if(squares[i][j] == null) System.out.print('.');
                else{
                    System.out.print(squares[i][j].symbol());
                }
            }
            System.out.print("\n");
        }

        System.out.print("  ");
        for (int j = 0; j < SIZE; j++) {
            System.out.print((char)('a' + j));
        }
        System.out.print("\n");

        }


}
