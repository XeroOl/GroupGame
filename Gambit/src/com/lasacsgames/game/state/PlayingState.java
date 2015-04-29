package com.lasacsgames.game.state;

import com.lasacsgames.game.Game;

public class PlayingState extends GameState
{
	public void handleInput(Game game)
	{
		// TODO Auto-generated method stub
	}
	
	public void update(Game game)
	{
		game.player.update();
		game.level.update();
		game.cursor.update();
	}

}
