package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JButton;

import toDoList.ListElement;
import toDoList.Task;

public class ElementButton extends JButton implements ActionListener{
	private ListElement elem;
	
	public ElementButton(ListElement elem) {
		super(elem.getName());
		this.elem = elem;
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(this.elem instanceof Task) {
			Layout taskLayout = new Layout((Task) elem);
		}else {
			boolean isFinished = elem.isFinished();
			elem.setFinished(!isFinished);
			isFinished = !isFinished;
			Font font = new Font("helvetica", Font.BOLD, 12);
			Font newFont = font;
			if(isFinished) {
				Map  attributes = font.getAttributes();
				attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
				newFont = new Font(attributes);
			}
			this.setFont(newFont);
		}
	}
	
	
}
