package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private Model model;
    private View view;
    private static final int WINNING_TILE = 2048;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }

    public Tile[][] getGameTiles(){
        return model.getGameTiles();
    }

    public int getScore(){
        return model.score;
    }
    //позволит вернуть игровое поле в начальное состояние
    public void resetGame(){
        model.score = 0;
        view.isGameLost = false;
        view.isGameWon = false;
        model.resetGameTiles();
    }
    //обрабатываем пользовательский ввод
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_ESCAPE){
            resetGame();
        }
        if(!model.canMove()){
            view.isGameLost = true;
        }
        if(!view.isGameLost && !view.isGameWon) {
            if (keyCode == KeyEvent.VK_LEFT) {
                model.left();
            }
            if(keyCode == KeyEvent.VK_RIGHT){
                model.right();
            }
            if(keyCode == KeyEvent.VK_UP){
                model.up();
            }
            if(keyCode == KeyEvent.VK_DOWN){
                model.down();
            }
            if(keyCode == KeyEvent.VK_Z){
                model.rollback();
            }
            if(keyCode == KeyEvent.VK_R){
                model.randomMove();
            }
            if(keyCode == KeyEvent.VK_A){
                model.autoMove();
            }
        }

        if(model.maxTile == WINNING_TILE){
            view.isGameWon = true;
        }

        view.repaint();
    }

    public View getView() {
        return view;
    }
}
