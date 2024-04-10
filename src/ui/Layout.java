package ui;
import java.awt.*;
import java.io.Serializable;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import toDoList.Step;
import toDoList.Task;
import toDoList.TaskHandler;


public class Layout extends JFrame implements Serializable {

	private final AddElemForm form;
	
	public Layout(TaskHandler handler) {
		List<Task> tasks = handler.getTasks();

		setLayout(new BorderLayout());
		JPanel tasksPanel = new JPanel();

		form = new AddElemForm(tasksPanel,handler);
		add(form, BorderLayout.NORTH);
		for(Task t: tasks) {
			ListElementPanel ePanel = new ListElementPanel(t,tasks,handler);
			t.setPanel(ePanel);
			tasksPanel.add(ePanel);
		}
		setBounds(50,50, 400, 600);
		setTitle("To-Do List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(tasksPanel, BorderLayout.CENTER);


		setVisible(true);
		
	}
	
	public Layout(Task task, TaskHandler handler) {
		
		setLayout(new BorderLayout());
		JPanel tasksPanel = new JPanel();
		form = new AddElemForm(tasksPanel,handler,task);
		add(form, BorderLayout.NORTH);
		List<Step> steps = task.getSteps();
 		for(Step t: steps) {
			ListElementPanel ePanel = new ListElementPanel(t,steps,handler);
			t.setPanel(ePanel);
			tasksPanel.add(ePanel);
		}
		setBounds(50,50, 400, 600);
		setTitle("To-Do List");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(tasksPanel, BorderLayout.CENTER);
		setVisible(true);
	}
	
}
