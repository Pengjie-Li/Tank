/**
 * Draw Tank on a Canvas
 * Tank 特点: 位置(x,y),朝向:上下左右，颜色:区分敌我,移动(x,y)
 * 1. New MyTank should show a Tank
 * 2. add more bullet at the same time
 */

package com.tank4;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyTank extends JFrame{
	// Frame init position
	MyPanel mp=null;
	
	public MyTank() {
		// TODO Auto-generated constructor stub
		//mp=new MyPanel(100,100,10);
		mp=new MyPanel(100,100);
		Thread t=new Thread(mp);
		t.start();

		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(400,300);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
//		mp.paint(g);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTank mt=new MyTank();
	}

}

class MyPanel extends JPanel implements KeyListener,Runnable{
	int x;
	int y;
	Tank tk=null;
	int dimension;
	public MyPanel(int x,int y){
		this.x=x;
		this.y=x;
		tk=new Hero(x,y);
		dimension=tk.dimension;
	}
	//@override paint function
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 2000, 2000);
		drawTank(g);
		drawBullet(g);
		tk.removeDeadBullet();
	}

	public void drawBullet(Graphics g){
		for(int i=0;i<tk.cassette.size();i++){
			Bullet bullet=tk.cassette.get(i);
			if(bullet!=null&&bullet.isLive==true){
				//int bulletSize=(int)(0.1*dimension);
				int bulletSize=4;
				g.fillOval(bullet.x-bulletSize/2, bullet.y-bulletSize/2,bulletSize,bulletSize);
			}
		}
	}
	public void drawTank(Graphics g){
		int x=tk.x;
		int y=tk.y;
		g.setColor(tk.getColor());

		switch(tk.getDirection()){
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


	public int getDimension() {
		return dimension;
	}
	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_DOWN||e.getKeyCode()==KeyEvent.VK_S){
			tk.moveDown();
			tk.setDirection(3);
		}
		if(e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_W){
			tk.moveUp();
			tk.setDirection(2);
		}
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A){
			tk.moveLeft();
			tk.setDirection(0);
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D){
			tk.moveRight();
			tk.setDirection(1);
		}
		if(e.getKeyCode()==KeyEvent.VK_J){
			if(tk.cassette.size()<5){
				tk.shotEnemy();
			}
		}

		this.repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run(){

		while(true){
			try{
				Thread.sleep(50);
			}catch(Exception e){

			}
			this.repaint();
		}

	}

}
