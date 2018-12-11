///**
// * Draw Tank on a Canvas
// * Tank 特点: 位置(x,y),朝向:上下左右，颜色:区分敌我,移动(x,y)
// * 1. New MyTank should show a Tank
// * 2. 
// */
//
//package com.mytank1;
//import java.awt.*;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//public class DrawTank extends JFrame{
//	// Frame init position
//	MyPanel mp=null;
//	
//	public DrawTank() {
//		// TODO Auto-generated constructor stub
//		int x=100;
//		int y=100;
//		mp=new MyPanel(x,y);
//		this.add(mp);
//		//this.setBackground(Color.RED);
//		//set layout
//		this.setSize(400,300);
//		
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setVisible(true);
////		mp.paint(g);
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		DrawTank dt=new DrawTank();
//	}
//
//}
//
//class MyPanel extends JPanel{
//	int x;
//	int y;
//	int dimension=5;// dimension of Tank
//	Tank tk=null;
//	public MyPanel(int x,int y){
//		this.x=x;
//		this.y=y;
//		tk=new Hero(x,y);
//	}
//	public MyPanel(int x,int y,int dimension){
//		this.dimension=dimension;
////		MyPanel(x,y);
//	}
//	//@override paint function
//	public void paint(Graphics g) {
//		super.paint(g);
//		g.fillRect(0, 0, 200, 200);
//		g.setColor(tk.getColor());
//		g.fillRect(x, y, dimension, 4*dimension);
//		g.fillRect(x+3*dimension, y, dimension, 4*dimension);
//		g.fillRect(x+dimension, y+dimension, 2*dimension, 2*dimension);
//		g.fillOval(x+dimension, y+dimension, dimension, dimension);
//		g.drawLine(x+2*dimension, y+2*dimension, x+2*dimension, y-2*dimension);
//	}
//
//	public int getX() {
//		return x;
//	}
//	public void setX(int x) {
//		this.x = x;
//	}
//	public int getY() {
//		return y;
//	}
//	public void setY(int y) {
//		this.y = y;
//	}
//	public int getDimension() {
//		return dimension;
//	}
//	public void setDimension(int dimension) {
//		this.dimension = dimension;
//	}
//	
//}
////Tank 特点: 位置(x,y),朝向:上下左右，颜色:区分敌我,移动(x,y)
//class Tank{
//	int x;
//	int y;
//	String direction;//left,right,up,down
//	Color color;
//	public Tank(int x,int y) {
//		this.x=x;
//		this.y=y;
//	}
//	public void move(String direction) {
//		
//	}
//	public void turn(String direction) {
//		
//	}
//	public int getX() {
//		return x;
//	}
//	public void setX(int x) {
//		this.x = x;
//	}
//	public int getY() {
//		return y;
//	}
//	public void setY(int y) {
//		this.y = y;
//	}
//	public String getDirection() {
//		return direction;
//	}
//	public void setDirection(String direction) {
//		this.direction = direction;
//	}
//	public Color getColor() {
//		return color;
//	}
//	public void setColor(Color color) {
//		this.color = color;
//	}
//}
//class Hero extends Tank{
//	public Hero(int x,int y) {
//		super(x,y);
//		super.setColor(Color.CYAN);
//	}
//}
//class Enemy extends Tank{
//	public Enemy(int x,int y) {
//		super(x,y);
//		super.setColor(Color.BLACK);
//	}
//}