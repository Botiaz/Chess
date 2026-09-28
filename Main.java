public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        board.print();

         // testes da classe Position
        System.out.println();
        System.out.println("(0,0)  esperado true  -> " + new Position(0, 0).insideBoard());
        System.out.println("(7,7)  esperado true  -> " + new Position(7, 7).insideBoard());
        System.out.println("(8,0)  esperado false -> " + new Position(8, 0).insideBoard());
        System.out.println("(-1,0) esperado false -> " + new Position(-1, 0).insideBoard());

    }
}
