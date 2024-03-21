package toDoList;
import java.util.ArrayList;
import java.util.List;

public class Task extends ListElement{ 
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
	

}
