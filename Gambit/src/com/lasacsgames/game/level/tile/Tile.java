package com.lasacsgames.game.level.tile;

import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;

public abstract class Tile {

	public int x, y; // X and Y are unused;
	public Sprite sprite;

	public static Tile VOID_TILE = new VoidTile(Sprite.VOID_SPRITE);
	public static Tile GRASS_TILE = new GrassTile(Sprite.GRASS_SPRITE);
	public static Tile[] ROCK_TILE = { new RockTile(Sprite.ROCK_SPRITE[0]),
			new RockTile(Sprite.ROCK_SPRITE[1]),
			new RockTile(Sprite.ROCK_SPRITE[2]),
			new RockTile(Sprite.ROCK_SPRITE[3]),
			new RockTile(Sprite.ROCK_SPRITE[4]),
			new RockTile(Sprite.ROCK_SPRITE[5]),
			new RockTile(Sprite.ROCK_SPRITE[6]),
			new RockTile(Sprite.ROCK_SPRITE[7]),
			new RockTile(Sprite.ROCK_SPRITE[8]),
			new RockTile(Sprite.ROCK_SPRITE[9]),
			new RockTile(Sprite.ROCK_SPRITE[10]),
			new RockTile(Sprite.ROCK_SPRITE[11]),
			new RockTile(Sprite.ROCK_SPRITE[12]),
			new RockTile(Sprite.ROCK_SPRITE[13])};
	public static Tile BRICK_TILE = new BrickTile(Sprite.BRICK_SPRITE);

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

	public boolean solid() {
		return false;
	}

}
