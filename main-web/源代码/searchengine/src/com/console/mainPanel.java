package com.console;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class mainPanel extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame jf;
	private JTabbedPane jtab;
	 private panelFacstory p;
	public mainPanel() {
		jf=this;
		jf.setSize(1000, 800);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    jf.setLocationRelativeTo(null);
	    jtab=new JTabbedPane();
	    p=new panelFacstory();
	    jtab.addTab("Webmagic", p.getWebmagic());
	    jf.setContentPane(jtab);
        jf.setVisible(true);
	}
}
