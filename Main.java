public class Main {
    public static void main(String[] args) {

    // CONVENCAO: linha 0 = fileira 1 (brancas), coluna 0 = coluna 'a'.
    // Por isso o laco que desenha percorre as linhas de 7 para 0.
    int column = 8;
    int line = 8;
    Piece[][] board = new Piece[column][line];

        char [] ordem = {'R','N','B','Q','K','B','N','R'};
        for (int j = 0; j < 8; j++) {
            board[0][j] = new Piece (ordem[j], true);                          // fileira 1: whites from behind
            board[1][j] = new Piece('P', true);                               // fileira 2: pawns ahead
            board[6][j] = new Piece('P', false);                               // fileira 7: black pawns
            board[7][j] = new Piece (ordem[j], false);;                          // fileira 8: blacks behind
        }

         for (int i = 7; i >= 0; i--) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j <8; j++) {
                if(board[i][j] == null) System.out.print('.');
                else{
                    System.out.print(board[i][j].symbol());
                }
            }
            System.out.print("\n");
        }

        System.out.print("  ");
        for (int j = 0; j < 8; j++) {
            System.out.print((char)('a' + j));
        }
        System.out.print("\n");

        // testes da classe Position
        System.out.println();
        System.out.println("(0,0)  esperado true  -> " + new Position(0, 0).insideBoard());
        System.out.println("(7,7)  esperado true  -> " + new Position(7, 7).insideBoard());
        System.out.println("(8,0)  esperado false -> " + new Position(8, 0).insideBoard());
        System.out.println("(-1,0) esperado false -> " + new Position(-1, 0).insideBoard());

    }
}
