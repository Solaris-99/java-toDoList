package ui;

import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import toDoList.ListElement;

public class ListElementPanel extends JPanel {
	
	JLabel creationDatePanel, finishDatePanel;
	ElementButton elementButton;
	DeleteButton delButton;
	
	public ListElementPanel(ListElement elem, List<? extends ListElement> list) {
		creationDatePanel = new JLabel(elem.getCreationDate().toString());
		elementButton = new ElementButton(elem);
		delButton = new DeleteButton(elem,list);
		if(elem.isFinished()) {
			finishDatePanel = new JLabel(elem.getFinishDate().toString());
		}
		else {
			finishDatePanel = new JLabel("P");
		}
		
		add(creationDatePanel);
		add(elementButton);
		add(finishDatePanel);
		add(delButton);
	}
	
	public ElementButton getElementButton() {
		return elementButton;
	}
	
	public void setFinishDate(Date date) {
		String s = date.toString();
		finishDatePanel.setText(s);
	}
	
	public void clearFinishDate() {
		finishDatePanel.setText("P");
	}
	
	
}
