package com.mytank1;
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Event_Monitor extends JFrame implements ActionListener{
	
	JPanel jp=null;
	JButton jb1=null;
	JButton jb2=null;
	
	public Event_Monitor() {
		// TODO Auto-generated constructor stub
		jp=new JPanel();
		jb1=new JButton("黑色");
		jb2=new JButton("粉色");
		
		//add monitor
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		//set action command to excute
		jb1.setActionCommand("aa");
		jb2.setActionCommand("bb");
		
		this.add(jb1,BorderLayout.NORTH);
		jp.setBackground(Color.BLACK);
		this.add(jp);
		this.add(jb2,BorderLayout.SOUTH);
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Event_Monitor em=new Event_Monitor();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Action capertured!");
		if(e.getActionCommand().equals("aa")) {
			jp.setBackground(Color.BLACK);
		}else if(e.getActionCommand().equals("bb")) {
			jp.setBackground(Color.PINK);
		}else {
			System.out.println("You type wrong places!!!");
		}
	}

}
