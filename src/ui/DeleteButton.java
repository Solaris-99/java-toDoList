package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import toDoList.ListElement;
import toDoList.TaskHandler;

public class DeleteButton extends JButton implements ActionListener{
	ListElement elem;
	List<? extends ListElement> list;
	TaskHandler handler;
	
	public DeleteButton(ListElement elem, List<? extends ListElement> list, TaskHandler handler) {
		super("X");
		this.elem = elem;
		this.list = list;
		this.handler = handler;
		this.addActionListener(this);
		this.setForeground(DarkColor.TEXT_DARKEST);
		this.setBackground(DarkColor.ERASE);
	}

	
	public void actionPerformed(ActionEvent e){

		JPanel parentPanel = (JPanel) this.getParent();
		JPanel grandPPanel = (JPanel) parentPanel.getParent();
		list.remove(elem);
		grandPPanel.remove(parentPanel);
		grandPPanel.revalidate();
		grandPPanel.repaint();
		System.out.println("deleted");
		System.out.println(list.toString());
		handler.saveTasks();
	}
	
}
