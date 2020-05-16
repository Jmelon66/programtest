package com.console;

import javax.swing.JPanel;

public abstract class Panelabs extends JPanel{
	private JPanel jp;
	public Panelabs() {
		jp=this;
		jp.setSize(500,500);
	}
}
