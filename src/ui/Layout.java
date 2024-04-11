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
	private static Layout taskLayout;
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
		setSize(400, 600);
		setLocationRelativeTo(null);
		setTitle("To-Do List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(tasksPanel, BorderLayout.CENTER);


		setVisible(true);
		Layout.taskLayout = this;
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
		setLocation(Layout.taskLayout.getX()+400,Layout.taskLayout.getY());
		setSize(400, 600);
		setTitle(task.getName());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(tasksPanel, BorderLayout.CENTER);
		setVisible(true);
	}
	
}
