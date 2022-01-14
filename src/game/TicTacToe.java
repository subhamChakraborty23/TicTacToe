package game;

import java.util.List;

import entities.Player;

public class TicTacToe {
    private char[][] board;
    private int[] rowSum;
    private int[] colSum;
    private int diagSum;
    private int antiDiagSum;
    private int playerTurn;
    private List<Player> players;
    private int winner;
    private boolean isGameOver;
    private int size;

    public TicTacToe(List<Player> players, int size) {
        this.players = players;
        this.size = size;
        this.board = new char[size][size];

        this.rowSum = new int[size];
        this.colSum = new int[size];
        this.diagSum = 0;
        this.antiDiagSum = 0;
        this.playerTurn = 1;
        this.winner = 0;
        this.isGameOver = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = '_';
            }
        }
    }
    //print the character board

    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println("\n");
        }
    }

    //check if the game is over
    public boolean isGameOver(){
        return isGameOver;
    }

    //check if the game is won
    public boolean isGameWon(){
        return winner != 0;
    }

    //check if the game is draw
    public boolean isGameDraw(){
        return winner == 0 && isGameOver;
    }

    //get the winner
    public int getWinner(){
        return winner;
    }

    //get the player turn
    public int getPlayerTurn(){
        return playerTurn;
    }

    //get the player id
    public int getPlayerId(int playerTurn){
        return players.get(playerTurn-1).getPlayerId();
    }

    //get the player name
    public String getPlayerName(int playerTurn){
        return players.get(playerTurn-1).getPlayerName();
    }

    //get the player symbol
    public char getPlayerSymbol(int playerTurn){
        return players.get(playerTurn-1).getPlayerSymbol();
    }

    //get the player turn
    public int getPlayerTurn(int playerId){
        for(int i=0;i<players.size();i++){
            if(players.get(i).getPlayerId() == playerId){
                return i+1;
            }
        }
        return 0;
    }

    public int move(Player player,int row,int col) throws IllegalArgumentException{
        if(row<0 || row>=size || col<0 || col>=size){
            throw new IllegalArgumentException("Invalid move");
        }
        if(board[row][col] != '_'){
            throw new IllegalArgumentException("Invalid move");
        }
        if(playerTurn != player.getPlayerId()){
            throw new IllegalArgumentException("Invalid move");
        }
        board[row][col] = player.getPlayerSymbol();
        
        playerTurn = playerTurn%2 + 1;
        int playerVal = player.getPlayerId()==1?1:-1;
        rowSum[row] += playerVal;
        colSum[col] += playerVal;
        if(row == col){
            diagSum += playerVal;
        }
        if(row == size-1-col){
            antiDiagSum += playerVal;
        }
        if(rowSum[row] == size*playerVal || colSum[col] == size*playerVal || diagSum == size*playerVal || antiDiagSum == size*playerVal){
            winner = player.getPlayerId();
            isGameOver = true;
            System.out.println("Player "+player.getPlayerId()+" won");
            return winner;
        }
        if(isGameDraw()){
            isGameOver = true;
        }
        return playerTurn;
    }

    public void play(){
        while(!isGameOver){
            printBoard();
            System.out.println("Player "+playerTurn+" turn");
            int row = 0;
            int col = 0;
            try{
                row = Integer.parseInt(System.console().readLine("Enter row: "));
                col = Integer.parseInt(System.console().readLine("Enter col: "));
            }catch(Exception e){
                System.out.println("Invalid move");
                continue;
            }
            try{
                move(players.get(playerTurn-1),row,col);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
        }
    }
    
}
