package ui;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


import java.awt.event.ActionListener;
import java.io.Serializable;

public class AddElemForm implements Serializable{
	public JPanel panel;
	public JButton addButton;
	public JTextField textField;
	
	public AddElemForm(JPanel listPanel){
		panel = new JPanel();
		textField = new JTextField(20);
		addButton = new JButton("+");
		panel.add(textField);
		panel.add(addButton);
	}

	public void addBtnListener(ActionListener btnListener) {
		addButton.addActionListener(btnListener);
	}
	
	
}
