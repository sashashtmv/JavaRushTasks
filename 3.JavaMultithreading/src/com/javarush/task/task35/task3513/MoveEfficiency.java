package com.javarush.task.task35.task3513;


//класс MoveEfficiency, описывающий эффективность хода
public class MoveEfficiency implements Comparable<MoveEfficiency>{
    private int numberOfEmptyTiles;//количество пустых плиток
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency o) {
        int dif = Integer.compare(this.numberOfEmptyTiles, o.numberOfEmptyTiles);
        if (dif == 0){
            dif = Integer.compare(this.score, o.score);
        }
        return dif;
    }
}
