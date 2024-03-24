package toDoList;

import java.util.Date;

import ui.ListElementPanel;

public abstract class ListElement {
	private Date creationDate, finishDate;
	private boolean finished;
	private String name;
	private ListElementPanel panel;
	
	public ListElement(String name) {
		this.name = name;
		creationDate = new Date();
		finished = false;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
		if(finished) {
			finishDate = new Date();
			
			if(panel!= null) { panel.setFinishDate(finishDate);}
			
		}
		else {
			finishDate = null;
			panel.clearFinishDate();
		}
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public String getName() {
		return name;
	}

	public ListElementPanel getPanel() {
		return panel;
	}

	public void setPanel(ListElementPanel panel) {
		this.panel = panel;
	}
	
}
