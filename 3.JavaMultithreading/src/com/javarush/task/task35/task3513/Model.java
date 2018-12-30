package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    //score, maxTile - текущий счет и максимальный вес плитки на игровом поле
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score, maxTile;
    private Stack previousStates = new Stack();//будем хранить предыдущие состояния игрового поля
    private Stack previousScores = new Stack();//будем хранить предыдущие счета
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
        this.score = 0;
        this.maxTile = 0;
    }

    //проверяет пустые плитки в массиве и заполняет ими список
    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    emptyTiles.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTiles;

    }

    //добавляет вес плитке из списка пустых плиток
    private void addTile() {
        List<Tile> tiles = getEmptyTiles();
        if (!tiles.isEmpty()) {
            int i = (int) (Math.random() * tiles.size());
            tiles.get(i).value = (Math.random() < 0.9 ? 2 : 4);

        }
    }

    //перезапуск поля с плитками
    public void resetGameTiles() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    //Сжатие плиток, таким образом, чтобы все пустые плитки были справа
    private boolean compressTiles(Tile[] tiles) {
        for (int i = 0; i < tiles.length; i++) {

            if (tiles[i].value == 0) {

                for (int j = i + 1; j < tiles.length; j++) {
                    if (tiles[j].value != 0) {
                        tiles[i].value = tiles[j].value;
                        tiles[j].value = 0;
                        return true;
                    }
                }
            }
        }

        return false;
    }

    //Слияние плиток одного номинала
    private boolean mergeTiles(Tile[] tiles) {
        boolean result = false;
        for (int i = 0; i < tiles.length; i++) {
            try {
                if (tiles[i].value > 0 && tiles[i].value == tiles[i + 1].value) {

                    tiles[i].value += tiles[i + 1].value;
                    result = true;
// Если выполняется условие слияния плиток, проверяем является ли новое значения больше максимального
// и при необходимости меняем значение поля maxTile.
                    if (tiles[i].value > maxTile) {
                        maxTile = tiles[i].value;
                    }
//Увеличиваем значение поля score на величину веса плитки образовавшейся в результате слияния.
                    score += tiles[i].value;

                    for (int j = i + 1; j < tiles.length; j++) {
                        if (j != tiles.length - 1) {
                            tiles[j].value = tiles[j + 1].value;
                        } else tiles[j].value = 0;
                    }

                }
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
        }
        return result;
    }

    public void left() {
        boolean isChange = false;
        if(isSaveNeeded) saveState(gameTiles);
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i]))
                isChange = true;
        }

        if (isChange) {
            addTile();
        }
    }

    public void rotate() {
        /*Поворачиваем массив по часовой стрелки */
        Tile[][] tempTile = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                tempTile[i][FIELD_WIDTH - 1 - j] = gameTiles[j][i];
            }
        }
        gameTiles = tempTile.clone();
    }

    public void right() {
        saveState(gameTiles);
        rotate();
        rotate();
        left();
        isSaveNeeded = true;
        rotate();
        rotate();
    }

    public void up() {
        saveState(gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        isSaveNeeded = true;
        rotate();
    }

    public void down() {
        saveState(gameTiles);
        rotate();
        left();
        isSaveNeeded = true;
        rotate();
        rotate();
        rotate();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    //возвращающий true в случае, если в текущей позиции возможно сделать ход так, чтобы состояние игрового поля изменилось. Иначе - false.
    public boolean canMove() {
        boolean result = false;

        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            for (int j = 0; j < FIELD_WIDTH - 1; j++) {
                if (getEmptyTiles().size() > 0 || gameTiles[i][j].value == gameTiles[i][j + 1].value || gameTiles[i][j].value == gameTiles[i + 1][j].value) {
                    result = true;
                }
            }
        }


        return result;
    }
    //будет сохранять текущее
    //игровое состояние и счет в стеки с помощью метода push
    private void saveState(Tile[][] gameTiles) {
        Tile[][] fieldToSave = new Tile[gameTiles.length][gameTiles[0].length];
        isSaveNeeded = false;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                fieldToSave[i][j] = new Tile(gameTiles[i][j].value);
            }
        }
        previousStates.push(fieldToSave);
        int scoreToSave = score;
        previousScores.push(scoreToSave);

    }
    //будет устанавливать текущее игровое состояние равным последнему находящемуся в стеках с помощью метода pop
    public void rollback() {
        if (!previousScores.isEmpty() && !previousStates.isEmpty()) {
            gameTiles = (Tile[][]) previousStates.pop();
            score = (int) previousScores.pop();
        }
    }

    public void randomMove(){
        int n = ((int) (Math.random() * 100)) % 4;

        if(n == 0) left();
        if(n == 1) right();
        if(n == 2) up();
        if(n == 3) down();
    }
    //будет возвращать true, в случае, если вес плиток в массиве gameTiles отличается от веса плиток в верхнем массиве стека previousStates
    public boolean hasBoardChanged(){
        Tile[][] mass = (Tile[][]) previousStates.peek();

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value != mass[i][j].value) {
                    return true;
                }
            }
        }
        return false;
    }
    //описывающий эффективность переданного хода
    //метод rollback, чтобы восстановить корректное игровое состояние
    public MoveEfficiency getMoveEfficiency(Move move){
        move.move();
        if (hasBoardChanged()){
            MoveEfficiency moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move );
            rollback();
            return moveEfficiency;

        }
        MoveEfficiency moveEfficiency = new MoveEfficiency(-1, 0, move);
        rollback();
        return moveEfficiency;
    }

    public void autoMove(){
        //Создадим локальную PriorityQueue с параметром Collections.reverseOrder() (для того, чтобы вверху очереди всегда был максимальный элемент)
        // и размером равным четырем
        PriorityQueue queue = new PriorityQueue(4, Collections.reverseOrder());
        //Заполним PriorityQueue четырьмя объектами типа MoveEfficiency (по одному на каждый вариант хода)
        queue.offer(getMoveEfficiency(this::left));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::down));
        //Возьмем верхний элемент и выполним ход связанный с ним
        MoveEfficiency moveEfficiency = (MoveEfficiency)queue.peek();
        moveEfficiency.getMove().move();
    }
}
