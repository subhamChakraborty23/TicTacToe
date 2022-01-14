package entities;

public class Player {
    private int playerId;
    private String playerName;
    private char playerSymbol;
    public Player(String playerName, char playerSymbol) {
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
        if(playerSymbol == 'X'){
            this.playerId = 1;
        }else{
            this.playerId = 2;
        }
    }
    
    public int getPlayerId(){
        return this.playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

}
