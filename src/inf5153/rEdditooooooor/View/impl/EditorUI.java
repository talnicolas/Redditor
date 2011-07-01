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

import rEdditooooooor.Controler.impl.CommandCopy;
import rEdditooooooor.Controler.impl.CommandCut;
import rEdditooooooor.Controler.impl.CommandDelete;
import rEdditooooooor.Controler.impl.CommandDeleteAfter;
import rEdditooooooor.Controler.impl.CommandInsert;
import rEdditooooooor.Controler.impl.CommandManager;
import rEdditooooooor.Controler.impl.CommandNew;
import rEdditooooooor.Controler.impl.CommandPaste;
import rEdditooooooor.Model.TextConcrete;
import rEdditooooooor.View.IEditorView;

/**
 * Graphical view of the model
 */
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
	private int caretPosToSet = 0;
	
	private CommandManager commandManager;
	
        /**
         * Default Constructor
         */
	public EditorUI() {
		
		initializeWindow();
		commandManager = CommandManager.getInstance();
		subject = TextConcrete.getInstance();
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
				
		JMenuItem startItem = new JMenuItem("Start");
		//startItem.addActionListener();
		startItem.setEnabled(false);
		menuMacro.add(startItem);
		JMenuItem stopItem = new JMenuItem("Stop");
		//stopItem.addActionListener();
		stopItem.setEnabled(false);
		menuMacro.add(stopItem);
		JMenuItem resetItem = new JMenuItem("Reset");
		//resetItem.addActionListener();
		resetItem.setEnabled(false);
		menuMacro.add(resetItem).add(new JSeparator());
		JMenuItem playItem = new JMenuItem("Play");
		//playItem.addActionListener();
		playItem.setEnabled(false);
		menuMacro.add(playItem).add(new JSeparator());
		
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
		JButton startButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("mic.png")));
		//startButton.addActionListener();
		startButton.setToolTipText("Start Recording");
		startButton.setEnabled(false);
		toolBar.add(startButton);
		JButton stopButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("playback_stop.png")));
		//stopButton.addActionListener();
		stopButton.setToolTipText("Stop Recording");
		stopButton.setEnabled(false);
		toolBar.add(stopButton);
		JButton playButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("play.png")));
		//playButton.addActionListener();
		playButton.setToolTipText("Play");
		playButton.setEnabled(false);
		toolBar.add(playButton);
		JButton resetButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("reset.png")));
		//resetButton.addActionListener();
		resetButton.setToolTipText("Reset");
		resetButton.setEnabled(false);
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
		textArea.addKeyListener(new InsertItemListener());
		
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scroll, BorderLayout.CENTER);
		
		this.setContentPane(panel);
        addWindowListener(new WindowCloseListener());
	}

	@Override
	public void update() {	
		this.textArea.setText(this.subject.getState());
		if(caretPosToSet > this.subject.getState().length()){
			caretPosToSet = this.subject.getState().length();		
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
				commandManager.executeCommand(new CommandNew());
			}
		}
		
	}
	
	class CutItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			caretPosToSet = caretStop;
			commandManager.executeCommand(new CommandCut(caretStart, caretStop));			
		}		
	}
	
	class CopyItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			caretPosToSet = caretStop;
			commandManager.executeCommand(new CommandCopy(caretStart, caretStop));			
		}		
	}
	
	class PasteItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			caretPosToSet = caretStop;
			commandManager.executeCommand(new CommandPaste(caretStart, caretStop));			
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
		
	class InsertItemListener extends KeyAdapter {	
		
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
			
			if(temp == 8 && caretStop != 0){
				if(caretStart == caretStop){
					caretPosToSet = caretStart - 1;
				} else {
					caretPosToSet = caretStart;
				}
				commandManager.executeCommand(new CommandDelete(caretStart, caretStop));
			} else if(temp == 127 && caretStop != textArea.getText().length() + 1){
				caretPosToSet = caretStart;		
				commandManager.executeCommand(new CommandDeleteAfter(caretStart, caretStop));
			} else if((temp == 10) || (temp > 31 && temp < 37) || (temp > 40 && temp < 127) ) {
				caretPosToSet = caretStart + 1;
				commandManager.executeCommand(new CommandInsert(caretStart, caretStop, e.getKeyChar()));
			} else {
				caretPosToSet = caretStart;
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
