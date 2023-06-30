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
    //Genera los bloques en la pantalla, las filas dependerán del nivel
    public void createBlocks(int filas) {
    	double randomValue = Math.random(); // Generar un número aleatorio entre 0 y 1
        blocks.clear();
        int blockWidth = 70;
        int blockHeight = 26;
        int y = Gdx.graphics.getHeight();
        //Por cada fila se generan los bloques que quepan en la pantalla
        for (int cont = 0; cont < filas; cont++) {
            y -= blockHeight + 10;
            for (int x = 5; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
            	randomValue = Math.random();
	                if (randomValue < 0.89) {
	                    // 90% de probabilidad de que sea un bloque normal
	                	//Block b = new NormalBlock();
	                	Block b = new NormalBlock(x, y, blockWidth, blockHeight);
	                	//b.templateMethod(x, y, blockWidth, blockHeight);
	                    blocks.add(b);
	                } else {
	                	if(randomValue < 0.95) {
	                		// 0.89 0.9 0.91 0.92 0.93 0.94
	                		// 5% de probabilidad de que sea un bloque especial
		                    Block sB  = new SpecialBlock(x, y, blockWidth, blockHeight);
		                    sB.selectColor();
		                	blocks.add(sB);
	                	}
	                	else {
	                		// 0.95 0.96 0.97 0.98 0.99 1
	                		// 5% de probabilidad de que sea un bloque especial
		                    Block sB2  = new SpecialBlock2(x, y, blockWidth, blockHeight);
		                    sB2.selectColor();
		                	blocks.add(sB2);
	                	}
	                    
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
    //Actualiza el bloque destruido
    public void removeDestroyedBlocks() {
        Iterator<Block> iterator = blocks.iterator();
        while (iterator.hasNext()) {
            Block block = iterator.next();
            if (block.isDestroyed()) {
                iterator.remove();
            }
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
    //getter
    public int getSize() {
    	return(blocks.size());
    }
}
