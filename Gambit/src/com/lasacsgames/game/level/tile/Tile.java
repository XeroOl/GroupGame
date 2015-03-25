package com.lasacsgames.game.level.tile;

import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;

public abstract class Tile {

	public int x, y;
	public Sprite sprite;
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {

	}

	public boolean solid() {
		return false;
	}

}
