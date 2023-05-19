package SnakeLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell [][] cells;


    public Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
        initializeCells(boardSize);
        addSnakesLadders(numberOfSnakes, numberOfLadders);
    }

    private void addSnakesLadders(int numberOfSnakes, int numberOfLadders) {
        while(numberOfSnakes > 0){
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length-1);
            if(snakeTail >= snakeHead){
                continue;
            }

            Jump snakeObj = new Jump();
            snakeObj.start = snakeHead;
            snakeObj.end = snakeTail;

            Cell cell = getCell(snakeHead);
            cell.jump = snakeObj;

            numberOfSnakes--;
        }

        while(numberOfLadders > 0){
            int ladderstart = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length-1);
            int ladderend = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length-1);
            if(ladderstart >= ladderend){
                continue;
            }

            Jump ladderObj = new Jump();
            ladderObj.start = ladderstart;
            ladderObj.end = ladderend;

            Cell cell = getCell(ladderstart);
            cell.jump = ladderObj;

            numberOfLadders--;
        }
    }

    Cell getCell(int playerPosition) {
        int boardRow = playerPosition/ cells.length;
        int boardColumn = (playerPosition % cells.length);
        return cells[boardRow][boardColumn];
    }


    private void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++){
            for (int j = 0; j<boardSize;j++){
                Cell cellobj = new Cell();
                cells[i][j] = cellobj;
            }
        }
    }
}
