package com.lasacsgames.game.state;

import com.lasacsgames.game.Game;

public abstract class GameState {

	public abstract void handleInput(Game game);

	public abstract void update(Game game);
}
