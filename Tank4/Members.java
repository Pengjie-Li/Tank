package com.tank4;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Vector;
import java.util.*;


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
			if(x<0||x>400||y<0||y>300){
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
	int dimension=5;
	int speed;
	Color color;
	Bullet bullet=null;
	Vector<Bullet> cassette=new Vector<Bullet>();

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

		cassette.add(bullet);
		Thread t=new Thread(bullet);
		t.start();
	}

	// remove dead bullet
	public void removeDeadBullet(){
		for(int i=0;i<cassette.size();i++){
			bullet=cassette.get(i);
			if(bullet.isLive==false){
				cassette.remove(bullet);
			}
		}
	}



}

class Enemy extends Tank{
	public Enemy(int x,int y) {
		super(x,y);
		super.setColor(Color.BLACK);
	}
}
