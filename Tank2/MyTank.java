/**
 * Draw Tank on a Canvas
 * Tank 特点: 位置(x,y),朝向:上下左右，颜色:区分敌我,移动(x,y)
 * 1. New MyTank should show a Tank
 * 2. 
 */

package com.tank2;
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
		mp=new MyPanel(100,100,10);

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

class MyPanel extends JPanel implements KeyListener{
	int xx;
	int yy;
	int dimension=5;// dimension of Tank
	Tank tk=null;
	public MyPanel(int x,int y){
		this.xx=x;
		this.yy=x;
		tk=new Hero(x,y);
	}
	public MyPanel(int x,int y,int dimension){
		this(x,y);
		this.dimension=dimension;
//		MyPanel(x,y);
	}
	//@override paint function
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 2000, 2000);
		tk.drawTank(g);
	}

	public int getXX() {
		return xx;
	}
	public void setXX(int x) {
		this.xx = x;
	}
	public int getYY() {
		return yy;
	}
	public void setYY(int y) {
		this.yy = y;
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
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			tk.moveDown();
			tk.setDirection(3);
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			tk.moveUp();
			tk.setDirection(2);
		}
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			tk.moveLeft();
			tk.setDirection(0);
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			tk.moveRight();
			tk.setDirection(1);
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
	
}
