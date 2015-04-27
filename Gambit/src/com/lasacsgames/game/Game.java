package com.lasacsgames.game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.lasacsgames.game.entity.mob.Player;
import com.lasacsgames.game.entity.particle.CrossHair;
import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.input.Keyboard;
import com.lasacsgames.game.input.Mouse;
import com.lasacsgames.game.level.Level;
import com.lasacsgames.game.level.OrganicRandomizedLevel;
import com.lasacsgames.game.state.GameState;
import com.lasacsgames.game.state.PlayingState;

public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;

	private static int width = 320;
	private static int height = width * 9 / 16;
	private static int scale = 3;
	private static String title = "Lol what are we doin'?";
	private static boolean running = false;

	public Player player;
	public Level level;

	private Keyboard key;
	private Mouse mouse;
	private Screen screen;
	private CrossHair cursor;

	private GameState state;
	private JFrame frame;
	private Thread thread;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public Game()
	{
		frame = new JFrame();
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		level = new OrganicRandomizedLevel(64, 64);
		screen = new Screen(width, height);
		state = new PlayingState();
		key = new Keyboard();
		mouse = new Mouse(screen, scale);
		cursor = new CrossHair(mouse);

		player = new Player(key, mouse, level);
		player.spawnRandomly();

		addKeyListener(key);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}

	public void start()
	{
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
		requestFocus();
	}

	public void stop()
	{
		running = false;
		try
		{
			thread.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void run()
	{
		final double ns = 1000000000.0;
		final double MS_PER_UPDATE = 1.0 / 60.0;
		double previous = System.nanoTime() / ns;
		double lag = 0.0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		while (running)
		{
			double current = System.nanoTime() / ns;
			double elapsed = current - previous;
			previous = current;
			lag += elapsed;

			while (lag >= MS_PER_UPDATE)
			{
				update();
				updates++;
				lag -= MS_PER_UPDATE;
			}

			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				frame.setTitle(title + "  |  " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}

		}
	}

	public void update()
	{
		key.update();
		state.update(this);
	}

	public void render()
	{
		BufferStrategy bs = getBufferStrategy();
		if (bs == null)
		{
			createBufferStrategy(3);
			return;
		}

		screen.clear();
		int xScroll = (int) player.location.x - screen.width / 2;
		int yScroll = (int) player.location.y - screen.height / 2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		cursor.render(screen);
		for (int i = 0; i < pixels.length; i++)
		{
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args)
	{
		Game game = new Game();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.add(game);
		game.frame.setResizable(false);
		game.frame.pack();
		game.frame.setTitle(title);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.frame.setCursor(game.frame.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new java.awt.Point(0, 0), "null"));
		game.start();
	}

}
