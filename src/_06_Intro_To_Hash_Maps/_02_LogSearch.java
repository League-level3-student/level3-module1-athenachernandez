package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * 
	 * Create a GUI with three buttons. Button 1: Add Entry When this button is
	 * clicked, use an input dialog to ask the user to enter an ID number. After an
	 * ID is entered, use another input dialog to ask the user to enter a name. Add
	 * this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */
	HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
	JFrame frame;
	JPanel panel;
	JButton addEntry;
	JButton searchByID;
	JButton viewList;
	JLabel label;

	_02_LogSearch() {
		frame = new JFrame();
		panel = new JPanel();
		addEntry = new JButton();
		searchByID = new JButton();
		viewList = new JButton();
		label = new JLabel();
		frame.add(panel);
		panel.add(addEntry);
		panel.add(searchByID);
		panel.add(viewList);
		panel.add(label);
		addEntry.setText("Add Entry");
		searchByID.setText("Search by ID");
		viewList.setText("View List");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addEntry.addActionListener(this);
		searchByID.addActionListener(this);
		viewList.addActionListener(this);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * Button 1: Add Entry When this button is clicked, use an input dialog to ask
		 * the user to enter an ID number. After an ID is entered, use another input
		 * dialog to ask the user to enter a name. Add this information as a new entry
		 * to your HashMap.
		 */
		if (e.getSource() == addEntry) {
			String stringIDNumber = JOptionPane.showInputDialog("Enter an ID number:");
			int IDNumber = Integer.parseInt(stringIDNumber);
			String name = JOptionPane.showInputDialog("Enter a name:");
			hashmap.put(IDNumber, name);
		}
		/*
		 * Button 2: Search by ID When this button is clicked, use an input dialog to
		 * ask the user to enter an ID number. If that ID exists, display that name to
		 * the user. Otherwise, tell the user that that entry does not exist.
		 */
		if (e.getSource() == searchByID) {
			String stringIDNumber = JOptionPane.showInputDialog("Enter an ID number:");
			int IDNumber = Integer.parseInt(stringIDNumber);
			if (hashmap.containsKey(IDNumber)) {
				JOptionPane.showMessageDialog(null, hashmap.get(IDNumber));
			} else {
				JOptionPane.showMessageDialog(null, "That entry does not exist.");
			}
		}
		/*
		 * Button 3: View List When this button is clicked, display the entire list in a
		 * message dialog in the following format: 
		 * ID: 123 Name: Harry Howard 
		 * ID: 245 Name: Polly Powers 
		 * ID: 433 Name: Oliver Ortega etc...
		 */
		if (e.getSource() == viewList) {
			String text = "";
			for (int ID : hashmap.keySet()) {
				String name = hashmap.get(ID);
				text += "ID: " + ID + " Name: " + name + "<br>";
			
			}
			text = "<html>" + text + "</html>";
			label.setText(text);
			frame.pack();
		}

	}

	public static void main(String[] args) {
		_02_LogSearch logsearch = new _02_LogSearch();
	}

}
