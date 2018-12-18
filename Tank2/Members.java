package com.tank2;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


class Bullet{
	int x;
	int y;

	public Bullet(int x,int y){
		this.x=x;
		this.y=y;
	}
}

class Hero extends Tank{

	Bullet bullet=null;
	public Hero(int x,int y) {
		super(x,y);
		super.setColor(Color.CYAN);
	}

	public void shotEnemy(){
		bullet=new Bullet(x,y);
		switch(this.direct){
			case 0:
				bullet=new Bullet(x+10,y);
				break;
			case 1:
				bullet=new Bullet(x+30,y+10);
				break;
			case 2:
				bullet=new Bullet(x+10,y+30);
				break;
			case 3:
				bullet=new Bullet(x,y+10);
				break;

		}
	}
}
class Tank{
	int x;
	int y;
	int  direct;//left,right,up,down
	int dimension;
	int speed;
	Color color;
	public Tank(int x,int y) {
		this.x=x;
		this.y=y;
		this.speed=10;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDirection() {
		return direct;
	}
	public void setDirection(int direct) {
		this.direct = direct;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getDimension() {
		return dimension;
	}
	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public void moveDown(){
		y+=speed;
	}
	public void moveUp(){
		y-=speed;
	}
	public void moveLeft(){
		x-=speed;
	}
	public void moveRight(){
		x+=speed;
	}





	public void drawTank(Graphics g){
		dimension=5;
		g.setColor(getColor());

		switch(getDirection()){
			case 2: 
				g.fillRect(x, y, dimension, 5*dimension);
				g.fillRect(x+3*dimension, y, dimension, 5*dimension);
				g.fillRect(x+dimension, y+2*dimension, 2*dimension, 2*dimension);
				g.fillOval(x+1*dimension, y+1*dimension, 2*dimension, 2*dimension);
				g.drawLine(x+2*dimension, y+2*dimension, x+2*dimension, y-2*dimension);
				break;
			case 3:
				g.fillRect(x, y, dimension, 5*dimension);
				g.fillRect(x+3*dimension, y, dimension, 5*dimension);
				g.fillRect(x+dimension, y+1*dimension, 2*dimension, 2*dimension);
				g.fillOval(x+1*dimension, y+2*dimension, 2*dimension, 2*dimension);
				g.drawLine(x+2*dimension, y+3*dimension, x+2*dimension, y+7*dimension);
				break;

			case 0:
				g.fillRect(x, y, 5*dimension, dimension);
				g.fillRect(x, y+3*dimension, 5*dimension, dimension);
				g.fillRect(x+2*dimension, y+dimension, 2*dimension, 2*dimension);
				g.fillOval(x+1*dimension, y+1*dimension, 2*dimension, 2*dimension);
				g.drawLine(x+3*dimension, y+2*dimension, x-2*dimension, y+2*dimension);
				break;
			case 1:
				g.fillRect(x, y, 5*dimension, dimension);
				g.fillRect(x, y+3*dimension, 5*dimension, dimension);
				g.fillRect(x+1*dimension, y+dimension, 2*dimension, 2*dimension);
				g.fillOval(x+2*dimension, y+1*dimension, 2*dimension, 2*dimension);
				g.drawLine(x+2*dimension, y+2*dimension, x+6*dimension, y+2*dimension);
				break;




		}
	}
}

class Enemy extends Tank{
	public Enemy(int x,int y) {
		super(x,y);
		super.setColor(Color.BLACK);
	}
}
