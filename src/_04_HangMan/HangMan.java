package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<String> stack = new Stack<String>();
	String hiddenWord = "";
	String currentWord;
	int lives = 10;
	char[] currentWordArray;
	char[] hiddenWordArray;

	HangMan() {
		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
	}

	public void run() {
		String userInput = JOptionPane.showInputDialog("Enter a number:");
		int userInt = Integer.parseInt(userInput);
		getRandomWords(userInt);
		displayWordLine();
		checkRoundOver();
		System.out.println(currentWord);

	}

	public void getRandomWords(int userInt) {
		for (int i = 0; i < userInt; i++) {
			String word = Utilities.readRandomLineFromFile("dictionary.txt");

			if (!stack.contains(word)) {
				stack.push(word);
			}

		}
	}

	public void displayWordLine() {
		currentWord = stack.pop();

		for (int i = 0; i < currentWord.length(); i++) {
			hiddenWord += "_";
		}
		label.setText(hiddenWord);
		frame.pack();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char guessedLetter = e.getKeyChar();
		currentWordArray = currentWord.toCharArray();
		hiddenWordArray = hiddenWord.toCharArray();
		boolean inWord = false;

		for (int i = 0; i < currentWordArray.length; i++) {
			if (currentWordArray[i] == guessedLetter) {
				hiddenWordArray[i] = guessedLetter;
				inWord = true;
			}
		}
		
		hiddenWord = "";
		for (int i = 0; i < hiddenWordArray.length; i++) {
			hiddenWord += hiddenWordArray[i];
		}
		label.setText(hiddenWord);

		if (!inWord) {
			lives--;
		}
		if (lives == 0) {
			JOptionPane.showMessageDialog(null, "You ran out of lives! :O");
		}
	}

	public void checkRoundOver() {
		if (hiddenWord.equals(currentWord)) {
			currentWord = stack.pop();
			lives = 10;
			if (stack.size() == 0) {
				JOptionPane.showMessageDialog(null, "Congrats, you won!");
			}
		}
	}

	public static void main(String[] args) {
		new HangMan().run();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
