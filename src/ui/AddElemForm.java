package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import toDoList.Step;
import toDoList.Task;
import toDoList.TaskHandler;

public class AddElemForm extends JPanel implements ActionListener {

	private JButton addButton;
	private JTextField textField;
	private JPanel panelToAdd;
	private TaskHandler handler;
	private List<Task> list;
	private Task task;
	
	
	public AddElemForm(JPanel panelToAdd, TaskHandler handler){
		this.panelToAdd = panelToAdd;
		
		this.handler = handler;
		this.list = handler.getTasks();
		
		textField = new JTextField(20);
		addButton = new JButton("+");
		add(textField);
		addButton.addActionListener(this);
		add(addButton);
	}
	
	public AddElemForm(JPanel panelToAdd, TaskHandler handler, Task task){
		this.panelToAdd = panelToAdd;
		
		this.handler = handler;
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
	
	//adding tasks/steps
	public void actionPerformed(ActionEvent e) {
		ListElementPanel elemPanel;
		if(list != null) {
			 //adding a task
			 Task elem = new Task(this.getText());
			 list.add(0, elem);
			 
			 elemPanel = new ListElementPanel(elem,list,handler);
			 
			 elem.setPanel(elemPanel);
			 
			 System.out.println("added task");
			 System.out.println(list.toString());
		}
		else {
			//adding a step
			Step elem = new Step(this.getText(), task);
			task.addStep(elem);
			task.setFinished(false);
			System.out.println(task);
			elemPanel = new ListElementPanel(elem,task.getSteps(),handler);
			
			elem.setPanel(elemPanel);
			
			System.out.println("added step");

		}
		handler.saveTasks();
		handler.saveData();
		panelToAdd.add(elemPanel,0);
		panelToAdd.revalidate();
		panelToAdd.repaint();	
	}	
	
	
}
