package com.lasacsgames.game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.lasacsgames.game.input.Keyboard;
import com.lasacsgames.game.state.GameState;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	private static int width = 320;
	private static int height = width * 9 / 16;
	private static int scale = 3;
	private static String title = "Lol what are we doin'?";
	private static boolean running = false;

	private Keyboard key;

	private GameState state;
	private JFrame frame;
	private Thread thread;

	private BufferedImage image = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer())
			.getData();

	public Game() {
		frame = new JFrame();
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		key = new Keyboard();
		
		addKeyListener(key);
	}

	public void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

	public void update() {

	}

	public void render() {

	}

	public static void main(String[] args) {

		Game game = new Game();

		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setResizable(false);
		game.frame.setTitle(title);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}

}
