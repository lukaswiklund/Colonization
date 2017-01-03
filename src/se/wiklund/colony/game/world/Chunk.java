package se.wiklund.colony.game.world;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Chunk {
	
	public static final int SIZE = 16;
	
	private double x, y;
	private Rectangle bounds;
	private Tile[] tiles;
	
	public Chunk(int xPos, int yPos) {
		this.x = xPos * SIZE;
		this.y = yPos * SIZE;
		bounds = new Rectangle((int) x, (int) y, SIZE, SIZE);
		tiles = new Tile[SIZE * SIZE];
		
		populateTiles();
	}
	
	private void populateTiles() {
		for (int xPos = 0; xPos < SIZE; xPos++) {
			for (int yPos = 0; yPos < SIZE; yPos++) {
				tiles[xPos + yPos * SIZE] = new Tile(xPos, yPos);
			}
		}
	}
	
	public void tick() {
		for (Tile tile : tiles) {
			tile.tick();
		}
	}
	
	public void render(Graphics2D g) {
		for (Tile tile : tiles) {
			tile.render(g);
		}
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
}
