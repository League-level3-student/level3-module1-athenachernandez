package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener {
	
	JFrame frame;
	JPanel panel;
	JButton button = new JButton();
	ArrayList<Song> songs = new ArrayList<Song>();
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
			//Song song = new Song("nocturne.mp3");
			//song.play();
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
		
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.getDefaultCloseOperation();
		
		panel = new JPanel();
		panel.add(button);
		frame.add(panel);
		frame.pack();		
		button.addActionListener((ActionListener) this);
		
		button.setText("Surprise Me!");
		songs.add(new Song("nocturne.mp3"));
		songs.add(new Song("brandenburg.mp3"));
		songs.add(new Song("einekleine.mp3"));
		songs.add(new Song("prokofiev.mp3"));
		
		
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Random random = new Random();
		if (e.getSource() == button) {
			int randomIndex = random.nextInt(3);
			songs.get(randomIndex).play();
			
		}
		
	}
}