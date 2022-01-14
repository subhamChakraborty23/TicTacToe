import java.util.ArrayList;
import java.util.List;

import entities.Player;
import game.TicTacToe;

public class App {
    public static void main(String[] args) throws Exception {
        Player player1 = new Player("Player 1", 'X');
        Player player2 = new Player("Player 2", 'O');

        List<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);

        TicTacToe ticTacToe = new TicTacToe(players, 3);
        ticTacToe.play();

    }
}
