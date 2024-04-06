package toDoList;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;

public class Task extends ListElement implements Serializable{ 
	private List<Step> steps;
	
	public Task(String name) {
		super(name);
		steps = new ArrayList<Step>();
	}

	public Task(String name, String creationDate,String finishDate){
		super(name);
		Date created;
		try{
			created = DATE_FORMATTER.parse(creationDate);
		}
		catch(ParseException e){
			throw new RuntimeException(e);
		}
		this.setCreationDate(created);
		this.setFinished(finishDate);
		this.steps = new ArrayList<Step>();
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}
	
	public void addStep(Step step) {
		this.steps.add(0,step);
	}
	
	@Override
	public String toString() {
		String selfString = super.toString();
		String stepsStrings = "";
		if(!steps.isEmpty()) {
			for (Step s : steps) {
				stepsStrings = stepsStrings + s +",";
			}
		}
		
		selfString = selfString + ">:"+stepsStrings + ";";
		
		return selfString;
	}
	
	public boolean checkIsFinished() {
		for (Step s: steps) {
			if(!s.isFinished()) {
				this.setFinished(false);
				return this.isFinished();
			}
		}
		System.out.println("task finished");
		this.setFinished(true);
		return this.isFinished();
	}
	

}
