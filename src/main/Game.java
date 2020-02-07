package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

	private boolean running = false;
	
	private Thread thread;
	private Display display;
	
	private BufferStrategy bs;
	private Graphics g;
	
	public Game() {
		
	}

	private void init() {
		
		display = new Display();
		display.canvas.createBufferStrategy(3);
		
	}
	
	private void tick() {
		
	}
	
	private void render() {
		bs = display.canvas.getBufferStrategy();
		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, display.screenDimensions.width, display.screenDimensions.height);
		// Draw Here!
		
		g.fillRect(0, 0, display.screenDimensions.width, display.screenDimensions.height);
		
		// End Drawing!
		bs.show();
		g.dispose();
	}
	
	@Override
	public void run() {

		init();

		while(running) {
			tick();
			render();
		}
		
		stop();
		
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}