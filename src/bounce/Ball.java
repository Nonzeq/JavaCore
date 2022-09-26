package bounce;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {
	
	Color color;
	private static final int XSIZE = 20;
	private static final int YSIZE = 20;
	private double x = 0;
	private double y = 0;
	private double dx = 3;
	private double dy = 3;
	
	public void move(Rectangle2D bounds) {
		
		this.x += this.dx;
		
		this.y += this.dy;
		
		if(this.x < bounds.getMinX()) {
			this.x = bounds.getMinX();
			this.dx = -this.dx;
		}
		if(this.x + Ball.XSIZE >= bounds.getMaxX()) {
			this.x = bounds.getMaxX() - Ball.XSIZE;
			this.dx = -this.dx;
			
		}
		
		if(this.y < bounds.getMinY()) {
			this.y = bounds.getMinY();
			this.dy = -this.dy;
		}
		if(this.y + Ball.YSIZE >= bounds.getMaxY()) {
			this.y = bounds.getMaxY() - Ball.YSIZE;
			this.dy = -this.dy;
		}
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	public Ellipse2D getShape() {
		return new Ellipse2D.Double(this.x, this.y, Ball.XSIZE, Ball.YSIZE);
	}
}
