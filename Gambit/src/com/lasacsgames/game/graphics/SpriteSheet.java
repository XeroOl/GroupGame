package com.lasacsgames.game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private String path;
	public final int SIZE;
	public BufferedImage myImage;

	public static SpriteSheet tiles = new SpriteSheet("/textures/spritesheet.png", 256);


	public SpriteSheet(String path, int size) {
		this.path = path;
		SIZE = size;
		load();
	}

	public void load() {
		try {
			myImage = ImageIO.read(SpriteSheet.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
