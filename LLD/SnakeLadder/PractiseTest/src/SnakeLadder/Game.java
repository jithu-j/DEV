package SnakeLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> playerList = new LinkedList<>();

    Player winner;

    public Game() {
        initializeGame();
    }

    private void initializeGame(){
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {
        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);
        playerList.add(player1);
        playerList.add(player2);
    }

    public void startGame() {
        while(winner ==  null){
            //checks whose turn
            Player playerturn = findPlayerTurn();
            System.out.println("player turn is: " + playerturn.id + " current postition is: " + playerturn.currentPostition);
            //rolls dice
            int diceNumbers = dice.rollDice();

            //get the new position
            int playerNewPosition = playerturn.currentPostition + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerturn.currentPostition = playerNewPosition;

            System.out.println("player turn is: " + playerturn.id + " new position is: " + playerNewPosition);
            //Check for winning condition
            if(playerNewPosition >= board.cells.length * board.cells.length - 1 ){
                winner = playerturn;
            }
        }
        System.out.println("WINNER is: " + winner.id);
    }

    private int jumpCheck(int playerNewPosition) {
        if(playerNewPosition > board.cells.length * board.cells.length - 1){
            return playerNewPosition;
        }
        Cell cell = board.getCell(playerNewPosition);
        if(cell.jump != null && cell.jump.start == playerNewPosition){
            String jumpBy = (cell.jump.start < cell.jump.end)?"Ladder":"Snake";
            System.out.println("jump done by: "+ jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }

    private Player findPlayerTurn() {
        Player playerTurns = playerList.removeFirst();
        playerList.addLast(playerTurns);
        return playerTurns;
    }

}
