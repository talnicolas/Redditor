package com.inf5153.tp1;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class UIMainWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private int frameWitdh = 640;
	private int frameHeight = 480;
	
	private JPanel panel;
	private JMenuBar menuBar;
	private JToolBar toolBar;
	private JTextArea textArea;
	
	
	public UIMainWindow() {
		
		initializeWindow();
		this.setVisible(true);
	}
	
	private void initializeWindow(){
		
		//FRAME SETTINGS
		this.setSize(frameWitdh, frameHeight);
		this.setTitle("rEdditooooooooor");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		panel = (JPanel) this.getContentPane();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder( 4, 4, 4, 4));
		panel.setOpaque(false);
		
		//MENUBAR SETTINGS
		JMenu menu= new JMenu("Actions");
		
		
		menu.add(new JMenuItem("Select"));
		menu.add(new JMenuItem("Copy")).add(new JSeparator());
		menu.add(new JMenuItem("Cut"));
		menu.add(new JMenuItem("Paste"));
		menu.add(new JMenuItem("Quit")).add(new JSeparator());
		
		menuBar = new JMenuBar();
		menuBar.add(menu);
		this.setJMenuBar(menuBar);		
	
		
		//TOOLBAR SETTINGS
		
		toolBar = new JToolBar();
		toolBar.add(new JButton(new ImageIcon("img/copy.png")));
		toolBar.add(new JButton(new ImageIcon("img/cut.png")));
		toolBar.add(new JButton(new ImageIcon("img/paste.png")));
		panel.add(toolBar, BorderLayout.NORTH);
	
		//TEXTAREA SETTINGS
		
		textArea = new JTextArea();

		textArea.setFont(new Font("Monospaced",Font.PLAIN,12));
		textArea.setBorder(BorderFactory.createEmptyBorder( 4, 4, 4, 4));
		textArea.setPreferredSize(null);
		textArea.setLineWrap(true);		
		textArea.setWrapStyleWord(true);
		
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scroll, BorderLayout.CENTER);
		
		this.setContentPane(panel);
			
	}
		
	public static void main(String[] args) {
		UIMainWindow window = new UIMainWindow();
	}		
}
