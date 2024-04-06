package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;

import toDoList.ListElement;
import toDoList.Step;
import toDoList.Task;
import toDoList.TaskHandler;

public class ElementButton extends JButton implements ActionListener, Serializable{
	private ListElement elem;
	private TaskHandler handler;
	
	public ElementButton(ListElement elem, TaskHandler handler) {
		super(elem.getName());
		this.elem = elem;
		this.addActionListener(this);
		this.handler = handler;
		if(elem instanceof Task) {
			Task task = (Task) elem;
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(this.elem instanceof Task) {
			Layout taskLayout = new Layout((Task) elem, handler);
		}
		else {
			//step
			System.out.println("step actioned");
			boolean isFinished = elem.isFinished();
			isFinished = !isFinished;
			elem.setFinished(isFinished);
			
			Step step = (Step) elem;
			Task task = step.getTask();
			System.out.println("Checking for task...");
			task.checkIsFinished();	
			
		}
		handler.saveTasks();
	}
	
}
