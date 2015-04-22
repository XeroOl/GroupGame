package com.lasacsgames.game.entity.mob;

import com.lasacsgames.game.level.Level;

public class GhostEnemy extends Creature
{

	public GhostEnemy(int x, int y, Level level)
	{
		this.level = level;
		setLocation(x, y);
	}


	@Override
	public void update()
	{
		// TODO Auto-generated method stub
		
	}
}
