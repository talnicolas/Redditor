//Source file: C:\\Users\\nikkKO\\Desktop\\rEdditooooooor\\EditorUI.java

package rEdditooooooor.View.impl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

import rEdditooooooor.View.IEditorView;

/**
 * Graphical view of the model
 */
public class EditorUI extends JFrame implements IEditorView
{
	private static final long serialVersionUID = 1L;
	
	private int frameWitdh = 680;
	private int frameHeight = 480;
	
	private JPanel panel;
	private JMenuBar menuBar;
	private JToolBar toolBar;
	private JTextArea textArea;
	
	private int caretStart = 0;
	private int caretStop = 0;
	private int caretPosToSet = 0;
	
	private JButton startButton, stopButton, playButton, resetButton;
	private JMenuItem startItem, stopItem, playItem, resetItem; 
        /**
         * Default Constructor
         */
	public EditorUI() {
		
		initializeWindow();
		subject.attach(this);
		this.setVisible(true);
	}
	
	private void initializeWindow(){
		
		//FRAME SETTINGS
		this.setSize(frameWitdh, frameHeight);
		this.setTitle("rEdditooooooooor");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
		
		JMenuItem copyItem = new JMenuItem("Copy");
		copyItem.addActionListener(new CopyItemListener());
		menuEdit.add(copyItem);
		JMenuItem cutItem = new JMenuItem("Cut");
		cutItem.addActionListener(new CutItemListener());
		menuEdit.add(cutItem);
		JMenuItem pasteItem = new JMenuItem("Paste");
		pasteItem.addActionListener(new PasteItemListener());
		menuEdit.add(pasteItem);
		
		JMenu menuMacro= new JMenu("Recording");
				
		startItem = new JMenuItem("Start");
		startItem.addActionListener(new StartItemListener());
		menuMacro.add(startItem);
		stopItem = new JMenuItem("Stop");
		stopItem.addActionListener(new StopItemListener());
		menuMacro.add(stopItem);
		resetItem = new JMenuItem("Reset");
		resetItem.addActionListener(new RedoItemListener());
		menuMacro.add(resetItem).add(new JSeparator());
		playItem = new JMenuItem("Play");
		playItem.addActionListener(new PlayItemListener());
		menuMacro.add(playItem).add(new JSeparator());
		
		JMenu menuAbout= new JMenu("?");
		
		JMenuItem aboutItem = new JMenuItem("About...");
		final String message = "\trEdditooooooor v2.0\n\n" +
						 "\tBy Frederic Brockow and Nicolas Tallineau\n\n" + 
						 "\tFind the sources at: github.com/talnicolas";
		aboutItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(rootPane, message, "About...", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		menuAbout.add(aboutItem);
		
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
		newButton.setToolTipText("New");
		toolBar.addSeparator();
		JButton copyButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("copy.png")));
		copyButton.addActionListener(new CopyItemListener());
		copyButton.setToolTipText("Copy");
		toolBar.add(copyButton);
		JButton cutButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("cut.png")));
		cutButton.addActionListener(new CutItemListener());
		cutButton.setToolTipText("Cut");
		toolBar.add(cutButton);
		JButton pasteButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("paste.png")));
		pasteButton.addActionListener(new PasteItemListener());
		pasteButton.setToolTipText("Paste");
		toolBar.add(pasteButton);
		toolBar.addSeparator();
		JButton undoButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("undo.png")));
		undoButton.addActionListener(new UndoItemListener());
		undoButton.setToolTipText("Undo");
		toolBar.add(undoButton);
		JButton redoButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("redo.png")));
		redoButton.addActionListener(new RedoItemListener());
		redoButton.setToolTipText("Redo");
		toolBar.add(redoButton);
		toolBar.addSeparator();
		startButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("mic.png")));
		startButton.addActionListener(new StartItemListener());
		startButton.setActionCommand("enable");
		startButton.setToolTipText("Start Recording");
		toolBar.add(startButton);
		stopButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("playback_stop.png")));
		stopButton.addActionListener(new StopItemListener());
		stopButton.setEnabled(false);
		stopButton.setActionCommand("enable");
		stopButton.setToolTipText("Stop Recording");
		toolBar.add(stopButton);
		playButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("play.png")));
		playButton.addActionListener(new PlayItemListener());
		playButton.setEnabled(false);
		playButton.setToolTipText("Play");
		toolBar.add(playButton);
		resetButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("reset.png")));
		resetButton.addActionListener(new ResetItemListener());
		resetButton.setEnabled(false);
		resetButton.setActionCommand("disable");
		resetButton.setToolTipText("Reset");
		toolBar.add(resetButton);
		
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
		textArea.addKeyListener(new KeyboardListener());
		
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scroll, BorderLayout.CENTER);
		
		this.setContentPane(panel);
        addWindowListener(new WindowCloseListener());
	}
	
	@Override
	public void update() {	
		this.textArea.setText(subject.getState());
		if(caretPosToSet > subject.getState().length()){
			caretPosToSet = subject.getState().length();		
		}
		this.textArea.setCaretPosition(caretPosToSet);		
	}

    ////////////////
	// Actions to take when a button/menu item/key is pressed.
	////////////////

	class QuitItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int temp = JOptionPane.showConfirmDialog(rootPane, "Do you really really really want to quit?", "Quit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(temp == JOptionPane.YES_OPTION){
				System.exit(EXIT_ON_CLOSE);
			}
		}		
	}
	
	class NewItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int temp = JOptionPane.showConfirmDialog(rootPane, "You will lose every data, are you sure?", "New Document", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(temp == JOptionPane.YES_OPTION){
				commandManager.executeCommandNew();
			}
		}
		
	}
	
	class CutItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			caretPosToSet = caretStop;
			commandManager.executeCommandCut(caretStart, caretStop);			
		}		
	}
	
	class CopyItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			caretPosToSet = caretStop;
			commandManager.executeCommandCopy(caretStart, caretStop);		
		}		
	}
	
	class PasteItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			caretPosToSet = caretStop;
			commandManager.executeCommandPaste(caretStart, caretStop);			
		}		
	}
	
	class UndoItemListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			caretPosToSet = 0;
			commandManager.undo();
		}		
	}
	
	class RedoItemListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			caretPosToSet = 0;
			commandManager.redo();
		}		
	}

	class StartItemListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if((arg0.getActionCommand()).equals("enable")){
				stopButton.setEnabled(true);
			}
			commandManager.executeCommandStart();
		}		
	}
	
	class StopItemListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if((arg0.getActionCommand()).equals("enable")){
				playButton.setEnabled(true);
				resetButton.setEnabled(true);
			}
			commandManager.executeCommandStop();
		}		
	}
	
	class PlayItemListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {			
			commandManager.executeCommandPlay();
		}		
	}
	
	class ResetItemListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if((arg0.getActionCommand()).equals("disable")){
				playButton.setEnabled(false);
				resetButton.setEnabled(false);
				stopButton.setEnabled(false);
			}
			commandManager.executeCommandReset();
		}		
	}
	class KeyboardListener extends KeyAdapter {	
		
		@Override
		public void keyPressed(KeyEvent e) {
			
			int temp = e.getKeyCode();
			if(temp != 37 && temp != 38 && temp != 39 && temp != 40){
				e.consume();
			}
			if(caretStart > caretStop){
				int back = caretStart;
				caretStart = caretStop;
				caretStop = back;
			}
								
			caretPosToSet = caretStop;
			
			if(e.isControlDown()) {
				if(e.getKeyCode() == KeyEvent.VK_C) {			
					commandManager.executeCommandCopy(caretStart, caretStop);
				} else if(e.getKeyCode() == KeyEvent.VK_V) {
					commandManager.executeCommandPaste(caretStart, caretStop);
				} else if(e.getKeyCode() == KeyEvent.VK_X) {
					caretPosToSet = caretStart;
					commandManager.executeCommandCut(caretStart, caretStop);
				} else if(e.getKeyCode() == KeyEvent.VK_Z) {			
					commandManager.undo();
				} else if(e.getKeyCode() == KeyEvent.VK_Y) {
					commandManager.redo();
				}
			}
			
			if (!e.isControlDown()) {		
				if(temp == 8 && caretStop != 0) {
					if(caretStart == caretStop){
						caretPosToSet = caretStart - 1;
					} else {
						caretPosToSet = caretStart;
					}
					commandManager.executeCommandDelete(caretStart, caretStop);
				} else if(temp == 127 && caretStop != textArea.getText().length() + 1){
					caretPosToSet = caretStart;		
					commandManager.executeCommandDeleteAfter(caretStart, caretStop);
				} else if((temp == 10) || (temp > 31 && temp < 37) || (temp > 40 && temp < 127) ) {
					caretPosToSet = caretStart + 1;
					commandManager.executeCommandInsert(caretStart, caretStop, e.getKeyChar());
				} else {
					caretPosToSet = caretStart;
				}
			}
		}					
		@Override
		public void keyTyped(final KeyEvent e) {
			e.consume();			
		}
	}
	
	class WindowCloseListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			int temp = JOptionPane.showConfirmDialog(rootPane, "Do you really really really want to quit?", "Quit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(temp == JOptionPane.YES_OPTION){
				System.exit(EXIT_ON_CLOSE);
			} else {
				
			}
		}
	}
}
