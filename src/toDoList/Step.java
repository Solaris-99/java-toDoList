package toDoList;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import ui.ListElementPanel;

public class Step extends ListElement implements Serializable{
	private Task task;
	
	public Step(String description, Task task) {
		super(description);
		this.task = task;
	}

	public Step(String name, String creationDate, String finishDate, Task task){
		super(name);
		Date created;
		try{
			created = DATE_FORMATTER.parse(creationDate);
		}
		catch(ParseException e){
			throw new RuntimeException(e);
		}
		this.task = task;
		this.setCreationDate(created);
		this.setFinished(finishDate);
	}
	
	public Task getTask() {
		return task;
	}
	
}
