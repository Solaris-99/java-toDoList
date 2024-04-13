package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Arrays;

import javax.swing.*;

import toDoList.ListElement;
import toDoList.Step;
import toDoList.Task;
import toDoList.TaskHandler;

public class ElementButton extends JButton implements ActionListener, Serializable{
	private ListElement elem;
	private TaskHandler handler;
	
	public ElementButton(ListElement elem, TaskHandler handler) {
		super(prepareText(elem.getName()));
		int height = Math.max(elem.getName().length(), 30);

		System.out.println(height);

		this.elem = elem;
		this.addActionListener(this);
		this.handler = handler;
		if(elem instanceof Task) {
			Task task = (Task) elem;
		}
		this.setForeground(DarkColor.TEXT_DARK);
		if(height > 30){
			if(height > 60){
				height = (int) height/2;
			}
			this.setHorizontalAlignment(SwingConstants.LEFT);
			this.setVerticalAlignment(SwingConstants.TOP);
		}
		this.setPreferredSize(new Dimension(200,height));

	}

	private static String prepareText(String text){
		int tolerance = 30;
		if(text.length()<tolerance){
			return text;
		}
		String[] split = text.split(" ");
		StringBuilder outputText = new StringBuilder();
		outputText.append("<html><p style='margin-left:5px'>");
		int accum = 0;
		for (String s : split){
			int length = s.length();
			if(length>tolerance){
				outputText.append(s).append("<br>");
				accum = 0;
			}
			else if(accum > tolerance){
				outputText.append(s).append("<br>");
				accum = 0;
			}
			else{
				accum+=length+1;
				outputText.append(s).append(" ");
			}
		}
		outputText.append("</p></html>");
		return outputText.toString();
	}

	public void actionPerformed(ActionEvent e) {
		if(this.elem instanceof Task) {
			Layout taskLayout = new Layout((Task) elem, handler);
			//TODO: open steps in same layout; go back to tasks button
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
