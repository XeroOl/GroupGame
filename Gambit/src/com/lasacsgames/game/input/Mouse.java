package com.lasacsgames.game.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.lasacsgames.game.Game;
import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.physics.Point;

public class Mouse implements MouseMotionListener, MouseListener
{
	public boolean mouse[] = new boolean[4];
	private Point location;
	public int scale;
public Screen screen;
	
	public Mouse(Screen s,int scale){
	this.scale = scale;
		screen = s;
		location = new Point(10,10);
	}
	public Point getLocation()
	{
		return new Point((location.x+screen.xOffSet)/scale,(location.y+screen.yOffSet)/scale);
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		location = new Point(e.getPoint());

	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		location = new Point(e.getPoint());
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		int button = e.getButton();
		if (button >= 1 && button <= 3) mouse[button] = true;

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		int button = e.getButton();
		if (button >= 1 && button <= 3) mouse[button] = false;

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

}
