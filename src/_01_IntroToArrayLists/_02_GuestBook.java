package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class _02_GuestBook implements ActionListener {

	JFrame frame;
	JPanel panel;
	JButton button1;
	JButton button2;
	String name;
	ArrayList<String> names = new ArrayList<String>();
	String book = "";
	JTextArea label;

	public void run() {

		frame = new JFrame();
		panel = new JPanel();
		button1 = new JButton();
		button2 = new JButton();
		label = new JTextArea();

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(label);

		button1.addActionListener(this);
		button2.addActionListener(this);
		button1.setText("Add Name");
		button2.setText("View Names");

		frame.pack();

	}
	// Create a GUI with two buttons. One button reads "Add Name" and the other
	// button reads "View Names".
	// When the add name button is clicked, display an input dialog that asks the
	// user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a
	// message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonClicked = (JButton) e.getSource();
		System.out.println(buttonClicked.getText());

		if (button1 == buttonClicked) {
			name = JOptionPane.showInputDialog("Please enter a name:");
			names.add(name);
		} else if (button2 == buttonClicked) {
			for (int i = 0; i < names.size(); i++) {
				book += "Guest #";
				book += i + 1;
				book += ": ";
				book += names.get(i);
				book += "\n";
			}
			// JOptionPane.showMessageDialog(null, book);
			label.setText(book);
			frame.pack();
		}
	}

}
