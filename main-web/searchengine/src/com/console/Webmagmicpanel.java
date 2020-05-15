package com.console;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Webmagmicpanel extends Panelabs implements ActionListener,KeyListener{
	private JPanel jp;
	private JButton start;
	private JLabel tinterval;
	private JTextField interval;
	private JButton save;
	private JLabel tRetryTimes;
	private JTextField RetryTimes;
	private JLabel tCycleRetryTimes;
	private JTextField CycleRetryTimes;
	public Webmagmicpanel() {
		jp=new JPanel();
		start=new JButton("启动");
		start.setSize(80, 30);
		save=new JButton("保存");
		save.setSize(80, 30);
		
		tinterval=new JLabel("间隔:");
		tRetryTimes=new JLabel("错误次数:");
		tCycleRetryTimes=new JLabel("重试次数：");
		
		interval=new JTextField(1);
		RetryTimes=new JTextField(1);
		CycleRetryTimes=new JTextField(1);
		
		interval.addKeyListener(this);
		RetryTimes.addKeyListener(this);
		CycleRetryTimes.addKeyListener(this);
		
		interval.setSize(100, 50);
		CycleRetryTimes.setSize(100, 50);
		RetryTimes.setSize(100, 50);
		
		save.addActionListener(this);
		start.addActionListener(this);
		JPanel panel=new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		panel.add(tinterval);
		panel.add(interval);
		
		panel.add(tRetryTimes);
		panel.add(RetryTimes);
		
		panel.add(tCycleRetryTimes);
		panel.add(CycleRetryTimes);
		jp.add(panel);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyChar=e.getKeyChar();
		if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {
		} else {
		e.consume();
		}
		
	}
}
