package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import toDoList.Step;
import toDoList.Task;

public class AddElemForm extends JPanel implements ActionListener {

	private JButton addButton;
	private JTextField textField;
	private JPanel panelToAdd;
	private List<Task> list;
	private Task task;
	
	
	public AddElemForm(JPanel panelToAdd, List<Task> list){
		this.panelToAdd = panelToAdd;
		this.list = list;
		textField = new JTextField(20);
		addButton = new JButton("+");
		add(textField);
		addButton.addActionListener(this);
		add(addButton);
	}
	
	public AddElemForm(JPanel panelToAdd, Task task){
		this.panelToAdd = panelToAdd;
		this.task = task;
		textField = new JTextField(20);
		addButton = new JButton("+");
		add(textField);
		addButton.addActionListener(this);
		add(addButton);
	}
	
	public String getText() {
		return textField.getText();
	}
	
	public void actionPerformed(ActionEvent e) {
		ListElementPanel elemPanel;
		if(list != null) {
			 Task elem = new Task(this.getText());
			 list.add(0, elem);
			 elemPanel = new ListElementPanel(elem,list);
			 System.out.println("added task");
			 System.out.println(list.toString());
		}
		else {
			Step elem = new Step(this.getText());
			task.addStep(elem);
			elemPanel = new ListElementPanel(elem,task.getSteps());
			System.out.println("added step");

		}
		
		panelToAdd.add(elemPanel,0);
		panelToAdd.revalidate();
		panelToAdd.repaint();
		
		
		
//		panelToAdd.add();
	}
	
}
