package toDoList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ui.ElementButton;
import ui.ListElementPanel;

public class Task extends ListElement implements Serializable{ 
	private List<Step> steps;
	
	public Task(String name) {
		super(name);
		steps = new ArrayList<Step>();
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
		return this.getName();
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
