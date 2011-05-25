package com.inf5153.tp1;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class UIMainWindow {

	private int frameWitdh = 640;
	private int frameHeight = 480;
	
	private JFrame frame;
	private JPanel panel;
	private JMenuBar menuBar;
	private JToolBar toolBar;
	private JTextArea textArea;
	
	private EditorPanel editorPanel;
	
	
	
	public UIMainWindow() {
		frame = new JFrame();
		setupFrame();
		panel = new JPanel();
		menuBar = new JMenuBar();
		setupMenuBar();
		toolBar = new JToolBar();
		setupToolBar();
		textArea = new JTextArea();
		setupTextArea();

		frame.setContentPane(panel);
		frame.setVisible(true);
	}
	
	private void setupFrame(){
		frame.setSize(frameWitdh, frameHeight);
		frame.setTitle("rEdditooooooooor");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setupMenuBar(){
		JMenu menu= new JMenu("Actions");
		
		menu.add(new JMenuItem("Select"));
		menu.add(new JMenuItem("Copy")).add(new JSeparator());
		menu.add(new JMenuItem("Cut"));
		menu.add(new JMenuItem("Paste"));
		menu.add(new JMenuItem("Quit")).add(new JSeparator());
		
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);		
	}
	
	private void setupToolBar(){
		toolBar.add(new JButton(new ImageIcon("img/copy-icon.png")));
		toolBar.add(new JButton(new ImageIcon("img/cut-icon.png")));
		toolBar.add(new JButton(new ImageIcon("img/paste-icon.png")));
		panel.add(toolBar, BorderLayout.NORTH);
	}
	
	private void setupTextArea(){
		textArea.setPreferredSize(null);
		textArea.setLineWrap(true);
		panel.add(textArea, BorderLayout.NORTH);
		
	}
	
	public static void main(String[] args) {
		UIMainWindow window = new UIMainWindow();
	}
	
	
}
