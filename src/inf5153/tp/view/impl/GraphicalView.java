package tp.view.impl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

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
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import tp.view.EditorView;

public class GraphicalView extends JFrame implements EditorView, Observer {
	
	private static final long serialVersionUID = 1L;
	
	private int frameWitdh = 680;
	private int frameHeight = 480;
	
	private JPanel panel;
	private JMenuBar menuBar;
	private JToolBar toolBar;
	private JTextArea textArea;
	
	private int caretStart = 0;
	private int caretStop = 0;
	
	public GraphicalView() {
		
		initializeWindow();
		this.setVisible(true);
	}
	
	private void initializeWindow(){
		
		//FRAME SETTINGS
		this.setSize(frameWitdh, frameHeight);
		this.setTitle("rEdditooooooooor");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(frameWitdh, 200));		
		
		panel = (JPanel) this.getContentPane();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder( 4, 4, 4, 4));
		panel.setOpaque(false);
		
		//MENUBAR SETTINGS
		JMenu menuFile= new JMenu("File");
		
		menuFile.add(new JMenuItem("New	"));
		menuFile.add(new JMenuItem("Quit")).add(new JSeparator());
		
		JMenu menuEdit= new JMenu("Edit");
		
		menuEdit.add(new JMenuItem("Select"));
		menuEdit.add(new JMenuItem("Copy")).add(new JSeparator());
		menuEdit.add(new JMenuItem("Cut"));
		menuEdit.add(new JMenuItem("Paste"));
		
		JMenu menuMacro= new JMenu("Recording");
				
		menuMacro.add(new JMenuItem("Start"));
		menuMacro.add(new JMenuItem("Stop"));
		menuMacro.add(new JMenuItem("Reset")).add(new JSeparator());
		menuMacro.add(new JMenuItem("Play")).add(new JSeparator());
		
		JMenu menuAbout= new JMenu("?");
		
		menuAbout.add(new JMenuItem("About..."));
		
		menuBar = new JMenuBar();
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuMacro);
		menuBar.add(menuAbout);
		this.setJMenuBar(menuBar);		
	
		
		//TOOLBAR SETTINGS
		
		toolBar = new JToolBar();
		
		toolBar.add(new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("new.png"))));
		toolBar.addSeparator();
		toolBar.add(new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("copy.png"))));
		toolBar.add(new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("cut.png"))));
		toolBar.add(new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("paste.png"))));
		toolBar.addSeparator();
		toolBar.add(new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("undo.png"))));
		toolBar.add(new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("redo.png"))));
		toolBar.addSeparator();
		toolBar.add(new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("mic.png"))));
		toolBar.add(new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("playback_stop.png"))));
		toolBar.add(new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("play.png"))));
		toolBar.add(new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("reset.png"))));

		panel.add(toolBar, BorderLayout.NORTH);
	
		//TEXTAREA SETTINGS
		
		textArea = new JTextArea();

		textArea.setFont(new Font("Monospaced",Font.PLAIN,12));
		textArea.setBorder(BorderFactory.createEmptyBorder( 4, 4, 4, 4));
		textArea.setPreferredSize(null);
		textArea.setLineWrap(true);		
		textArea.setWrapStyleWord(true);
		
		CaretListener caretListener = new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent caretEvent) {
				caretStart = caretEvent.getDot();
				caretStop = caretEvent.getMark();
			}
		};
		
		textArea.addCaretListener(caretListener);
		
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scroll, BorderLayout.CENTER);
		
		this.setContentPane(panel);
	}
	
	public int getCaretStart() {
		return caretStart;
	}
	
	public int getCaretStop() {
		return caretStop;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}
}
