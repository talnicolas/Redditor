//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\EditorUI.java

package rEdditooooooor.View.impl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import rEdditooooooor.Controler.impl.CommandCopy;
import rEdditooooooor.Controler.impl.CommandCut;
import rEdditooooooor.Controler.impl.CommandDelete;
import rEdditooooooor.Controler.impl.CommandInsert;
import rEdditooooooor.Controler.impl.CommandManager;
import rEdditooooooor.Controler.impl.CommandNew;
import rEdditooooooor.Controler.impl.CommandPaste;
import rEdditooooooor.Model.TextConcrete;
import rEdditooooooor.View.IEditorView;

public class EditorUI extends JFrame implements IEditorView
{
   private TextConcrete subject;
   
   private static final long serialVersionUID = 1L;
	
	private int frameWitdh = 680;
	private int frameHeight = 480;
	
	private JPanel panel;
	private JMenuBar menuBar;
	private JToolBar toolBar;
	private JTextArea textArea;
	
	private int caretStart = 0;
	private int caretStop = 0;
	
	private CommandManager commandManager;
	
	public EditorUI() {
		
		initializeWindow();
		commandManager = new CommandManager();
		subject = TextConcrete.getInstance();
		subject.attach(this);
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
		
		JMenuItem newItem = new JMenuItem("New");
		newItem.addActionListener(new NewItemListener());
		menuFile.add(newItem);
		JMenuItem quitItem = new JMenuItem("Quit");
		quitItem.addActionListener(new QuitItemListener());
		menuFile.add(quitItem).add(new JSeparator());
		
		JMenu menuEdit= new JMenu("Edit");
		
		menuEdit.add(new JMenuItem("Select"));
		JMenuItem copyItem = new JMenuItem("Copy");
		copyItem.addActionListener(new CopyItemListener());
		menuEdit.add(copyItem).add(new JSeparator());
		JMenuItem cutItem = new JMenuItem("Cut");
		cutItem.addActionListener(new CutItemListener());
		menuEdit.add(cutItem);
		JMenuItem pasteItem = new JMenuItem("Paste");
		pasteItem.addActionListener(new PasteItemListener());
		menuEdit.add(pasteItem);
		
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
		
		JButton newButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("new.png")));
		newButton.addActionListener(new NewItemListener());
		toolBar.add(newButton);
		toolBar.addSeparator();
		JButton copyButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("copy.png")));
		copyButton.addActionListener(new CopyItemListener());
		toolBar.add(copyButton);
		JButton cutButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("cut.png")));
		cutButton.addActionListener(new CutItemListener());
		toolBar.add(cutButton);
		JButton pasteButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("paste.png")));
		pasteButton.addActionListener(new PasteItemListener());
		toolBar.add(pasteButton);
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
		textArea.addKeyListener(new InsertItemListener());
		
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
	public void update() {
		this.textArea.setText(this.subject.getState());
	}

	class QuitItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int temp = JOptionPane.showConfirmDialog(rootPane, "Do you really really really want to quit?");
			if(temp == JOptionPane.YES_OPTION){
				System.exit(EXIT_ON_CLOSE);
			}
		}		
	}
	
	class NewItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int temp = JOptionPane.showConfirmDialog(rootPane, "You will lose every data, are you sure?");
			if(temp == JOptionPane.YES_OPTION){
				commandManager.executeCommand(new CommandNew());
			}
		}
		
	}
	
	class CutItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			commandManager.executeCommand(new CommandCut(caretStart, caretStop));			
		}		
	}
	
	class CopyItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			commandManager.executeCommand(new CommandCopy(caretStart, caretStop));			
		}		
	}
	
	class PasteItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			commandManager.executeCommand(new CommandPaste(caretStart, caretStop));			
		}		
	}
	
	class InsertItemListener extends KeyAdapter {		
		@Override
		public void keyReleased(KeyEvent e) {
			int temp = e.getKeyCode();
			if(temp == 8){
				commandManager.executeCommand(new CommandDelete());				
			} else if((temp == 10) || (temp > 31 && temp < 37) || (temp > 40 && temp < 127) ) {
				commandManager.executeCommand(new CommandInsert(e.getKeyChar()));
			}
		}		
	}
	

}
