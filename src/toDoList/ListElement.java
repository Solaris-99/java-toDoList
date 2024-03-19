package toDoList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class ListElement {
	protected JButton button;
	protected JButton delButton;
	protected String name;
	protected Date date;
	public JPanel panel;
	public Date finishDate;
	
	public ListElement(String name) {
		this.name = name;
		this.button = new JButton(name);
		this.delButton = new JButton("🚮");
		this.panel = new JPanel();
		panel.add(button);
		panel.add(delButton);
		this.date = new Date();
	}
	
	public String getName() {
		return this.name;
	}
	
	public JButton getButton(){
		return this.button;
	}
	
	public Date getDate() {
		return this.date;
	}
	
}
