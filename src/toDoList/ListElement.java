package toDoList;

import java.util.Date;

public abstract class ListElement {
	private Date creationDate, finishDate;
	private boolean finished;
	private String name;
	
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
		}
		else {
			finishDate = null;
		}
		
		
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public String getName() {
		return name;
	}
	
	
	
	
	
}
