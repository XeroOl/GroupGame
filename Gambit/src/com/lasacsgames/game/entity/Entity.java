package com.lasacsgames.game.entity;

import com.lasacsgames.game.graphics.Sprite;
import com.lasacsgames.game.level.Level;
import com.lasacsgames.game.physics.Point;

public abstract class Entity {

	Point location;
	Level level;
	Sprite sprite;
	private boolean removed = false;
	
	public boolean isRemoved() {
		return removed;
	}
}
