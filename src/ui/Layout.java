package ui;
import java.awt.*;
import java.io.Serializable;
import java.util.List;

import javax.swing.*;

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
		Header colHeader = new Header();
		form = new AddElemForm(tasksPanel,handler);
		JPanel topPanel = new JPanel();
		topPanel.add(form);
		topPanel.add(colHeader);
		BoxLayout topPanelLayout = new BoxLayout(topPanel,BoxLayout.Y_AXIS);
		topPanel.setLayout(topPanelLayout);
		add(topPanel, BorderLayout.NORTH);
		for(Task t: tasks) {
			ListElementPanel ePanel = new ListElementPanel(t,tasks,handler);
			t.setPanel(ePanel);
			tasksPanel.add(ePanel);
		}
		setSize(420, 600);
		setLocationRelativeTo(null);
		setTitle("To-Do List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tasksPanel.setLayout(new VerticalFlowLayout(VerticalFlowLayout.TOP));
		JScrollPane panelPane = new JScrollPane(tasksPanel,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panelPane.getVerticalScrollBar().setUnitIncrement(20);
		add(panelPane,BorderLayout.CENTER);
		setVisible(true);
		Layout.taskLayout = this;
	}

	public Layout(Task task, TaskHandler handler) {

		setLayout(new BorderLayout());
		JPanel tasksPanel = new JPanel();
		Header colHeader = new Header();
		form = new AddElemForm(tasksPanel,handler,task);
		JPanel topPanel = new JPanel();
		topPanel.add(form);
		topPanel.add(colHeader);
		BoxLayout topPanelLayout = new BoxLayout(topPanel,BoxLayout.Y_AXIS);
		topPanel.setLayout(topPanelLayout);
		add(topPanel, BorderLayout.NORTH);
		List<Step> steps = task.getSteps();
 		for(Step t: steps) {
			ListElementPanel ePanel = new ListElementPanel(t,steps,handler);
			t.setPanel(ePanel);
			tasksPanel.add(ePanel);
		}
		setLocation(Layout.taskLayout.getX()+420,Layout.taskLayout.getY());
		setSize(420, 600);
		setTitle(task.getName());
		tasksPanel.setLayout(new VerticalFlowLayout(VerticalFlowLayout.TOP));
		JScrollPane panelPane = new JScrollPane(tasksPanel,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panelPane.getVerticalScrollBar().setUnitIncrement(20);
		add(panelPane,BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
}
