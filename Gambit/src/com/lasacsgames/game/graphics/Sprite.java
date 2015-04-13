package com.lasacsgames.game.graphics;

public class Sprite
{
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	/*
	 * 0 - center 1 - 8 edges, starting with up 9 - 12 inner corner, bottom
	 * left, bottom right, top left, top right, 13- lone rock
	 */
	public static Sprite GRASS_SPRITE = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite VOID_SPRITE = new Sprite(16, 3, 0, SpriteSheet.tiles);
	public static Sprite[] ROCK_SPRITE = rockSprites();

	protected static Sprite[] rockSprites()
	{
		Sprite[] m = new Sprite[256];
		for (int i = 0; i < 16; i++)
		{
			for (int h = 0; h < 16; h++)
			{
				m[i + 16 * h] = new Sprite(16, i, h, SpriteSheet.rocks);
			}
		}
		return m;
	}

	public static Sprite BRICK_SPRITE = new Sprite(16, 2, 0, SpriteSheet.tiles);

	public static Sprite player_forward = new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite player_side = new Sprite(32, 1, 5, SpriteSheet.tiles);
	public static Sprite player_backward = new Sprite(32, 2, 5, SpriteSheet.tiles);

	public static Sprite player_forward_1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
	public static Sprite player_forward_2 = new Sprite(32, 0, 7, SpriteSheet.tiles);

	public static Sprite player_side_1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
	public static Sprite player_side_2 = new Sprite(32, 1, 7, SpriteSheet.tiles);

	public static Sprite player_backward_1 = new Sprite(32, 2, 6, SpriteSheet.tiles);
	public static Sprite player_backward_2 = new Sprite(32, 2, 7, SpriteSheet.tiles);

	public static Sprite bullet = new Sprite(16, 15, 15, SpriteSheet.tiles);
	public static Sprite ghost = new Sprite(16, 0, 2, SpriteSheet.tiles);

	public Sprite(int size, int x, int y, SpriteSheet sheet)
	{
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int color)
	{
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	private void setColor(int color)
	{
		for (int i = 0; i < SIZE * SIZE; i++)
		{
			pixels[i] = color;
		}
	}

	private void load()
	{
		for (int y = 0; y < SIZE; y++)
		{
			for (int x = 0; x < SIZE; x++)
			{
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}
