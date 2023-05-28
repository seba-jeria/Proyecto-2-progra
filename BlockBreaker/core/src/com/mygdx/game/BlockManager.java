package com.mygdx.game;

import java.util.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class BlockManager {
    private ArrayList<Block> blocks;
    private Colisiones colision;
    public BlockManager() {
        blocks = new ArrayList<>();
        colision = new Colisiones();
    }
    //Crea el bloque
    public void createBlocks(int filas) {
    	double randomValue = Math.random(); // Generar un número aleatorio entre 0 y 1
        blocks.clear();
        int blockWidth = 70;
        int blockHeight = 26;
        int y = Gdx.graphics.getHeight();
        for (int cont = 0; cont < filas; cont++) {
            y -= blockHeight + 10;
            for (int x = 5; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
            	randomValue = Math.random();
	                if (randomValue < 0.95) {
	                    // 95% de probabilidad de que sea un bloque normal
	                    blocks.add(new NormalBlock(x, y, blockWidth, blockHeight));
	                } else {
	                    // 5% de probabilidad de que sea un bloque especial
	                    blocks.add(new SpecialBlock(x, y, blockWidth, blockHeight));
	                }
            }
        }
    }
    //Dibuja el bloque
    public void drawBlocks(ShapeRenderer shape) {
        for (Block block : blocks) {
            block.draw(shape);
        }
    }
    //Chequea la colision de la bola con el bloque
    public void checkCollision(PingBall ball) {
        for (Block block : blocks) {
        	if(colision.blockBall(block, ball)) {
        		ball.checkCollision(block);
        		block.checkCollition(ball);
        	}
        }
    }
    //Remueve el bloque destruido
    public void removeDestroyedBlocks() {
        Iterator<Block> iterator = blocks.iterator();
        while (iterator.hasNext()) {
            Block block = iterator.next();
            if (block.isDestroyed()) {
                iterator.remove();
            }
        }
    }
    //getter
    public int getSize() {
    	return(blocks.size());
    }
    //Array de Block
    public ArrayList<Block> getBlocks() {
        return blocks;
    }
}
