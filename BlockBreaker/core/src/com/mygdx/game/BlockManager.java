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
	
	                if (randomValue < 0.7) {
	                    // 950% de probabilidad de que sea un bloque normal
	                    blocks.add(new NormalBlock(x, y, blockWidth, blockHeight));
	                } else {
	                    // 5% de probabilidad de que sea un bloque especial
	                    blocks.add(new SpecialBlock(x, y, blockWidth, blockHeight));
	                }
            }
        }
    }

    public void updateBlocks(float deltaTime) {
        for (Block block : blocks) {
            // Actualizar la lógica de los bloques (si es necesario)
        }
    }

    public void drawBlocks(ShapeRenderer shape) {
        for (Block block : blocks) {
            block.draw(shape);
        }
    }

    public void checkCollision(PingBall ball) {
    	
        for (Block block : blocks) {
        	if(colision.blockBall(block, ball)) {
        		ball.checkCollision(block);
        		block.checkCollition(ball);
        	}
        }
    }

    public void removeDestroyedBlocks() {
        Iterator<Block> iterator = blocks.iterator();
        while (iterator.hasNext()) {
            Block block = iterator.next();
            if (block.isDestroyed()) {
                iterator.remove();
            }
        }
    }
    public int getSize() {
    	return(blocks.size());
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    // Otros métodos de utilidad, getters y setters si es necesario
}
