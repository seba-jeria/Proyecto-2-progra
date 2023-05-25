package com.mygdx.game;

import java.util.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class BlockManager {
    private ArrayList<Block> blocks;

    public BlockManager() {
        blocks = new ArrayList<>();
    }

    public void createBlocks(int filas) {
        blocks.clear();
        int blockWidth = 70;
        int blockHeight = 26;
        int y = Gdx.graphics.getHeight();

        for (int cont = 0; cont < filas; cont++) {
            y -= blockHeight + 10;
            for (int x = 5; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
                blocks.add(new Block(x, y, blockWidth, blockHeight));
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
            ball.checkCollision(block);
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
