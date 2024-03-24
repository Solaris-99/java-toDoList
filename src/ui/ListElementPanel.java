package ui;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import toDoList.ListElement;
import toDoList.TaskHandler;

public class ListElementPanel extends JPanel implements Serializable {
	
	private final Font defFont = new Font("helvetica", Font.BOLD, 12);
	private Font doneFont;
	private JLabel creationDatePanel, finishDatePanel;
	private ElementButton elementButton;
	private DeleteButton delButton;
	
	public ListElementPanel(ListElement elem, List<? extends ListElement> list, TaskHandler handler) {
		creationDatePanel = new JLabel(elem.getCreationDate().toString());
		elementButton = new ElementButton(elem, handler);
		delButton = new DeleteButton(elem,list, handler);
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
		
		if(elem.isFinished()) {
			setFinished(elem.getFinishDate());
		}
		
		setDoneFont();
	}
	
	public ElementButton getElementButton() {
		return elementButton;
	}
		
	public void clearFinishState() {
		System.out.println("Clearing panel finish state..");
		finishDatePanel.setText("P");
		elementButton.setFont(defFont);
	}
	
	public void setFinished(Date date) {
		System.out.println("Setting panel finish state..");
		String s = date.toString();
		finishDatePanel.setText(s);
		elementButton.setFont(doneFont);
	}
	
	private void setDoneFont() {
		Map attributes = defFont.getAttributes();
		attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
		doneFont = new Font(attributes);
	}
	
	
	
	
	
}
