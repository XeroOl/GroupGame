package com.lasacsgames.game.entity;

import java.util.Random;

import com.lasacsgames.game.level.Level;
import com.lasacsgames.game.physics.Point;
import com.lasacsgames.game.physics.Vector;

public abstract class Entity {

	public Point location;
	public Vector vector;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();

	public void update() {

	}

	public void render() {

	}

	public void remove() {
		// Remove from level
		removed = true;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Level getLevel() {
		return level;
	}
}
