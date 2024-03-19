package ui;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


import java.awt.event.ActionListener;

public class AddElemForm {
	public JPanel panel;
	public JButton addButton;
	public JTextField textField;
	
	public AddElemForm(JPanel listPanel){
		panel = new JPanel();
		addButton = new JButton("+");
		textField = new JTextField(20);
		panel.add(addButton);
		panel.add(textField);
	}

	public void addBtnListener(ActionListener btnListener) {
		addButton.addActionListener(btnListener);
	}
	
	
}
