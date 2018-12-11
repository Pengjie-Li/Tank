/**
 * Draw Tank on a Canvas
 * Tank 特点: 位置(x,y),朝向:上下左右，颜色:区分敌我,移动(x,y)
 * 1. New MyTank should show a Tank
 * 2. 
 */

package com.mytank1;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class mytank1 extends JFrame{
	// Frame init position
	MyPanel mp=null;
	
	public mytank1() {
		// TODO Auto-generated constructor stub
		int x=100;
		int y=100;
		mp=new MyPanel(x,y);
		//mp.setLayout(null);
		//this.add(mp,BorderLayout.NORTH);
		this.add(mp);
		this.addKeyListener(mp);
		//this.setBackground(Color.RED);
		//set layout
		//this.setLayout(getLayout());
		this.setSize(400,300);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
//		mp.paint(g);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mytank1 mt=new mytank1();
	}

}

class MyPanel extends JPanel implements KeyListener{
	int x;
	int y;
	int dimension=5;// dimension of Tank
	Tank tk=null;
	public MyPanel(int x,int y){
		this.x=x;
		this.y=y;
		tk=new Hero(x,y);
	}
	public MyPanel(int x,int y,int dimension){
		this.dimension=dimension;
//		MyPanel(x,y);
	}
	//@override paint function
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 2000, 2000);
		g.setColor(tk.getColor());
		g.fillRect(x, y, dimension, 4*dimension);
		g.fillRect(x+3*dimension, y, dimension, 4*dimension);
		g.fillRect(x+dimension, y+dimension, 2*dimension, 2*dimension);
		g.fillOval(x+dimension, y+dimension, dimension, dimension);
		g.drawLine(x+2*dimension, y+2*dimension, x+2*dimension, y-2*dimension);
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
			y++;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			y--;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			x--;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			x++;
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
//Tank 特点: 位置(x,y),朝向:上下左右，颜色:区分敌我,移动(x,y)
class Tank{
	int x;
	int y;
	String direction;//left,right,up,down
	Color color;
	public Tank(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public void move(String direction) {
		
	}
	public void turn(String direction) {
		
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
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
class Hero extends Tank{
	public Hero(int x,int y) {
		super(x,y);
		super.setColor(Color.CYAN);
	}
}
class Enemy extends Tank{
	public Enemy(int x,int y) {
		super(x,y);
		super.setColor(Color.BLACK);
	}
}