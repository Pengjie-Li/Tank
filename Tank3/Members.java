package com.tank3;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


class Bullet implements Runnable{
	int x;
	int y;
	int direct;
	int speed=2;
	boolean isLive=true;

	public Bullet(int x,int y){
		this.x=x;
		this.y=y;
	}

	public Bullet(int x,int y,int direct){
		this(x,y);
		this.direct=direct;
	}
	public void run(){
		while(true){
			try{
				Thread.sleep(50);
			}catch(Exception e){
			}
			switch(direct){
				case 0:
					x-=speed;
					break;
				case 1:
					x+=speed;
					break;
				case 2:
					y-=speed;
					break;
				case 3:
					y+=speed;
					break;
			}
			if(x<0||x>500||y<0||y>500){
				isLive=false;
			       	break;
			}
			System.out.println("Bullet Position: X="+x+" Y="+y);
		}
	}
}

class Hero extends Tank{

	public Hero(int x,int y) {
		super(x,y);
		super.setColor(Color.CYAN);
	}

}
class Tank{
	int x;
	int y;
	int  direct;//left,right,up,down
	int dimension;
	int speed;
	Color color;
	Bullet bullet=null;

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


	public void shotEnemy(){
		//bullet=new Bullet(x,y);
		switch(this.direct){
			case 0:
				bullet=new Bullet( x-3*dimension, y+2*dimension,0);
				break;
			case 1:
				bullet=new Bullet(x+7*dimension, y+2*dimension,1);
				break;
			case 2:
				bullet=new Bullet(x+2*dimension, y-3*dimension,2);
				break;
			case 3:
				bullet=new Bullet(x+2*dimension, y+8*dimension,3);
				break;

		}

		Thread t=new Thread(bullet);
		t.start();
	}


	public void drawBullet(Graphics g){
				if(bullet!=null&&bullet.isLive==true) g.fillOval(bullet.x-dimension, bullet.y-dimension, 2*dimension, 2*dimension);
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
