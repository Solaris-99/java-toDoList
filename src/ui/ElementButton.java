package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JButton;

import toDoList.ListElement;
import toDoList.Step;
import toDoList.Task;
import toDoList.TaskHandler;

public class ElementButton extends JButton implements ActionListener{
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
		}else {
			boolean isFinished = elem.isFinished();
			elem.setFinished(!isFinished);
			isFinished = !isFinished;
			Font font = new Font("helvetica", Font.BOLD, 12);
			Font newFont = font;
			Step step = (Step) elem;
			Task task = step.getTask();
			ElementButton taskButton = task.getPanel().getElementButton();
			
			if(isFinished) {
				boolean taskFinished = task.checkIsFinished();
				Map  attributes = font.getAttributes();
				attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
				newFont = new Font(attributes);
				if(taskFinished) {
					taskButton.setFont(newFont);
				}
			}
			else {
				taskButton.setFont(newFont);
				task.setFinished(false);
			}
			
			this.setFont(newFont);
		}
		handler.saveTasks();
	}
	
	
}
