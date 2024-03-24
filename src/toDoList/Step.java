package toDoList;

import java.io.Serializable;

import ui.ListElementPanel;

public class Step extends ListElement implements Serializable{
	private Task task;
	
	public Step(String description, Task task) {
		super(description);
		this.task = task;
	}
	
	public Task getTask() {
		return task;
	}
	
}
