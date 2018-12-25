/**
 * Draw Tank on a Canvas
 * Tank 特点: 位置(x,y),朝向:上下左右，颜色:区分敌我,移动(x,y)
 * 1. New MyTank should show a Tank
 * 2. add more bullet at the same time
 * 3. Enemy Tank and when hit, remove
 * 4. keybord hold,and shot at the same time, next package
 * 5. explorsion effect
 */

package com.tank4;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Vector;

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
	Tank hero=null;
	Vector<Enemy> enemies=new Vector<Enemy>();
	int dimension;
	public MyPanel(int x,int y){
		this.x=x;
		this.y=x;
		hero=new Hero(x,y);
		for(int i=0;i<5;i++){
			Enemy enemy=new Enemy(50+i*50,50);
			enemies.add(enemy);
			Thread t=new Thread(enemy);
			t.start();
		}
		dimension=hero.dimension;
	}
	//@override paint function
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 2000, 2000);
		paintTank(g,hero);
		for(int i=0;i<enemies.size();i++){
			Tank enemy=enemies.get(i);
			paintTank(g,enemy);
		}
	}

	public void paintTank(Graphics g,Tank tk){
		if(tk.isLive==true) drawTank(g,tk);
		drawBullet(g,tk);
		tk.removeDeadBullet();
	}

	public void drawBullet(Graphics g,Tank tk){
		for(int i=0;i<tk.cassette.size();i++){
			Bullet bullet=tk.cassette.get(i);
			if(bullet!=null&&bullet.isLive==true){
				//int bulletSize=(int)(0.1*dimension);
				int bulletSize=4;
				g.fillOval(bullet.x-bulletSize/2, bullet.y-bulletSize/2,bulletSize,bulletSize);
			}
		}
	}
	public void drawTank(Graphics g,Tank tk){
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
			hero.moveDown();
			hero.setDirection(3);
		}
		if(e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_W){
			hero.moveUp();
			hero.setDirection(2);
		}
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A){
			hero.moveLeft();
			hero.setDirection(0);
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D){
			hero.moveRight();
			hero.setDirection(1);
		}
		if(e.getKeyCode()==KeyEvent.VK_J){
			if(hero.cassette.size()<15){
				hero.shotEnemy();
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

			isHitEnemy();
			this.repaint();
		}

	}
	public void isHitEnemy(){
		for(int i=0;i<hero.cassette.size();i++){
			Bullet bullet=hero.cassette.get(i);
			if(bullet.isLive==true){
				for(int j=0;j<enemies.size();j++){
					Enemy enemy=enemies.get(j);
					if(enemy.isLive==true){
						isBulletHitEnemy(bullet,enemy);
					}

				}

			}
		}

	}

	public void isBulletHitEnemy(Bullet bullet,Enemy enemy){
		int x0=bullet.x;
		int y0=bullet.y;
		int xt=enemy.x;
		int yt=enemy.y;
		int dim=enemy.dimension;
		switch(enemy.getDirection()){
			case 0:
			case 1:
				if(x0>xt&&x0<xt+5*dim&&y0>yt&&y0<yt+3*dim){
					bullet.isLive=false;
					enemy.isLive=false;
				}
				break;
			case 2:
			case 3:
				if(x0>xt&&x0<xt+3*dim&&y0>yt&&y0<yt+5*dim){
					bullet.isLive=false;
					enemy.isLive=false;
				}
				break;

		}



	}
}
