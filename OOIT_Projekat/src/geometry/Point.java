package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {

	private int x;
	private int y;

	public Point() {

	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, boolean selected) {
		this(x, y);
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point temp = (Point) obj;
			if (this.x == temp.getX() && this.y == temp.getY()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(x + 2, y, x - 2, y);
		g.drawLine(x, y + 2, x, y - 2);
	}
	
	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void moveBy(int byX, int byY) {
		this.y = y + byY;
		this.x += byX;
		//dve notacije koje rade identicnu stvar
		
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Point) {
			Point temp = (Point)o;
			return ((int)(this.distance(0, 0) - temp.distance(0, 0))); 
		}
		return 0;
	}

	public boolean contains(int x, int y) {
		return distance(x, y) <= 2;
	}

	public boolean contains(Point p) {
		return contains(p.getX(), p.getY());
	}

	public double distance(int x, int y) {
		int dX = this.x - x;
		int dY = this.y - y;
		return Math.sqrt(dX * dX + dY * dY);
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	
}
