public class Main {
    public static void main(String[] args) {

    // CONVENCAO: linha 0 = fileira 1 (brancas), coluna 0 = coluna 'a'.
    // Por isso o laco que desenha percorre as linhas de 7 para 0.
    int column = 8;
    int line = 8;
    char[][] board = new char[column][line];
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j <8; j++) {
                 board[i][j] = '.';
            }
        }

        char[] ordem = {'R','N','B','Q','K','B','N','R'};
        for (int j = 0; j < 8; j++) {
            board[0][j] = ordem[j];                          // fileira 1: brancas de tras
            board[1][j] = 'P';                               // fileira 2: peoes brancos
            board[6][j] = 'p';                               // fileira 7: peoes pretos
            board[7][j] = Character.toLowerCase(ordem[j]);   // fileira 8: pretas de tras
        }

         for (int i = 7; i >= 0; i--) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j <8; j++) {
                 System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }

        System.out.print("  ");
        for (int j = 0; j < 8; j++) {
            System.out.print((char)('a' + j));
        }
        System.out.print("\n");

    }
}
