package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class BlockBreakerGame extends ApplicationAdapter {
    private OrthographicCamera camera;
	private SpriteBatch batch;	   
	private BitmapFont font;
	private ShapeRenderer shape;
	private PingBall ball;
	private Paddle pad;
	private BlockManager blockManager;
	private int vidas;
	private int nivel;
	private Colisiones colision;
	private int xSpeedBall;
	private int ySpeedBall;
	private int levelSpeed;
		@Override
		public void create () {	
			camera = new OrthographicCamera();
		    camera.setToOrtho(false, 800, 480);
		    batch = new SpriteBatch();
		    font = new BitmapFont();
		    font.getData().setScale(3, 2);
		    nivel = 1;
		    blockManager = new BlockManager();
		    blockManager.createBlocks(nivel+2);
		    colision = new Colisiones();
		    xSpeedBall = 5;
		    ySpeedBall = 7;
		    levelSpeed = 5;
		    shape = new ShapeRenderer();
		    ball = new PingBall(Gdx.graphics.getWidth()/2-10, 41, 10, 5, 7, true);
		    pad = new Paddle(Gdx.graphics.getWidth()/2-50,40,100,10);
		    vidas = 5;   
		}
		public void dibujaTextos(PingBall b) {
			//actualizar matrices de la cámara
			camera.update();
			//actualizar 
			batch.setProjectionMatrix(camera.combined);
			batch.begin();
			//dibujar textos
			//font.draw(batch, "Puntos: " + b.getPuntaje()+"|| xVel: "+b.getXSpeed()+" - yVel: "+b.getYSpeed(), 10, 50);
			//font.draw(batch, "Puntos: " + b.getPuntaje()+"|| xVel: "+pad.getX()+" - yVel: "+pad.getY(), 10, 25);
			font.draw(batch, "Puntos: " + b.getPuntaje(), 10, 25);
			font.draw(batch, "Nivel: " + nivel, 350, 25);
			font.draw(batch, "Vidas: " + vidas, Gdx.graphics.getWidth()-20, 25);
			batch.end();
		}	
		@Override
		public void render () {
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); 		
	        shape.begin(ShapeRenderer.ShapeType.Filled);
	        pad.draw(shape);
	        xSpeedBall = ball.getXSpeed();
        	ySpeedBall = ball.getYSpeed();
	        // monitorear inicio del juego
	        if (ball.estaQuieto()) {
	        	ball.setXY(pad.getX()+pad.getWidth()/2-5, pad.getY()+pad.getHeight()+11);
	        	if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) ball.setEstaQuieto(false);
	        }else ball.update();
	        //verificar si se fue la bola x abajo
	        if (ball.getY()<0) {
	        	vidas--;
	        	int puntaje = ball.getPuntaje();
	        	pad.acelerar();
	        	xSpeedBall = levelSpeed;
	         	ySpeedBall = levelSpeed+2;
	        	ball = new PingBall(pad.getX()+pad.getWidth()/2-5, pad.getY()+pad.getHeight()+11, 10, xSpeedBall, ySpeedBall, true);
	        	ball.setPuntaje(puntaje);
	        }
	        // verificar game over
	        if (vidas<=0) {
	        	vidas = 3;
	        	nivel = 1;
	        	levelSpeed = 5;
	        	ball = new PingBall(pad.getX()+pad.getWidth()/2-5, pad.getY()+pad.getHeight()+11, 10, 5, 7, true);
	        	pad = new Paddle(Gdx.graphics.getWidth()/2-50,40,100,10);
	        	ball.setPuntaje(0);
	        	blockManager.createBlocks(nivel+2);
	        	//ball = new PingBall(pad.getX()+pad.getWidth()/2-5, pad.getY()+pad.getHeight()+11, 10, 5, 7, true);	        	
	        }
	        // verificar si el nivel se terminó
	        if (blockManager.getSize() == 0) {
	        	nivel++;
	        	blockManager.createBlocks(nivel+2);
	        	ball.acelerar();
	        	pad.ralentizar();
	        	levelSpeed += 2;
	        	xSpeedBall = levelSpeed;
	         	ySpeedBall = levelSpeed+2;
	        	int puntaje = ball.getPuntaje();
	        	ball = new PingBall(pad.getX()+pad.getWidth()/2-5, pad.getY()+pad.getHeight()+11, 10, xSpeedBall, ySpeedBall, true);
	        	ball.setPuntaje(puntaje);
	        }    	
	        //dibujar bloques
	        blockManager.drawBlocks(shape);
	        // actualizar estado de los bloques 
	        blockManager.checkCollision(ball);	        
	        blockManager.removeDestroyedBlocks();
	        if (colision.paddleBall(pad, ball)) {
	        	ball.checkCollision(pad);
	        }
	        ball.draw(shape);
	        shape.end();
	        dibujaTextos(ball);
		}
		@Override
		public void dispose () {
		}
	}
